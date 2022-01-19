package com.whackon.witmed.system.admin.service;

import com.whackon.witmed.system.admin.pojo.vo.RoleVO;
import com.whackon.witmed.system.admin.pojo.vo.RouterVO;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统功能菜单业务层接口</b>
 *
 * @author zyuan
 * @date 2022/1/19
 * @version 1.0.0
 * @since 1.0.0
 */
public interface MenuService {
	/**
	 * <b>根据角色信息获得该角色对应的操作路由列表</b>
	 * @param roleVO
	 * @return
	 * @throws Exception
	 */
	List<RouterVO> getRouterVOListByRoleVO(RoleVO roleVO) throws Exception;
}
