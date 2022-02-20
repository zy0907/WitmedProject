package com.whackon.witmed.emr.clinicobs.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 急诊留观病历家族史详情实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("emr_clinic_obs_family")
public class ClinicObsFamily extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.NONE)
	private String id;                      // 主键
	@TableField(value = "emrClinicObs")
	private String emrClinicObs;            // 所属急诊留观病历
	@TableField(value = "typeName")
	private String typeName;                // 家族史观察项目类目名称
	@TableField(value = "result")
	private String result;                  // 家族史观察结果
}