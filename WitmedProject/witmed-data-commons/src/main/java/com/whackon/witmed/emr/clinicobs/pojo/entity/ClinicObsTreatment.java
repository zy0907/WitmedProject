package com.whackon.witmed.emr.clinicobs.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 急诊留观病历治疗详情实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("emr_clinic_obs_treatment")
public class ClinicObsTreatment extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.NONE)
	private String id;                      // 主键
	@TableField(value = "emrClinicObs")
	private String emrClinicObs;            // 所属急诊留观病历
	@TableField(value = "planCheck")
	private String planCheck;               // 拟做的检查
	@TableField(value = "trtSchPlan")
	private String trtSchPlan;              // 今后治疗方案
	@TableField(value = "followMark")
	private String followMark;              // 随访标志
	@TableField(value = "followInr")
	private String followInr;               // 随访间隔（随诊期限）
	@TableField(value = "docAdvice")
	private String docAdvice;               // 医嘱
	@TableField(value = "spRemark")
	private String spRemark;                // 特别注意事项
}