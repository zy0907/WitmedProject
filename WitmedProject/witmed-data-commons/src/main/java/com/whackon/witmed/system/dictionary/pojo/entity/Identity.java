package com.whackon.witmed.system.dictionary.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 人员身份信息实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("sys_identity")
public class Identity extends BaseEntity {
	private static final long serialVersionUID = -5996536373703452772L;
	@TableId(type = IdType.AUTO)
	@TableField("id")
	private Long id;                        // 主键
	@TableField("code")
	private String code;                    // 编码
	@TableField("name")
	private String name;                    // 名称
}
