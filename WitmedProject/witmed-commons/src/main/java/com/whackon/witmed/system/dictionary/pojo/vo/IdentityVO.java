package com.whackon.witmed.system.dictionary.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 人员身份信息视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
public class IdentityVO extends BaseVO {
	private static final long serialVersionUID = 6800897319639388373L;
	private Long id;                        // 主键
	@NotBlank(message = "编码不能为空")
	private String code;                    // 编码
	@NotBlank(message = "名称不能为空")
	private String name;                    // 名称
}
