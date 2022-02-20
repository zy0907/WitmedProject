package com.whackon.witmed.system.dictionary.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 学历视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@Data
public class EducationVO extends BaseVO {
	private static final long serialVersionUID = -1319345864517471122L;
	private Long id;                        // 主键
	private String code;                    // 编码
	private String name;                    // 名称
}
