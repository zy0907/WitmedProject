package com.whackon.witmed.system.admin.transport;

import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <b>系统功能 - 系统用户传输层接口</b>
 *
 * @author zyuan
 * @date 2022/1/6
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "witmed-system-provider")
//对应的应用名称 resources 里面配 项目名字 什么就写什么
public interface AdminTransport {
	/**
	 * <b>根据手机号码查询用户信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/system/admin/admin/trans/cellphone")
	//@RequestParam传递参数的注解
	AdminVO getAdminVOByCellphone(@RequestParam String cellphone) throws Exception;
}
