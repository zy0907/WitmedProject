package com.whackon.witmed.system.dictionary.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whackon.witmed.base.pojo.entity.BaseEntity;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据源值域实体信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
@TableName("sys_data_code")
public class DataCode extends BaseEntity {
	private static final long serialVersionUID = -5016038598091781606L;
	@TableId(type = IdType.AUTO)
	@TableField("id")
	private Long id;                        // 主键
	@TableField("parent")
	private String parent;                  // 上级数据元
	@TableField("code")
	private String code;                    // 数据元值域
	@TableField("remark")
	private String remark;                  // 数据元说明
}
