package com.whackon.witmed.system.tech.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 技术职称视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@Data
public class TechTitleVO extends BaseVO {
	private static final long serialVersionUID = 6248732711703352068L;
	private Long id;                        // 主键
	@NotNull
	private TechCategoryVO categoryVO;      // 所属类别
	@NotNull
	private TechRankVO rankVO;              // 所属等级
	@NotBlank
	private String code;                    // 编码
	@NotBlank
	private String name;                    // 名称
}