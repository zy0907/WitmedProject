package com.whackon.witmed.opc.register.transport;

import com.whackon.witmed.opc.dto.RegisterDto;
import com.whackon.witmed.opc.register.pojo.vo.RegisterRecordVO;
import com.whackon.witmed.opc.register.service.RegisterService;
import com.whackon.witmed.opc.schedule.pojo.vo.DoctorScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>智慧医疗信息平台 - 门诊功能 - 患者就诊传输层接口实现类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@RestController("registerTransport")
@RequestMapping("/opc/register/register/trans")
public class RegisterTransportImpl implements RegisterTransport {
	@Autowired
	private RegisterService registerService;

	/**
	 * <b>根据患者所选择的科室自动匹配医生信息</b>
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/matchdocauto")
	@Override
	public DoctorScheduleVO matchDocForAuto(@RequestParam Long deptId) throws Exception {
		return registerService.matchDocForAuto(deptId);
	}

	/**
	 * <b>根据所制定的医生进行查询</b>
	 * @param doctorId
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/matchdocpatient")
	public DoctorScheduleVO matchDocForPatient(@RequestParam String doctorId) throws Exception {
		return registerService.matchDocForPatient(doctorId);
	}

	/**
	 * <b>保存挂号信息</b>
	 * @param registerDto
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public RegisterRecordVO save(@RequestBody RegisterDto registerDto) throws Exception {
		return registerService.save(registerDto);
	}
}
