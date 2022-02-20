package com.whackon.witmed.emr.clinicrx.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 门（急）诊西医处方实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("emr_clinic_wm_rx")
public class ClinicWmRx extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.NONE)
	private String id;                      // 主键
	@TableField(value = "emrNo")
	private String emrNo;                   // 病历号
	@TableField(value = "clinicNo")
	private String clinicNo;                // 门诊号
	@TableField(value = "docName")
	private String docName;                 // 文档标识-名称
	@TableField(value = "docCatCode")
	private String docCatCode;              // 文档标识-类别代码
	@TableField(value = "docAdminOrgName")
	private String docAdminOrgName;         // 文档标识-管理机构名称
	@TableField(value = "docAdminOrgCode")
	private String docAdminOrgCode;         // 文档标识-管理机构组织机构代码（法人代码）
	@TableField(value = "docNo")
	private String docNo;                   // 文档标识-号码
	@TableField(value = "docEffDate")
	private Date docEffDate;                // 文档标识-生效日期
	@TableField(value = "docExpDate")
	private Date docExpDate;                // 文档标识-失效日期
	@TableField(value = "markCatCode")
	private String markCatCode;             // 标识号-类别代码
	@TableField(value = "markNo")
	private String markNo;                  // 标识号-号码
	@TableField(value = "markEffDate")
	private Date markEffDate;               // 标识号-生效日期
	@TableField(value = "markExpDate")
	private Date markExpDate;               // 标识号-失效日期
	@TableField(value = "markOrgName")
	private String markOrgName;             // 标识号-提供标识的机构名称
	@TableField(value = "markObj")
	private String markObj;                 // 姓名-标识对象
	@TableField(value = "markObjCode")
	private String markObjCode;             // 姓名-标识对象代码
	@TableField(value = "name")
	private String name;                    // 姓名
	@TableField(value = "patientCatCode")
	private String patientCatCode;          // 病人类型代码
	@TableField(value = "gender")
	private String gender;                  // 性别代码
	@TableField(value = "age")
	private Integer age;                    // 年龄（岁）
	@TableField(value = "nationality")
	private String nationality;             // 国籍代码
	@TableField(value = "ethnic")
	private String ethnic;                  // 民族代码
	@TableField(value = "marital")
	private String marital;                 // 婚姻状况类别代码
	@TableField(value = "occupation")
	private String occupation;              // 职业编码系统名称
	@TableField(value = "occCode")
	private String occCode;                 // 职业代码
	@TableField(value = "education")
	private String education;               // 文化程度代码
	@TableField(value = "birthday")
	private Date birthday;                  // 出生日期
	@TableField(value = "birthplace")
	private String birthplace;              // 出生地
	@TableField(value = "workplace")
	private String workplace;               // 工作单位名称
	@TableField(value = "addrCatCode")
	private String addrCatCode;             // 标识地址类别的代码
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
	@TableField(value = "divisionCode")
	private String divisionCode;            // 行政区划代码
	@TableField(value = "treatment")
	private String treatment;               // 医疗待遇名称
	@TableField(value = "treatmentCode")
	private String treatmentCode;           // 医疗待遇代码
	@TableField(value = "orgName")
	private String orgName;                 // 机构名称
	@TableField(value = "orgCode")
	private String orgCode;                 // 机构组织机构代码
	@TableField(value = "orgLeader")
	private String orgLeader;               // 机构负责人（法人）
	@TableField(value = "orgAddress")
	private String orgAddress;              // 机构地址
	@TableField(value = "deptName")
	private String deptName;                // 科室名称
	@TableField(value = "orgRole")
	private String orgRole;                 // 机构角色
	@TableField(value = "orgRoleCode")
	private String orgRoleCode;             // 机构角色代码
	@TableField(value = "servName")
	private String servName;                // 服务者姓名
	@TableField(value = "servRole")
	private String servRole;                // 服务者职责（角色）
	@TableField(value = "servRoleCode")
	private String servRoleCode;            // 服务者职责（角色）代码
	@TableField(value = "servtechTitle")
	private String servtechTitle;           // 服务者专业技术职务
	@TableField(value = "servEdu")
	private String servEdu;                 // 服务者学历
	@TableField(value = "servMajor")
	private String servMajor;               // 服务者所学专业
	@TableField(value = "servTechRank")
	private String servTechRank;            // 服务者专业技术职务等级
	@TableField(value = "servPost")
	private String servPost;                // 服务者职务
	@TableField(value = "eventName")
	private String eventName;               // 卫生事件(动作)名称
	@TableField(value = "eventCatCode")
	private String eventCatCode;            // 事件分类代码
	@TableField(value = "eventStartDate")
	private Date eventStartDate;            // 事件开始时间
	@TableField(value = "eventAddr")
	private String eventAddr;               // 事件发生地点
	@TableField(value = "eventPart")
	private String eventPart;               // 事件参与方
	@TableField(value = "eventReason")
	private String eventReason;             // 事件发生原因
	@TableField(value = "eventResult")
	private String eventResult;             // 事件结局
	@TableField(value = "observeCat")
	private String observeCat;              // 观察-类别
	@TableField(value = "observeCatCode")
	private String observeCatCode;          // 观察-类别代码
	@TableField(value = "observeItem")
	private String observeItem;             // 观察项目名称
	@TableField(value = "observeItemCode")
	private String observeItemCode;         // 观察-项目代码
	@TableField(value = "observeResultDesc")
	private String observeResultDesc;       // 观察-结果描述
	@TableField(value = "dxOrgName")
	private String dxOrgName;               // 诊断机构名称
	@TableField(value = "dxDate")
	private Date dxDate;                    // 诊断日期
	@TableField(value = "dxCat")
	private String dxCat;                   // 诊断类别
	@TableField(value = "dxCatCode")
	private String dxCatCode;               // 诊断类别代码
	@TableField(value = "dxCisCode")
	private String dxCisCode;               // 诊断顺位（从属关系）代码
	@TableField(value = "disease")
	private String disease;                 // 疾病名称
	@TableField(value = "diseaseCode")
	private String diseaseCode;             // 疾病代码
	@TableField(value = "dxAccording")
	private String dxAccording;             // 诊断依据
	@TableField(value = "dxAccordingCode")
	private String dxAccordingCode;         // 诊断依据代码
	@TableField(value = "trtProcName")
	private String trtProcName;             // 诊疗过程名称
	@TableField(value = "trtProcDesc")
	private String trtProcDesc;             // 诊疗过程描述
	@TableField(value = "mrStatus")
	private String mrStatus;                // 病历状态：0-待接诊，1-诊疗完毕，2-未接诊，3-接诊后转诊/院，4-挂号错误
}