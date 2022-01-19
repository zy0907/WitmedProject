package com.whackon.witmed.system.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统权限实体信息</b>
 *
 * @author zyuan
 * @date 2022/1/19
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@TableName("sys_role")
public class Role extends BaseEntity {
	private static final long serialVersionUID = 3832012392097686144L;
	@TableId(type = IdType.AUTO)
	private Long id;                        // 主键
	@TableField(value = "角色编码")
	private String code;                    // 角色编码
	@TableField(value = "角色名称")
	private String name;                    // 角色名称
}
