package com.whackon.witmed.system.dictionary.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 行政区划视图信息</b>
 *
 * @author Arthur
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class DivisionVO extends BaseVO {
	private static final long serialVersionUID = -89422455837277369L;
	private Integer id;       //主键
	private DivisionVO parentVO;  //上级行政区划
	private String code;      //区划编码
	private String name;      //区划名称
}
