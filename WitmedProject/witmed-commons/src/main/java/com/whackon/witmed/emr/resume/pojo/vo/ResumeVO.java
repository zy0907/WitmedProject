package com.whackon.witmed.emr.resume.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;

import java.util.Date;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 病历概要数据视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
public class ResumeVO extends BaseVO {
	private static final long serialVersionUID = -97175396702707762L;
	private String id;                      // 主键
	private String emrNo;                   // 病历号
	private String clinicNo;                // 门诊号
	private String docName;                 // 文档标识-名称
	private String docCatCode;              // 文档标识-类别代码
	private String docAdminOrgName;         // 文档标识-管理机构名称
	private String docAdminOrgCode;         // 文档标识-管理机构组织机构代码（法人代码）
	private String docNo;                   // 文档标识-号码
	private Date docEffDate;                // 文档标识-生效日期
	private Date docExpDate;                // 文档标识-失效日期
	private String markCatCode;             // 标识号-类别代码
	private String markNo;                  // 标识号-号码
	private Date markEffDate;               // 标识号-生效日期
	private Date markExpDate;               // 标识号-失效日期
	private String markOrgName;             // 标识号-提供标识的机构名称
	private String markObj;                 // 姓名-标识对象
	private String markObjCode;             // 姓名-标识对象代码
	private String name;                    // 姓名
	private String patientCatCode;          // 病人类型代码
	private String aboBlood;                // ABO血型
	private String rhBlood;                 // RH血型
	private String gender;                  // 性别代码
	private Integer age;                    // 年龄（岁）
	private String nationality;             // 国籍代码
	private String ethnic;                  // 民族代码
	private String marital;                 // 婚姻状况类别代码
	private String occupation;              // 职业编码系统名称
	private String occCode;                 // 职业代码
	private String education;               // 文化程度代码
	private Date birthday;                  // 出生日期
	private String birthplace;              // 出生地
	private String workplace;               // 工作单位名称
	private String addrCatCode;             // 标识地址类别的代码
	private String province;                // 地址-省（自治区、直辖市）
	private String city;                    // 地址-市（地区）
	private String county;                  // 地址-县（区）
	private String countryside;             // 地址-乡（镇、街道办事处）
	private String village;                 // 地址-村（街、路、弄等）
	private String doorNo;                  // 地址-门牌号码
	private String zipcode;                 // 邮政编码
	private String divisionCode;            // 行政区划代码
	private String treatment;               // 医疗待遇名称
	private String treatmentCode;           // 医疗待遇代码
	private String eventName;               // 卫生事件(动作)名称
	private String eventCatCode;            // 事件分类代码
	private Date eventStartDate;            // 事件开始时间
	private String eventAddr;               // 事件发生地点
	private String eventPart;               // 事件参与方
	private String eventReason;             // 事件发生原因
	private String eventResult;             // 事件结局
	private String mrStatus;                // 病历状态：0-待接诊，1-诊疗完毕，2-未接诊，3-接诊后转诊/院，4-挂号错误
}
