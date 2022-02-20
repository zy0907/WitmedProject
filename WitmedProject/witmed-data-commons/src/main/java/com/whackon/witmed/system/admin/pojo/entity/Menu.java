package com.whackon.witmed.system.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统功能菜单实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("sys_menu")
public class Menu extends BaseEntity {
	private static final long serialVersionUID = 6494472229034048736L;
	@TableId(type = IdType.AUTO)
	@TableField("id")
	private Long id;                        // 主键
	@TableField("parent")
	private String parent;                  // 上级菜单
	@TableField("name")
	private String name;                    // 菜单文本
	@TableField("code")
	private String code;                    // 角色编码
	@TableField("path")
	private String path;                    // 链接地址
	@TableField("component")
	private String component;               // 菜单组件
	@TableField("title")
	private String title;                   // 菜单标题
	@TableField("icon")
	private String icon;                    // 菜单图标
	@TableField("sort")
	private Integer sort;                   // 排序
}
