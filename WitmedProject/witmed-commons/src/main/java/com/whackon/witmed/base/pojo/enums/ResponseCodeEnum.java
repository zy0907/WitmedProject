package com.whackon.witmed.base.pojo.enums;

/**
 * <b>项目基础框架 - 系统响应编码枚举信息</b>
 *
 * @author zyuan
 * @date 2022/1/18
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ResponseCodeEnum {
	RESPONSE_CODE_SUCCESS(20000, "系统业务处理成功，系统响应成功"),
	RESPONSE_CODE_UNAUTH(30000, "用户未进行系统认证"),
	RESPONSE_CODE_ERROR(40000, "系统业务处理错误，系统响应成功"),
	RESPONSE_CODE_EXCEPTION(50000, "系统响应异常");

	private Integer code;                       // 系统响应编码
	private String remark;                      // 系统响应编码说明

	private ResponseCodeEnum(Integer code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
