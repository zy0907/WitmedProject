package com.whackon.witmed.system.admin.transport.impl;

import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.admin.service.AdminService;
import com.whackon.witmed.system.admin.transport.AdminTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统人员传输层接口实现类</b>
 *
 * @author zyuan
 * @version 1.0.0
 * @date 2022/2/17
 * @since 1.0.0
 */
@RestController("adminTransport")
@RequestMapping("/system/admin/admin/trans")
public class AdminTransportImpl implements AdminTransport {
	@Autowired
	private AdminService adminService;

	/**
	 * <b>根据手机号码查询信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/cellphone")
	@Override
	public AdminVO getByCellphone(@RequestParam String cellphone) throws Exception {
		return adminService.getByCellphone(cellphone);
	}
}
