package com.whackon.witmed.system.professional.pojo.entity;

import com.whackon.witmed.base.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能-系统专业技术职务（职称）类别信息实体信息</b>
 *
 * @author zyuan
 * @date 2022-1-4
 * @version 1.0.0
 */
@Data
public class ProCategory extends BaseEntity {
	private static final long serialVersionUID = 1027077569213468093L;
	private Integer id;    //主键
	private String code;   //类别编码
	private String name;   //类别名称

}
