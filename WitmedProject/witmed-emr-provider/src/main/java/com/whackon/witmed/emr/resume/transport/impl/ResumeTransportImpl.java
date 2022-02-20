package com.whackon.witmed.emr.resume.transport.impl;

import com.whackon.witmed.emr.resume.transport.ResumeTransport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 病历概要数据传输层接口实现类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@RestController("resumeTransport")
@RequestMapping("/emr/resume/resume/trans")
public class ResumeTransportImpl implements ResumeTransport {
}
