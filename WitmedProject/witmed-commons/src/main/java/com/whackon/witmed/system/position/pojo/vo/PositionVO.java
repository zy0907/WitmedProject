package com.whackon.witmed.system.position.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 人员职务视图信息</b>
 *
 * @author Arthur
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class PositionVO extends BaseVO {
	private static final long serialVersionUID = -1974383078298077986L;
	private Integer id;    //主键
	private String code;   //职务编号
	private String name;   //职务名称
}
