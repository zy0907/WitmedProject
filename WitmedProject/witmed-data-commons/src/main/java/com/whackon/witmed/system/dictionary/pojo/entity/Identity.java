package com.whackon.witmed.system.dictionary.pojo.entity;

import com.whackon.witmed.base.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能-系统身份实体信息</b>
 *
 * @author zyuan
 * @date 2022-1-4
 * @version 1.0.0
 */
@Data
public class Identity extends BaseEntity {
	private static final long serialVersionUID = 5794097613702708985L;
	private Integer id;   //主键
	private String code;  //身份编号
	private String name;  //身份信息
}
