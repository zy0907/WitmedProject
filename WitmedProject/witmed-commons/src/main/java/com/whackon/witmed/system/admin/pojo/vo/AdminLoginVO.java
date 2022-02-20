package com.whackon.witmed.system.admin.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统人员登录数据视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/17
 * @since 1.0.0
 */
@Data
public class AdminLoginVO implements Serializable {
	private static final long serialVersionUID = -5579801678324121359L;
	@NotBlank
	@Pattern(regexp = "1[0-9]{10}")
	private String cellphone;                       // 手机号码
	@NotBlank
	@Pattern(regexp = "[A-Za-z0-9]{6,}")
	private String password;                        // 登录密码
}
