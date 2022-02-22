package com.whackon.witmed.patient.patient.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 患者证件视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@Data
public class IdInfoVO implements Serializable {
	private static final long serialVersionUID = -8664602599008265449L;
	@NotBlank
	private String name;                    // 姓名
	private String idType;                  // 证件类型
	@NotBlank
	private String idNo;                    // 证件号码
	private Date idEffDate;                 // 证件生效日期
	private Date idExpDate;                 // 证件失效日期
	private String idOrg;                   // 证件提供机构
	private String gender;                  // 性别
	private String nationality;             // 国籍
	private String ethnic;                  // 民族
	private Date birthday;                  // 出生日期
}
