package com.whackon.witmed.system.position.pojo.entity;

import com.whackon.witmed.base.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能-系统职务实体信息</b>
 *
 * @author zyuan
 * @date 2022-1-4
 * @version 1.0.0
 */
@Data
public class Position extends BaseEntity {
	private static final long serialVersionUID = -1804471173824748919L;
	private Integer id;    //主键
	private String code;   //职务编号
	private String name;   //职务名称
}
