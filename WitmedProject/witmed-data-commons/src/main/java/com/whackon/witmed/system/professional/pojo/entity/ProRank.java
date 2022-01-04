package com.whackon.witmed.system.professional.pojo.entity;

import com.whackon.witmed.base.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能-系统专业职务等级实体信息</b>
 *
 * @author zyuan
 * @date 2022-1-4
 * @version 1.0.0
 */
@Data
public class ProRank extends BaseEntity {
	private static final long serialVersionUID = -1455788694992632861L;
	private Integer id;    //主键
	private String code;   //等级编码
	private String name;   //等级名称
}
