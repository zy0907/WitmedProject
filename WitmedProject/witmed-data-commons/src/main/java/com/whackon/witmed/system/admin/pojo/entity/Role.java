package com.whackon.witmed.system.admin.pojo.entity;

import com.whackon.witmed.base.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能-系统角色功能实体信息</b>
 *
 * @author zyuan
 * @date 2022-1-4
 * @version 1.0.0
 */
@Data
public class Role extends BaseEntity {
	private static final long serialVersionUID = -4797757389384661844L;
	private Integer id;   //主键
	private String code;  //角色编码
	private String name;  //角色名称

}
