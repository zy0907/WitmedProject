package com.whackon.witmed.patient.patient.transport.impl;

import com.whackon.witmed.patient.patient.pojo.vo.IdInfoVO;
import com.whackon.witmed.patient.patient.pojo.vo.PatientVO;
import com.whackon.witmed.patient.patient.service.PatientService;
import com.whackon.witmed.patient.patient.transport.PatientTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>智慧医疗信息平台 - 患者功能 - 患者传输层接口实现类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@RestController("patientTransport")
@RequestMapping("/patient/patient/patient/trans")
public class PatientTransportImpl implements PatientTransport {
	@Autowired
	private PatientService patientService;

	/**
	 * <b>根据证件号码查询患者信息</b>
	 * @param idNo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/idNo")
	@Override
	public PatientVO getByIdNo(@RequestParam String idNo) throws Exception {
		return patientService.getByIdNo(idNo);
	}

	/**
	 * <b>根据患者证件信息进行保存</b>
	 * @param idInfoVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/savebyidinfo")
	@Override
	public PatientVO saveByIdInfo(@RequestBody IdInfoVO idInfoVO) throws Exception {
		return patientService.saveByIdInfo(idInfoVO);
	}
}
