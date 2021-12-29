package com.whackon.witmed.base.pojo.enums;

/**
 * <b>系统响应编码枚举信息</b>
 *
 * @author zyuan
 * @date 2021/12/29
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ResponseCode {
	RESPONSE_SUCCESS("20000", "系统业务处理完毕，响应成功"),
	RESPONSE_UNAUTH("30000", "系统用户未进行认证"),
	RESPONSE_ERROR("40000", "系统业务处理错误"),
	RESPONSE_EXCEPTION("50000", "系统响应异常");

	private String code;                        // 响应编码
	private String remark;                      // 编码说明

	private ResponseCode(String code, String remark) {
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
