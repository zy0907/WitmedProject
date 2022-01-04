package com.whackon.witmed.system.professional.pojo.entity;

import com.whackon.witmed.base.entity.BaseEntity;
import lombok.Data;

import javax.jnlp.IntegrationService;

/**
 * <b>系统功能-系统专业技术职务（职称）信息实体信息表</b>
 *
 * @author zyuan
 * @date 2022-1-4
 * @version 1.0.0
 */
@Data
public class ProTitle extends BaseEntity {
	private static final long serialVersionUID = -1937752577127369270L;
	private Integer id;       //主键
	private String category;  //所属类别
	private String rank;      //所属等级
	private String code;      //专业职务编码
	private String name;      //专业职务名称
}
