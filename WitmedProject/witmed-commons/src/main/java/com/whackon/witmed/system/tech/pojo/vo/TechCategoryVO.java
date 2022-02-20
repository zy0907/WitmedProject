package com.whackon.witmed.system.tech.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 技术职称类别视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@Data
public class TechCategoryVO extends BaseVO {
	private static final long serialVersionUID = 7960437301047664734L;
	private Long id;                        // 主键
	@NotBlank
	private String code;                    // 编码
	@NotBlank
	private String name;                    // 名称
}