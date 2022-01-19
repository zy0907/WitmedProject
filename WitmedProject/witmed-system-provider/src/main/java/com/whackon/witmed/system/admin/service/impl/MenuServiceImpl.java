package com.whackon.witmed.system.admin.service.impl;

import com.whackon.witmed.system.admin.dao.MenuDao;
import com.whackon.witmed.system.admin.pojo.entity.Menu;
import com.whackon.witmed.system.admin.pojo.vo.RoleVO;
import com.whackon.witmed.system.admin.pojo.vo.RouterVO;
import com.whackon.witmed.system.admin.service.MenuService;
import com.whackon.witmed.util.PojoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统功能菜单业务层接口实现类</b>
 *
 * @author zyuan
 * @date 2022/1/19
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
	@Resource(name = "menuDao")
	private MenuDao menuDao;

	/**
	 * <b>根据角色信息获得该角色对应的操作路由列表</b>
	 * @param roleVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RouterVO> getRouterVOListByRoleVO(RoleVO roleVO) throws Exception {
		List<RouterVO> routerVOList = new ArrayList<RouterVO>();
		// 创建查询 Map 集合
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("role", roleVO.getCode());
		
		// 根据角色信息，查询一级菜单信息
		List<Menu> menuList = menuDao.findMenuListByRoleAndParent(queryMap);

		// 循环一级菜单
		if (menuList != null && !menuList.isEmpty()) {
			for (Menu menu : menuList) {
				// 将 Menu 实体切换为 RouterVO 实体
				RouterVO routerVO = PojoMapper.INSTANCE.parseToRouterVOFromMenu(menu);
				// 根据一级菜单和角色查询一级菜单对应的二级菜单
				queryMap.put("parent", menu.getCode());
				List<Menu> menuChildren = menuDao.findMenuListByRoleAndParent(queryMap);
				// 将所查询到二级菜单实体列表切换为对应的路由视图列表
				List<RouterVO> routerVOChildren = PojoMapper.INSTANCE.parseToRouterVOListFromMenuList(menuChildren);
				// 将二级路由视图列表设定到其一级路由视图中
				routerVO.setChildren(routerVOChildren);
				// 将此时的一级路由视图添加到结果列表中
				routerVOList.add(routerVO);
			}
		}

		return routerVOList;
	}
}
