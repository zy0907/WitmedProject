package com.whackon.witmed.base.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>项目基础框架 - 系统基础实体信息</b>
 * <p>
 *     系统基础实体信息设置了如下属性：
 *     1、status：系统状态（0-禁用，1-启用）<br/>
 *     2、createdBy：创建人<br/>
 *     3、createdTime：创建时间<br/>
 *     4、modifiedBy：修改人<br/>
 *     5、modifiedTime：修改时间<br/>
 *     <p>所有项目功能实体信息都必须继承于本系统基础实体信息</p>
 * </p>
 *
 * @author zyuan
 * @date 2022/1/18
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 3236307612993029344L;
	private String status;                      // 系统状态：0-禁用，1-启用
	@TableField(value = "createdBy")
	private String createdBy;                   // 创建人
	@TableField(value = "createdTime")
	private Date createdTime;                   // 创建时间
	@TableField(value = "modifiedBy")
	private String modifiedBy;                  // 修改人
	@TableField(value = "modifiedTime")
	private Date modifiedTime;                  // 修改时间
}
