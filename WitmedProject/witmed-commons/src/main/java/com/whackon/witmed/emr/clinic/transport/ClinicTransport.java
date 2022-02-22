package com.whackon.witmed.emr.clinic.transport;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 门（急）诊病历传输层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@FeignClient(name = "witmed-emr-provider")
//@RequestMapping("/emr/resume/clinic/trans")
public interface ClinicTransport {
}
