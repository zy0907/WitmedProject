package com.whackon.witmed.emr.resume.transport.impl;

import com.whackon.witmed.emr.resume.pojo.vo.ResumeVO;
import com.whackon.witmed.emr.resume.service.ResumeService;
import com.whackon.witmed.emr.resume.transport.ResumeTransport;
import com.whackon.witmed.opc.register.pojo.vo.RegisterRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@Autowired
	private ResumeService resumeService;

	/**
	 * <b>增加病历概要信息</b>
	 * @param registerRecordVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public ResumeVO saveByRegisterRecordVO(@RequestBody RegisterRecordVO registerRecordVO) throws Exception {
		return resumeService.saveByRegisterRecordVO(registerRecordVO);
	}
}
