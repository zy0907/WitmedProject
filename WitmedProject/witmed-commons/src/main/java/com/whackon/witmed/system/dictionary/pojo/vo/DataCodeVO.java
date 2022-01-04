package com.whackon.witmed.system.dictionary.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 数据元值域代码视图信息</b>
 *
 * @author Arthur
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class DataCodeVO extends BaseVO {
	private static final long serialVersionUID = 4570131083874692406L;
	private Integer id;       //主键
	private DataCodeVO parentVO;  //上级数据元
	private String codeName;  //数据元值
	private String name;      //数据元值说明

}
