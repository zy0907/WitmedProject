package com.whackon.witmed.system.admin;

import cn.hutool.crypto.digest.MD5;
import com.whackon.witmed.base.controller.BaseController;
import com.whackon.witmed.base.pojo.enums.Status;
import com.whackon.witmed.base.pojo.vo.ResponseVO;
import com.whackon.witmed.base.util.BaseConstants;
import com.whackon.witmed.base.util.RedisUtil;
import com.whackon.witmed.base.util.TokenUtil;
import com.whackon.witmed.system.admin.pojo.vo.AdminLoginVO;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.admin.transport.AdminTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>系统功能 - 系统用户控制层类</b>
 *
 * @author zyuan
 * @date 2022/1/6
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("adminController")
@RequestMapping("/system/admin/admin")
public class AdminController extends BaseController {
	@Autowired
	private AdminTransport adminTransport;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * <b>用户使用登录视图进行用户登录操作</b>
	 * @param adminLoginVO
	 * @param result
	 * @return
	 * @throws Exception
	 */
	//@RequestBody返回的是json  @Validated用于校验
	public ResponseVO loginAdmin(@RequestBody @Validated AdminLoginVO adminLoginVO, BindingResult result)
			throws Exception {
		// 判断错误信息对象 BindingResult 中是是否包含有错误信息
		if (result.hasErrors()) {
			return ResponseVO.error("手机号码和登录密码错误");
		}
		// 用户信息校验成功，根据手机号码查询用户信息
		AdminVO adminVO = adminTransport.getAdminVOByCellphone(adminLoginVO.getCellphone());
		// 判断所得到的用户信息是否存在
		if (adminVO == null) {
			// 此时根据手机号码获得的用户信息不存在
			return ResponseVO.error("手机号码或登录密码错误");
		}
		// 用户存在，则判断用户此时是否处于启用状态
		if (Status.STATUS_DISABLE.getCode().equals(adminVO.getStatus())) {
			// 此时用户的状态是禁用状态
			return ResponseVO.error("该用户禁止登录系统");
		}
		// 用户处于启用状态，则对该用户登录密码进行加密，并且判断密码是否相同
		String password = MD5.create().digestHex(adminLoginVO.getPassword());
		if (!adminVO.getPassword().equals(password)) {
			// 此时用户密码错误
			return ResponseVO.error("手机号码或登录密码错误");
		}
		// 登录密码正确，登录成功，生成系统唯一令牌（Token）
		Map<String, String> claimMap = new HashMap<String, String>();
		claimMap.put("id", adminVO.getId());
		String token = TokenUtil.createToken(claimMap, BaseConstants.EXPIRE_AUTH_SEC);
		// 以该 Token 作为 Key，以用户对象作为 Value 存到 Redis 中  但是时间不是永久的 一般都是30分钟
		if (redisUtil.saveToRedis(token, adminVO, BaseConstants.EXPIRE_AUTH_SEC)) {
			// 将信息存到 Redis，将 Token 返回给用户
			// 为了将 Token 交给用户存储，那么我们可以选择将 Token 绑定到 HTTP 响应对象的消息头的部分 Authorization
			//每个响应都存在这个特殊的消息头 Authorization 不再用以前自己写的方式了
			response.setHeader("Authorization", token);
			// 返回前端登录成功结果
			return ResponseVO.success("系统用户登录成功", adminVO);
		}
		return ResponseVO.error("系统登录失败");
	}
}
