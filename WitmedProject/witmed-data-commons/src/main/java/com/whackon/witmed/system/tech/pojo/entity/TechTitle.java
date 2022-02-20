package com.whackon.witmed.system.tech.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 技术职称实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("sys_tech_title")
public class TechTitle extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.AUTO)
	private Long id;                        // 主键
	@TableField(value = "category")
	private String category;                // 所属类别
	@TableField(value = "rank")
	private String rank;                    // 所属等级
	@TableField(value = "code")
	private String code;                    // 编码
	@TableField(value = "name")
	private String name;                    // 名称
}