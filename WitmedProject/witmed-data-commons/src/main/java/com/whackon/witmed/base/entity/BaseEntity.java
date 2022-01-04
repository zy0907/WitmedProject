package com.whackon.witmed.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>基础信息功能 - 基础实体信息</b>
 * <p>
 *     基础实体信息设置了如下属性：
 *     1、status：系统状态<br/>
 *     2、createdBy：创建人<br/>
 *     3、createdTime：创建时间<br/>
 *     4、modifiedBy：修改人<br/>
 *     5、modifiedTime：修改时间<br/>
 *     本项目所有功能实体信息<b>都必须继承于本基础实体信息</b>。
 * </p>
 *
 * @author zyuan
 * @date 2021-12-30
 * @version 1.0.0
 */
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 377806458505909427L;
	private String status;                      // 系统状态：0-禁用，1-启用
	@TableField(value = "createdBy")
	private String createdBy;                   // 创建人
	@TableField(value = "createdTime")
	private Date createdTime;                   // 创建时间
	@TableField(value = "modifiedBy")
	private String modifiedBy;                  // 修改人
	@TableField(value = "modifiedTime")
	private Date modifiedTime;                  // 修改时间

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
}
