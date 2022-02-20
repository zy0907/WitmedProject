package com.whackon.witmed.system.dictionary.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 学历实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("sys_education")
public class Education extends BaseEntity {
	private static final long serialVersionUID = 979192730346784447L;
	@TableId(type = IdType.AUTO)
	private Long id;                        // 主键
	@TableField(value = "code")
	private String code;                    // 编码
	@TableField(value = "name")
	private String name;                    // 名称
}
