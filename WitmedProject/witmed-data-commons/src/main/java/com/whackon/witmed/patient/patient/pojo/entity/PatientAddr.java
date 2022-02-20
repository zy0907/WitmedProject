package com.whackon.witmed.patient.patient.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 病人联系地址实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("pa_patient_addr")
public class PatientAddr extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.NONE)
	private String id;                      // 主键
	@TableField(value = "patient")
	private String patient;                 // 病人信息
	@TableField(value = "addrCat")
	private String addrCat;                 // 地址类别
	@TableField(value = "province")
	private String province;                // 地址-省（自治区、直辖市）
	@TableField(value = "city")
	private String city;                    // 地址-市（地区）
	@TableField(value = "county")
	private String county;                  // 地址-县（区）
	@TableField(value = "countryside")
	private String countryside;             // 地址-乡（镇、街道办事处）
	@TableField(value = "village")
	private String village;                 // 地址-村（街、路、弄等）
	@TableField(value = "doorNo")
	private String doorNo;                  // 地址-门牌号码
	@TableField(value = "zipcode")
	private String zipcode;                 // 邮政编码
}