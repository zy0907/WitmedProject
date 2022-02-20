package com.whackon.witmed.opc.register;

import com.whackon.witmed.base.controller.BaseController;
import com.whackon.witmed.base.pojo.vo.ResponseVO;
import com.whackon.witmed.emr.clinic.transport.ClinicTransport;
import com.whackon.witmed.emr.resume.transport.ResumeTransport;
import com.whackon.witmed.opc.register.pojo.vo.RegisterInfoVO;
import com.whackon.witmed.opc.register.transport.RegisterTransport;
import com.whackon.witmed.patient.patient.pojo.vo.PatientVO;
import com.whackon.witmed.patient.patient.transport.PatientTransport;
import com.whackon.witmed.system.hospital.transport.DepartmentTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>智慧医疗信息平台 - 门诊功能 - 挂号控制层类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@RestController("registerController")
@RequestMapping("/opc/register/register")
public class RegisterController extends BaseController {
	@Autowired
	private PatientTransport patientTransport;
	@Autowired
	private RegisterTransport registerTransport;
	@Autowired
	private DepartmentTransport departmentTransport;
	@Autowired
	private ResumeTransport resumeTransport;
	@Autowired
	private ClinicTransport clinicTransport;

	/**
	 * <b>根据挂号信息进行门诊挂号</b>
	 * @param registerInfoVO
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/doc")
	public ResponseVO registryForDoc(@RequestBody@Validated RegisterInfoVO registerInfoVO,
	                                 BindingResult bindingResult) throws Exception {
		// 校验所提供的挂号信息是否有效
		if (bindingResult.hasErrors()) {
			return ResponseVO.errorResponseVO("挂号信息有误");
		}
		// 根据身份证号码获得该患者信息
		PatientVO patientVO = patientTransport.getByIdNo(registerInfoVO.getIdInfoVO().getIdNo());
		if (patientVO == null) {
			// 未查询到该患者信息，那么生成该患者信息并且进行保存
			patientVO = patientTransport.saveByIdInfo(registerInfoVO.getIdInfoVO());
		}
//		AdminVO doctorVO = null;
//		// 判断此时患者是否指定所需要接诊的医生
//		if (registerInfoVO.getDoctorId() == null) {
//			// 如果未确定接诊医生，则根据所挂号科室自动匹配接诊医生
//			doctorVO = registerTransport.matchDocForAuto(registerInfoVO.getDeptId());
//		} else {
//			// 此时已经选择了接诊医生，那么根据此时时间，判断是否该医生有号码，并且获得该医生具体信息
//			doctorVO = registerTransport.matchDocForPatient(registerInfoVO.getDoctorId());
//		}
//		// 该医生是否还有号可以进行接诊
//		if (doctorVO == null) {
//			// 此时该医生今日的号已经全部挂完，因此无法继续接诊
//			return ResponseVO.errorResponseVO("今日医生所挂号数量已满，无法接诊");
//		}
//		// 根据患者所挂号的科室信息获得该科室视图对象
//		DepartmentVO departmentVO = departmentTransport.getById(registerInfoVO.getDeptId());
//		// 保存本次患者就诊信息
//		RegisterRecordVO saveVO = new RegisterRecordVO();
//		saveVO.setEmrNo(patientVO.getEmrNo());
//		saveVO.setPatientVO(patientVO);
//		saveVO.setDoctorVO(doctorVO);
//		saveVO.setDepartmentVO(departmentVO);
//		RegisterRecordVO registerRecordVO = registerTransport.save(saveVO);
//		// 完成医生匹配后，生成病历概要数据
//		ResumeVO resumeVO = resumeTransport.saveByRegisterRecordVO(registerRecordVO);
//		// 生成门诊病历数据
//		ClinicVO clinicVO = clinicTransport.saveByRegisterRecordVO(registerRecordVO);
//		// 将本次患者就诊号进行返回
//		if (resumeVO != null && clinicVO != null) {
//			return ResponseVO.successResponseVO("挂号成功");
//		}
		return ResponseVO.errorResponseVO("挂号失败");
	}
}
