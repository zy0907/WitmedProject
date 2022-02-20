package com.whackon.witmed.emr.clinic.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 门（急）诊病历既往史详情实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("emr_clinic_past")
public class ClinicPast extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.NONE)
	private String id;                      // 主键
	@TableField(value = "emrClinic")
	private String emrClinic;               // 所属门（急）诊病历
	@TableField(value = "itemName")
	private String itemName;                // 既往观察-项目名称
	@TableField(value = "itemCatCode")
	private String itemCatCode;             // 既往观察-项目分类代码
	@TableField(value = "itemCodeName")
	private String itemCodeName;            // 既往观察-项目代码名称
	@TableField(value = "itemCode")
	private String itemCode;                // 既往观察-项目代码
	@TableField(value = "methodCode")
	private String methodCode;              // 既往观察-方法代码
	@TableField(value = "result")
	private String result;                  // 既往观察-结果
	@TableField(value = "pastTypeName")
	private String pastTypeName;            // 既往史观察项目类目名称
	@TableField(value = "pastResult")
	private String pastResult;              // 既往史观察结果
}