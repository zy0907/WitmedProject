package com.whackon.witmed.system.professional.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 专业职务等级视图信息</b>
 *
 * @author Arthur
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class ProRankVO extends BaseVO {
	private static final long serialVersionUID = 7363309550345560124L;
	private Integer id;    //主键
	private String code;   //等级编码
	private String name;   //等级名称
}
