package com.whackon.witmed.system.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whackon.witmed.system.admin.pojo.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统功能菜单数据持久层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/17
 * @since 1.0.0
 */
@Repository("menuDao")
public interface MenuDao extends BaseMapper<Menu> {
	/**
	 * <b>根据角色和父级菜单查询菜单列表</b>
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<Menu> findMenuListByRoleAndParent(Map<String, Object> params) throws Exception;
}
