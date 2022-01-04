package com.whackon.witmed.system.admin.pojo.entity;

import com.whackon.witmed.base.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能-系统功能菜单信息实体信息</b>
 *
 * @author zyuan
 * @date 2022-1-4
 * @version 1.0.0
 */
@Data
public class Menu extends BaseEntity {
	private static final long serialVersionUID = -5363996401169463677L;
	private Integer id;    //主键
	private String code;   //菜单编码
	private Menu parent;   //上级功能菜单
	private String text;   //菜单文本
	private String url;    //链接地址
	private String icon;   //菜单图标样式
	private String sort;   //排序

}
