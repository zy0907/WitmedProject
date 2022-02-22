package com.whackon.witmed.patient.patient.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

import java.util.Date;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 患者视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@Data
public class PatientVO extends BaseVO {
	private static final long serialVersionUID = -3008012875684672513L;
	private String id;                      // 主键
	private String emrNo;                   // 病历号
	private String name;                    // 姓名
	private String idType;                  // 证件类型
	private String idNo;                    // 证件号码
	private Date idEffDate;                 // 证件生效日期
	private Date idExpDate;                 // 证件失效日期
	private String idOrg;                   // 证件提供机构
	private String aboBlood;                // ABO血型
	private String rhBlood;                 // RH血型
	private String gender;                  // 性别
	private String nationality;             // 国籍
	private String ethnic;                  // 民族
	private String marital;                 // 婚姻状况
	private String education;               // 文化程度
	private Date birthday;                  // 出生日期
	private String birthplace;              // 出生地
}
