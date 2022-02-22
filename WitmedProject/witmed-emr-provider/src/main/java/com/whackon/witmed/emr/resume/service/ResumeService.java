package com.whackon.witmed.emr.resume.service;

import com.whackon.witmed.emr.resume.pojo.vo.ResumeVO;
import com.whackon.witmed.opc.register.pojo.vo.RegisterRecordVO;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 病历概要数据业务层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
public interface ResumeService {
	/**
	 * <b>增加病历概要信息</b>
	 * @param registerRecordVO
	 * @return
	 * @throws Exception
	 */
	ResumeVO saveByRegisterRecordVO(RegisterRecordVO registerRecordVO) throws Exception;
}
