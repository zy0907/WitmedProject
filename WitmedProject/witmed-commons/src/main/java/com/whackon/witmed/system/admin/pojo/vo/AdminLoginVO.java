package com.whackon.witmed.system.admin.pojo.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * <b>系统功能 - 系统用户登录视图信息</b>
 *
 * @author zyuan
 * @date 2022/1/6
 * @since
 */
public class AdminLoginVO implements Serializable {
	private static final long serialVersionUID = -5579801678324121359L;
	//notnull那个判断是否 空 但是空字符串无法判断  NotBlank 既又...
	@NotBlank(message = "未填写手机号码")
	//1开头 中间 0-9 这个规则用 10 次
	@Pattern(regexp = "1[0-9]{10}", message = "手机号码格式错误")
	private String cellphone;                       // 登录手机号码
	@NotBlank(message = "未填写登录密码")
	//判断是大小写英文字母 数字 或者 下划线 艾特符 还有 井号 除外 判断6次及以上
	@Pattern(regexp = "[A-Za-z0-9_@#]{6,}", message = "登录密码格式错误")
	private String password;                        // 用户登录密码

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
