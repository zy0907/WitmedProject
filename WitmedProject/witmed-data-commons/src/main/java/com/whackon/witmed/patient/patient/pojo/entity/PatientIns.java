package com.whackon.witmed.patient.patient.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 病人医保实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("pa_patient_ins")
public class PatientIns extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.NONE)
	private String id;                      // 主键
	@TableField(value = "patient")
	private String patient;                 // 病人信息
	@TableField(value = "insCat")
	private String insCat;                  // 医疗保险-类别
	@TableField(value = "treatment")
	private String treatment;               // 医疗待遇
}