package com.whackon.witmed.system.admin.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统人员和对应路由列表数据视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/17
 * @since 1.0.0
 */
@Data
public class AdminRouterInfo implements Serializable {
	private static final long serialVersionUID = 78664959643277496L;
	private AdminVO adminVO;                        // 系统用户视图信息
	private List<RouterVO> routerVOList;            // 用户对应路由列表

	public AdminRouterInfo() {}

	public AdminRouterInfo(AdminVO adminVO, List<RouterVO> routerVOList) {
		this.adminVO = adminVO;
		this.routerVOList = routerVOList;
	}
}
