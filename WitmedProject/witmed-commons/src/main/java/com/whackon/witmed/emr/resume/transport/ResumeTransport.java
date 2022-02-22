package com.whackon.witmed.emr.resume.transport;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 病历概要数据传输层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@FeignClient("witmed-emr-provider")
//@RequestMapping("/emr/resume/resume/trans")
public interface ResumeTransport {
}
