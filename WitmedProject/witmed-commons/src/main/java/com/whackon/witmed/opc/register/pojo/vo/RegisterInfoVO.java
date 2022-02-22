package com.whackon.witmed.opc.register.pojo.vo;

import com.whackon.witmed.patient.patient.pojo.vo.IdInfoVO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <b>智慧医疗信息平台 - 门诊功能 - 患者挂号视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@Data
public class RegisterInfoVO implements Serializable {
	private static final long serialVersionUID = -5329673760975686870L;
	@NotNull
	private IdInfoVO idInfoVO;                          // 患者证件信息
	@NotNull
	private Long deptId;                                // 挂号科室信息
	private String doctorId;                            // 挂号医生信息
}
