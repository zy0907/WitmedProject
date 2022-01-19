package com.whackon.witmed.util;

import com.whackon.witmed.system.admin.pojo.entity.Admin;
import com.whackon.witmed.system.admin.pojo.entity.Menu;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.admin.pojo.vo.RouterVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - POJO 转换工具类</b>
 *
 * @author zyuan
 * @date 2022/1/19
 * @version 1.0.0
 * @since 1.0.0
 */
@Mapper(componentModel = "spring")
public interface PojoMapper {
	PojoMapper INSTANCE = Mappers.getMapper(PojoMapper.class);

	/**
	 * <b>将实体信息转换为视图信息</b>
	 * @param entity
	 * @return
	 */
	@Mapping(source = "role", target = "roleVO.code")
	AdminVO parseToVO(Admin entity);

	/**
	 * <b>将菜单实体转换为路由视图</b>
	 * @param menu
	 * @return
	 */
	// 在做字段映射时，取消对 children 的映射过程
	@Mapping(target = "children", ignore = true)
	@Mapping(source = "title", target = "meta.title")
	@Mapping(source = "icon", target = "meta.icon")
	RouterVO parseToRouterVOFromMenu(Menu menu);

	/**
	 * <b>将菜单实体列表转换为路由视图列表</b>
	 * @param menuList
	 * @return
	 */
	List<RouterVO> parseToRouterVOListFromMenuList(List<Menu> menuList);
}
