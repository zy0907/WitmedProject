package com.whackon.witmed.base.pojo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>基础视图信息</b>
 *
 * @author zyuan
 * @date 2021/12/29
 * @version 1.0.0
 * @since 1.0.0
 */
public class BaseVO implements Serializable {
	private static final long serialVersionUID = -5145823486061107413L;
	private String status;                      // 系统状态：0-禁用，1-启用
	private String createdBy;                   // 创建人
	private Date createdTime;                   // 创建时间
	private String modifiedBy;                  // 修改人
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
