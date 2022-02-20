package com.whackon.witmed.patient.patient.service;

import com.whackon.witmed.patient.patient.pojo.vo.IdInfoVO;
import com.whackon.witmed.patient.patient.pojo.vo.PatientVO;

/**
 * <b>智慧医疗信息平台 - 患者功能 - 患者业务层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
public interface PatientService {
	/**
	 * <b>根据证件号码查询患者信息</b>
	 * @param idNo
	 * @return
	 * @throws Exception
	 */
	PatientVO getByIdNo(String idNo) throws Exception;

	/**
	 * <b>根据患者证件信息进行保存</b>
	 * @param idInfoVO
	 * @return
	 * @throws Exception
	 */
	PatientVO saveByIdInfo(IdInfoVO idInfoVO) throws Exception;
}
