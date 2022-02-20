package com.whackon.witmed.patient.patient.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 病人通信实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("pa_patient_comm")
public class PatientComm extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.NONE)
	private String id;                      // 主键
	@TableField(value = "patient")
	private String patient;                 // 所属病历概要数据
	@TableField(value = "phoneCat")
	private String phoneCat;                // 联系电话-类别
	@TableField(value = "phoneNo")
	private String phoneNo;                 // 联系电话-号码
	@TableField(value = "email")
	private String email;                   // 电子邮件地址
}