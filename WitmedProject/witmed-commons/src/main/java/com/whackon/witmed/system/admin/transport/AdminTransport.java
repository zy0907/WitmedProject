package com.whackon.witmed.system.admin.transport;

import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统人员传输层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/17
 * @since 1.0.0
 */
@FeignClient(name = "witmed-system-provider")
//@RequestMapping("/system/admin/admin/trans")
public interface AdminTransport {
	/**
	 * <b>根据手机号码查询信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/system/admin/admin/trans/cellphone")
	AdminVO getByCellphone(@RequestParam String cellphone) throws Exception;
}
