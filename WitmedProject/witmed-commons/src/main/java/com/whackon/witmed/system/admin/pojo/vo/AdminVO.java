package com.whackon.witmed.system.admin.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统用户视图信息</b>
 *
 * @author zyuan
 * @date 2022/1/19
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class AdminVO extends BaseVO {
	private static final long serialVersionUID = 811957010974699686L;
	private String id;                      // 主键
	private String no;                      // 工号
	private String name;                    // 姓名
	private String cellphone;               // 手机号码
	private String password;                // 登录密码
	private RoleVO roleVO;                  // 角色
	private String identity;                // 身份
	private String department;              // 所在部门
	private String techPostTitle;           // 服务者专业技术职务
	private String education;               // 学历
	private String techPostRank;            // 服务者专业技术职务等级
}
