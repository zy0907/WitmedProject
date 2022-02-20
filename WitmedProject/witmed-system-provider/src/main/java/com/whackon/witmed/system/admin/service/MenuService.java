package com.whackon.witmed.system.admin.service;

import com.whackon.witmed.system.admin.pojo.vo.RoleVO;
import com.whackon.witmed.system.admin.pojo.vo.RouterVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统功能菜单业务层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/17
 * @since 1.0.0
 */
public interface MenuService {
	/**
	 * <b>根据角色信息获得路由列表</b>
	 * @param roleVO
	 * @return
	 * @throws Exception
	 */
	List<RouterVO> getRouterVOByRole(@RequestBody RoleVO roleVO) throws Exception;
}
