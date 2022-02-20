package com.whackon.witmed.system.hospital.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统人员部门实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("sys_department")
public class Department extends BaseEntity {
	private static final long serialVersionUID = 7912122390707422877L;
	@TableId(type = IdType.AUTO)
	@TableField("id")
	private Long id;                        // 主键
	@TableField("hospital")
	private String hospital;                // 所在医院
	@TableField("parent")
	private String parent;                  // 上级部门
	@TableField("code")
	private String code;                    // 部门编码
	@TableField("name")
	private String name;                    // 部门名称
}
