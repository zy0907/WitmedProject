package com.whackon.witmed.system.admin.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统角色视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@Data
public class RoleVO extends BaseVO {
	private static final long serialVersionUID = -296749514794606243L;
	private Long id;                        // 主键
	@NotBlank
	private String code;                    // 角色编码
	@NotBlank
	private String name;                    // 角色名称
}
