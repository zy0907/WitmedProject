package com.whackon.witmed.system.admin.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 系统菜单功能视图信息</b>
 *
 * @author Arthur
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class MenuVO extends BaseVO {
	private static final long serialVersionUID = -1629398658391223735L;
	private Integer id;    //主键
	private String code;   //菜单编码
	private MenuVO parentVO;   //上级功能菜单
	private String text;   //菜单文本
	private String url;    //链接地址
	private String icon;   //菜单图标样式
	private String sort;   //排序
}
