package com.whackon.witmed.patient.patient.transport;

import com.whackon.witmed.patient.patient.pojo.vo.IdInfoVO;
import com.whackon.witmed.patient.patient.pojo.vo.PatientVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <b>智慧医疗信息平台 - 患者功能 - 患者传输层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@FeignClient(name = "witmed-patient-provider")
//@RequestMapping("/patient/patient/patient/trans")
public interface PatientTransport {
	/**
	 * <b>根据证件号码查询患者信息</b>
	 * @param idNo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/patient/patient/patient/trans/idNo")
	PatientVO getByIdNo(@RequestParam String idNo) throws Exception;

	/**
	 * <b>根据患者证件信息进行保存</b>
	 * @param idInfoVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/patient/patient/patient/trans/savebyidinfo")
	PatientVO saveByIdInfo(@RequestBody IdInfoVO idInfoVO) throws Exception;
}
