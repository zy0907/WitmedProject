package com.whackon.witmed.system.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统人员实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("sys_admin")
public class Admin extends BaseEntity {
	private static final long serialVersionUID = 4226492550883944160L;
	@TableId(type = IdType.NONE)
	@TableField("id")
	private String id;                      // 主键
	@TableField("no")
	private String no;                      // 工号
	@TableField("name")
	private String name;                    // 姓名
	@TableField("cellphone")
	private String cellphone;               // 手机号码
	@TableField("password")
	private String password;                // 登录密码
	@TableField("role")
	private String role;                    // 角色
	@TableField("identity")
	private String identity;                // 身份
	@TableField("department")
	private String department;              // 所在部门
	@TableField("techPostTitle")
	private String techPostTitle;           // 服务者专业技术职务
	@TableField("education")
	private String education;               // 学历
	@TableField("techPostRank")
	private String techPostRank;            // 服务者专业技术职务等级
}
