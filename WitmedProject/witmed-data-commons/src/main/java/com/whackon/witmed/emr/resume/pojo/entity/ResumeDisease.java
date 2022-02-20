package com.whackon.witmed.emr.resume.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 病历概要数据疾病（外伤）史详情实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("emr_resume_disease")
public class ResumeDisease extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.NONE)
	private String id;                      // 主键
	@TableField(value = "emrResume")
	private String emrResume;               // 所属病历概要数据
	@TableField(value = "history")
	private String history;                 // 既往疾病史
	@TableField(value = "mentalDxName")
	private String mentalDxName;            // 既往精神类疾病诊断名称
	@TableField(value = "diseaseName")
	private String diseaseName;             // 既往疾病名称
	@TableField(value = "diseaseCode")
	private String diseaseCode;             // 既往疾病代码
	@TableField(value = "diseaseDxOrg")
	private String diseaseDxOrg;            // 既往疾病诊断机构
	@TableField(value = "dxOrgLevelCode")
	private String dxOrgLevelCode;          // 既往疾病诊断机构级别代码
	@TableField(value = "diseaseDxTime")
	private Date diseaseDxTime;             // 既往疾病诊断时间
	@TableField(value = "diseaseStatus")
	private String diseaseStatus;           // 疾病当前状态代码
}