package com.whackon.witmed.system.dictionary.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 行政区划视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@Data
public class DivisionVO extends BaseVO {
	private static final long serialVersionUID = -225267607513977757L;
	private Long id;                        // 主键
	private DivisionVO parentVO;            // 上级行政区划
	@NotBlank
	private String code;                    // 行政区划编码
	@NotBlank
	private String name;                    // 行政区划名称
}
