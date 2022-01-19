package com.whackon.witmed.system.admin.dao;

import com.whackon.witmed.system.admin.pojo.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统功能菜单数据持久层接口</b>
 *
 * @author zyuan
 * @date 2022/1/19
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository("menuDao")
public interface MenuDao {
	/**
	 * <b>根据上级菜单和角色信息查询对应的菜单列表</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	List<Menu> findMenuListByRoleAndParent(Map<String, Object> queryMap) throws Exception;
}
