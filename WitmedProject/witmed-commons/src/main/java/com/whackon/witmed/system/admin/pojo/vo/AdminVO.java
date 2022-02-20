package com.whackon.witmed.system.admin.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import com.whackon.witmed.system.dictionary.pojo.vo.EducationVO;
import com.whackon.witmed.system.dictionary.pojo.vo.IdentityVO;
import com.whackon.witmed.system.hospital.pojo.vo.DepartmentVO;
import com.whackon.witmed.system.tech.pojo.vo.TechRankVO;
import com.whackon.witmed.system.tech.pojo.vo.TechTitleVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统人员视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@Data
public class AdminVO extends BaseVO {
	private static final long serialVersionUID = 811957010974699686L;
	private String id;                      // 主键
	@NotBlank
	private String no;                      // 工号
	@NotBlank
	private String name;                    // 姓名
	@NotBlank
	@Pattern(regexp = "1[0-9]{10}")
	private String cellphone;               // 手机号码
	@NotBlank
	@Pattern(regexp = "[A-Za-z0-9]{6,}")
	private String password;                // 登录密码
	private RoleVO roleVO;                  // 角色
	private IdentityVO identityVO;          // 身份
	private DepartmentVO departmentVO;      // 所在部门
	private TechTitleVO techPostTitleVO;    // 服务者专业技术职务
	private EducationVO educationVO;        // 学历
	private TechRankVO techPostRankVO;      // 服务者专业技术职务等级
}
