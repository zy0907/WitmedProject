package com.whackon.witmed.emr.clinic.transport.impl;

import com.whackon.witmed.emr.clinic.transport.ClinicTransport;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 门（急）诊病历传输层接口实现类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@Service("clinicTransport")
@RequestMapping("/emr/resume/clinic/trans")
public class ClinicTransportImpl implements ClinicTransport {
}
