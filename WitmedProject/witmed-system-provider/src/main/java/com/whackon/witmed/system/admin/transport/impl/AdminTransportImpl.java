package com.whackon.witmed.system.admin.transport.impl;

import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.admin.service.AdminService;
import com.whackon.witmed.system.admin.transport.AdminTransport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统用户传输层接口实现类</b>
 *
 * @author zyuan
 * @date 2022/1/19
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("adminTransport")
@RequestMapping("/system/admin/admin/trans")
public class AdminTransportImpl implements AdminTransport {
	@Resource(name = "adminService")
	private AdminService adminService;

	/**
	 * <b>根据手机号码查询系统用户视图信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	@Override
	public AdminVO getAdminVOByCellphone(@RequestParam String cellphone) throws Exception {
		return adminService.getAdminVOByCellphone(cellphone);
	}
}
