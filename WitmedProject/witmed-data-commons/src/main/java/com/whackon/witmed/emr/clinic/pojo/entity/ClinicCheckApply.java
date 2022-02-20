package com.whackon.witmed.emr.clinic.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 门（急）诊病历检查申请详情实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("emr_clinic_check_apply")
public class ClinicCheckApply extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.NONE)
	private String id;                      // 主键
	@TableField(value = "emrClinic")
	private String emrClinic;               // 所属门（急）诊病历
	@TableField(value = "checkOrg")
	private String checkOrg;                // 检查申请单—机构（科室）
	@TableField(value = "checkNo")
	private String checkNo;                 // 检查申请单—编号
	@TableField(value = "checkReason")
	private String checkReason;             // 检查申请检查原因
	@TableField(value = "applyDate")
	private Date applyDate;                 // 检查申请日期
	@TableField(value = "attention")
	private String attention;               // 检查申请注意事项
}