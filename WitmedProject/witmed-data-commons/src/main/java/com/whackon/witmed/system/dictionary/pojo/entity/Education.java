package com.whackon.witmed.system.dictionary.pojo.entity;

import com.whackon.witmed.base.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能-系统学历信息实体信息</b>
 *
 * @author zyuan
 * @date 2022-1-4
 * @version 1.0.0
 */
@Data
public class Education extends BaseEntity {
	private static final long serialVersionUID = 25267214504376502L;
	private Integer id;       //主键
	private String code;      //学历编号
	private String name;      //学历名称
}
