package com.whackon.witmed.opc.register.transport;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * <b>智慧医疗信息平台 - 门诊功能 - 患者就诊传输层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@FeignClient(name = "witmed-opc-provider")
//@RequestMapping("/opc/register/register/trans")
public interface RegisterTransport {
}
