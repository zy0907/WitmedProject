package com.whackon.witmed.system.admin.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统功能菜单视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@Data
public class MenuVO extends BaseVO {
	private static final long serialVersionUID = 921213773788870449L;
	private Long id;                        // 主键
	private MenuVO parentVO;                // 上级菜单
	@NotBlank
	private String name;                    // 菜单文本
	@NotBlank
	private String code;                    // 角色编码
	private String path;                    // 链接地址
	private String component;               // 菜单组件
	private String title;                   // 菜单标题
	private String icon;                    // 菜单图标
	private Integer sort;                   // 排序
	private List<MenuVO> children;          // 子菜单功能列表
}
