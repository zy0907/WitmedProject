package com.whackon.witmed.system.admin.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import com.whackon.witmed.system.dictionary.pojo.vo.IdentityVO;
import com.whackon.witmed.system.hospital.pojo.vo.DepartmentVO;
import lombok.Data;

import java.util.Date;

/**
 * <b>系统功能 - 系统用户视图信息</b>
 *
 * @author Arthur
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class AdminVO extends BaseVO {
	private static final long serialVersionUID = -1690145997100587386L;
	private String id;               //主键
	private String no;               //人员工号
	private String name;             //人员姓名
	private String cellphone;        //联系电话
	private String password;         //登陆密码
	private RoleVO roleVO;               //人员角色
	private IdentityVO identityVO;       //人员身份
	private DepartmentVO departmentVO;   //所属部门
	private String technicalPos;     //服务者专业技术职务（职称）
	private String education;        //服务者学历
	private String professionalName; //服务者所学专业
	private String technicalPosRank; //服务者专业技术职务（职称）等级









}
