package com.whackon.witmed.opc.register.service;

import com.whackon.witmed.opc.dto.RegisterDto;
import com.whackon.witmed.opc.register.pojo.vo.RegisterRecordVO;
import com.whackon.witmed.opc.schedule.pojo.vo.DoctorScheduleVO;

/**
 * <b>智慧医疗信息平台 - 门诊功能 - 患者就诊业务层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
public interface RegisterService {
	/**
	 * <b>根据患者所选择的科室自动匹配医生信息</b>
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	DoctorScheduleVO matchDocForAuto(Long deptId) throws Exception;

	/**
	 * <b>根据所制定的医生进行查询</b>
	 * @param doctorId
	 * @return
	 * @throws Exception
	 */
	DoctorScheduleVO matchDocForPatient(String doctorId) throws Exception;

	/**
	 * <b>保存挂号信息</b>
	 * @param registerDto
	 * @return
	 * @throws Exception
	 */
	RegisterRecordVO save(RegisterDto registerDto) throws Exception;
}
