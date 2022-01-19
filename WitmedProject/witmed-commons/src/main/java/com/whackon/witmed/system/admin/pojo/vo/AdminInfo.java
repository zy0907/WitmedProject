package com.whackon.witmed.system.admin.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统登录用户视图信息</b>
 * <p>
 *     当登录成功后，通过 Token 获得登录用户信息，包括：
 *     1、当前登录用户视图信息<br/>
 *     2、当前登录用户操作路由列表<br/>
 * </p>
 *
 * @author zyuan
 * @date 2022/1/19
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class AdminInfo implements Serializable {
	private static final long serialVersionUID = -4640818649031169493L;
	private AdminVO adminVO;                        // 当前登录用户信息
	private List<RouterVO> routerVOList;            // 当前登录用户操作路由列表

	public AdminInfo() {}

	public AdminInfo(AdminVO adminVO, List<RouterVO> routerVOList) {
		this.adminVO = adminVO;
		this.routerVOList = routerVOList;
	}
}
