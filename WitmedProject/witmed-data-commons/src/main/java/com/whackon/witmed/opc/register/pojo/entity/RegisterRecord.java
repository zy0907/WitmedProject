package com.whackon.witmed.opc.register.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 门诊功能 - 患者就诊实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("opc_register_record")
public class RegisterRecord extends BaseEntity {
	private static final long serialVersionUID = -3360096943345190421L;
	@TableId(type = IdType.NONE)
	private String id;                      // 主键
	@TableField(value = "patient")
	private String patient;                 // 病人信息
	@TableField(value = "emrNo")
	private String emrNo;                   // 病历号
	@TableField(value = "clinicNo")
	private String clinicNo;                // 门诊号
	@TableField(value = "department")
	private String department;              // 科室信息
	@TableField(value = "doctor")
	private String doctor;                  // 医生信息
}
