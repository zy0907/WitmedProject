package com.whackon.witmed.opc.register.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import com.whackon.witmed.patient.patient.pojo.vo.PatientVO;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.hospital.pojo.vo.DepartmentVO;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 门诊功能 - 患者就诊视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@Data
public class RegisterRecordVO extends BaseVO {
	private static final long serialVersionUID = -3896623494934817432L;
	private String id;                      // 主键
	private PatientVO patientVO;            // 病人信息
	private String emrNo;                   // 病历号
	private String clinicNo;                // 门诊号
	private DepartmentVO departmentVO;      // 科室信息
	private AdminVO doctorVO;               // 医生信息
}
