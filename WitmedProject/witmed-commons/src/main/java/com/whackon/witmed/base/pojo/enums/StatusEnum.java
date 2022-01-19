package com.whackon.witmed.base.pojo.enums;

/**
 * <b>项目基础框架 - 系统状态枚举信息类</b>
 *
 * @author zyuan
 * @date 2022/1/19
 * @version 1.0.0
 * @since 1.0.0
 */
public enum StatusEnum {
	STATUS_ENABLE("1", "启用"),
	STATUS_DISABLE("0", "禁用");

	private String code;                        // 系统响应编码
	private String remark;                      // 系统响应编码说明

	private StatusEnum(String code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
