package com.whackon.witmed.system.hospital.pojo.entity;

import com.whackon.witmed.base.entity.BaseEntity;
import lombok.Data;

/**
 * <b>系统功能-医院部门实体信息</b>
 *
 * @author zyuan
 * @date 2022-1-4
 * @version 1.0.0
 */
@Data
public class Department extends BaseEntity {
	private static final long serialVersionUID = -8318039432114867781L;
	private Integer id;        //主键
	private Hospital hospital; //所属医院
	private Department parent;  //上级部门
	private String code;        //部门编码
	private String name;        //部门名称
}
