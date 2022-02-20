package com.whackon.witmed.system.dictionary.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 行政区划实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("sys_division")
public class Division extends BaseEntity {
	private static final long serialVersionUID = 3121762206660414509L;
	@TableId(type = IdType.AUTO)
	@TableField("id")
	private Long id;                        // 主键
	@TableField("parent")
	private String parent;                  // 上级行政区划
	@TableField("code")
	private String code;                    // 行政区划编码
	@TableField("name")
	private String name;                    // 行政区划名称
}
