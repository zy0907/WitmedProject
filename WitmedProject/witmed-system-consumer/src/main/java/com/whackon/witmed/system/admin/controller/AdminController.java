package com.whackon.witmed.system.admin.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import com.whackon.witmed.base.controller.BaseController;
import com.whackon.witmed.base.pojo.enums.StatusEnum;
import com.whackon.witmed.base.pojo.vo.ResponseVO;
import com.whackon.witmed.base.util.BaseConstants;
import com.whackon.witmed.base.util.RedisUtil;
import com.whackon.witmed.base.util.TokenUtil;
import com.whackon.witmed.system.admin.pojo.vo.*;
import com.whackon.witmed.system.admin.transport.AdminTransport;
import com.whackon.witmed.system.admin.transport.MenuTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统用户控制层类</b>
 *
 * @author zyuan
 * @date 2022/1/19
 * @version 1.0.0
 * @since 1.0.0
 */
@CrossOrigin
@RestController("adminController")
@RequestMapping("/system/admin/admin")
public class AdminController extends BaseController {
	@Autowired
	private AdminTransport adminTransport;
	@Autowired
	private MenuTransport menuTransport;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * <b>使用登录视图进行登录操作，登录成功返回 Token 信息</b>
	 * @param adminLoginVO
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	public ResponseVO loginAdmin(@RequestBody@Validated AdminLoginVO adminLoginVO, BindingResult bindingResult)
			throws Exception {
		// 判断格式校验是否通过
		if (bindingResult.hasErrors()) {
			// 所提交的登录信息有误
			return ResponseVO.errorResponseVO("请填写正确的登录信息");
		}

		// 校验通过，则根据手机号码查询用户信息
		AdminVO adminVO = adminTransport.getAdminVOByCellphone(adminLoginVO.getCellphone());
		// 判断是否能够获得该用户信息
		if (adminVO == null) {
			// 通过手机号码未找到用户信息
			return ResponseVO.errorResponseVO("手机号码或登录密码错误");
		}

		// 根据手机号码获得用户信息
		// 判断该用户是否处于启用状态
		if (StatusEnum.STATUS_DISABLE.getCode().equals(adminVO.getStatus())) {
			// 该用户处于禁用状态
			return ResponseVO.errorResponseVO("该用户被禁止进入系统，请联系管理员");
		}

		// 用户处于启用状态，判断登录密码是否相同
		if (!adminVO.getPassword().equals(MD5.create().digestHex(adminLoginVO.getPassword()))) {
			// 用户所提交的登录密码和系统设定的登录密码不相同
			return ResponseVO.errorResponseVO("手机号码或登录密码错误");
		}

		// 登录密码正确，则用户完成登录，根据用户信息生成 Token
		String token = TokenUtil.createToken(adminVO, BaseConstants.BASE_TOKEN_EXPIRE);
		// 判断能够获得一个有效的 Token 信息
		if (StrUtil.isNotBlank(token)) {
			// 将 Token 作为 Key 存储到 Redis 中
			if (redisUtil.saveToRedis(token, adminVO, BaseConstants.BASE_TOKEN_EXPIRE)) {
				// 保存到 Token 成功，返回前端数据
				adminLoginVO.setToken(token);
				return ResponseVO.successResponseVO("登录成功", adminLoginVO);
			}
		}
		return ResponseVO.errorResponseVO("登录失败");
	}

	/**
	 * <b>通过 Token 信息获得当前登录系统用户信息</b>
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/info")
	public ResponseVO queryAdminVOByToken(String token) throws Exception {
		// 校验 Token 信息是否有效
		if (TokenUtil.verifyToken(token, AdminVO.class) != null) {
			// 该 Token 信息有效，则可以通过 Token 信息获得当前存储在 Redis 中用户信息
			AdminVO adminVO = (AdminVO) redisUtil.findFromRedis(token, AdminVO.class);
			if (adminVO != null) {
				// 通过 Redis 能够获得相关信息，则通过该登录用户的角色获得对应的路由列表
				// 获得当前登录用户角色信息
				RoleVO roleVO = adminVO.getRoleVO();
				// 根据角色获取路由列表
				List<RouterVO> routerVOList = menuTransport.getRouterVOListByRoleVO(roleVO);
				// 将对应的信息封装到 AdminInfo 视图中，返回前端
				AdminInfo adminInfo = new AdminInfo(adminVO, routerVOList);
				return ResponseVO.successResponseVO("获取用户信息成功", adminInfo);
			}
		}
		return ResponseVO.errorResponseVO("未获得当前用户信息");
	}
}
