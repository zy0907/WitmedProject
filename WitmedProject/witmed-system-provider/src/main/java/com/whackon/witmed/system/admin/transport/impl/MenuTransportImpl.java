package com.whackon.witmed.system.admin.transport.impl;

import com.whackon.witmed.system.admin.pojo.vo.RoleVO;
import com.whackon.witmed.system.admin.pojo.vo.RouterVO;
import com.whackon.witmed.system.admin.service.MenuService;
import com.whackon.witmed.system.admin.transport.MenuTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统功能菜单传输层接口实现类</b>
 *
 * @author zyuan
 * @version 1.0.0
 * @date 2022/2/17
 * @since 1.0.0
 */
@RestController("menuTransport")
@RequestMapping("/system/admin/menu/trans")
public class MenuTransportImpl implements MenuTransport {
	@Autowired
	private MenuService menuService;

	/**
	 * <b>根据角色信息获得路由列表</b>
	 * @param roleVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/routerlist")
	@Override
	public List<RouterVO> getRouterVOByRole(@RequestBody RoleVO roleVO) throws Exception {
		return menuService.getRouterVOByRole(roleVO);
	}
}
