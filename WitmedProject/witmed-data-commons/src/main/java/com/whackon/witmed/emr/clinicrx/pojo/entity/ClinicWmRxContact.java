package com.whackon.witmed.emr.clinicrx.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 门（急）诊西医处方联系人详情实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("emr_clinic_wm_rx_contact")
public class ClinicWmRxContact extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.NONE)
	private String id;                      // 主键
	@TableField(value = "emrClinicRx")
	private String emrClinicRx;             // 门（急）诊西医处方
	@TableField(value = "markCatCode")
	private String markCatCode;             // 标识号-类别代码
	@TableField(value = "markNo")
	private String markNo;                  // 标识号-号码
	@TableField(value = "markEffDate")
	private Date markEffDate;               // 标识号-生效日期
	@TableField(value = "markOrgName")
	private String markOrgName;             // 标识号-提供标识的机构名称
	@TableField(value = "markObj")
	private String markObj;                 // 姓名-标识对象
	@TableField(value = "markObjCode")
	private String markObjCode;             // 姓名-标识对象代码
	@TableField(value = "name")
	private String name;                    // 姓名
}