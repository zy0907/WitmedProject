package com.whackon.witmed.system.admin;

import cn.hutool.crypto.digest.MD5;
import com.whackon.witmed.base.controller.BaseController;
import com.whackon.witmed.base.pojo.enums.StatusEnum;
import com.whackon.witmed.base.pojo.vo.ResponseVO;
import com.whackon.witmed.base.util.BaseConstants;
import com.whackon.witmed.base.util.RedisUtil;
import com.whackon.witmed.base.util.TokenUtil;
import com.whackon.witmed.system.admin.pojo.vo.AdminLoginVO;
import com.whackon.witmed.system.admin.pojo.vo.AdminRouterInfo;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.admin.pojo.vo.RouterVO;
import com.whackon.witmed.system.admin.transport.AdminTransport;
import com.whackon.witmed.system.admin.transport.MenuTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统人员控制层类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
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
	 * <b>系统用户登录</b>
	 * @param adminLoginVO
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	public ResponseVO loginAdmin(@RequestBody@Validated AdminLoginVO adminLoginVO, BindingResult bindingResult)
			throws Exception {
		// 校验登录信息是否有效
		if (bindingResult.hasErrors()) {
			// 登录时所提交的信息有误
			return ResponseVO.errorResponseVO("未填写正确的登录信息");
		}
		// 根据手机号码查询用户信息
		AdminVO adminVO = adminTransport.getByCellphone(adminLoginVO.getCellphone());
		// 判断能够获得有效的登录信息
		if (adminVO == null) {
			// 根据手机号码未查询到有效的登录信息
			return ResponseVO.errorResponseVO("手机号码或者登录密码错误");
		}
		// 判断该用户是否处于禁用状态
		if (StatusEnum.STATUS_DISABLE.getCode().equals(adminVO.getStatus())) {
			// 该用户处于禁用状态
			return ResponseVO.errorResponseVO("该用户已被禁止登录系统");
		}
		// 用户处于启用状态，则对用户所提交的登录密码进行加密进行判断
		if (!adminVO.getPassword().equals(MD5.create().digestHex(adminLoginVO.getPassword()))) {
			return ResponseVO.errorResponseVO("手机号码或者登录密码错误");
		}
		// 用户登录成功，则根据当前用户信息生成 Token
		String token = TokenUtil.createToken(adminVO, BaseConstants.BASE_TOKEN_EXPIRE);
		// 将 Token 作为 Key，存储到 Redis 中
		redisUtil.saveToRedis(token, adminVO, BaseConstants.BASE_TOKEN_EXPIRE);
		// 将 Token 返回当前登录用户
		return ResponseVO.successResponseVO("登录成功", token);
	}

	/**
	 * <b>根据 Token 获得用户信息</b>
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/info")
	public ResponseVO getInfoByToken(String token) throws Exception {
		// 通过 Token 从 Redis 中获得当前登录用户信息
		AdminVO adminVO = (AdminVO) redisUtil.findFromRedis(token, AdminVO.class);
		if (adminVO != null) {
			// 根据用户角色信息获得当前用户角色所对应的功能路由信息
			List<RouterVO> routerVOList = menuTransport.getRouterVOByRole(adminVO.getRoleVO());
			// 将当前登录用户信息和该用户路由列表封装为最终结果
			AdminRouterInfo adminRouterInfo = new AdminRouterInfo(adminVO, routerVOList);
			return ResponseVO.successResponseVO("获得用户信息", adminRouterInfo);
		}
		return ResponseVO.unAuthResponseVO();
	}
}
