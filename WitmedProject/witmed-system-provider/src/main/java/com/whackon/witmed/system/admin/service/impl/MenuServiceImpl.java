package com.whackon.witmed.system.admin.service.impl;

import com.whackon.witmed.system.admin.dao.MenuDao;
import com.whackon.witmed.system.admin.pojo.entity.Menu;
import com.whackon.witmed.system.admin.pojo.vo.RoleVO;
import com.whackon.witmed.system.admin.pojo.vo.RouterVO;
import com.whackon.witmed.system.admin.service.MenuService;
import com.whackon.witmed.system.admin.util.AdminPojoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统功能菜单业务层接口实现类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/17
 * @since 1.0.0
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;

	/**
	 * <b>根据角色信息获得路由列表</b>
	 * @param roleVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RouterVO> getRouterVOByRole(RoleVO roleVO) throws Exception {
		List<RouterVO> routerVOList = new ArrayList<RouterVO>();
		// 创建查询参数集合
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("role", roleVO.getCode());
		// 查询一级菜单
		List<Menu> menuList = menuDao.findMenuListByRoleAndParent(params);
		if (!menuList.isEmpty()) {
			for (Menu firstMenu : menuList) {
				// 将 Menu 转换为 RouterVO
				RouterVO firstRouterVO = AdminPojoMapper.INSTANCE.parseToRouterVOFromMenu(firstMenu);
				// 根据一级菜单查询二级菜单
				params.put("parent", firstMenu.getCode());
				List<Menu> secondMenuList = menuDao.findMenuListByRoleAndParent(params);
				firstRouterVO.setChildren(AdminPojoMapper.INSTANCE.parseToRouterVOListFromMenuList(secondMenuList));
				routerVOList.add(firstRouterVO);
			}
		}
		return routerVOList;
	}
}
