package com.whackon.witmed.system.dictionary.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据源值域视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@Data
public class DataCodeVO extends BaseVO {
	private static final long serialVersionUID = 4570131083874692406L;
	private Long id;                        // 主键
	private DataCodeVO parentVO;            // 上级数据元
	@NotBlank
	private String code;                    // 数据元值域
	@NotBlank
	private String remark;                  // 数据元说明
}
