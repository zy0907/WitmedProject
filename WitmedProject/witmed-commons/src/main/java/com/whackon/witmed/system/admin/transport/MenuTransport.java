package com.whackon.witmed.system.admin.transport;

import com.whackon.witmed.system.admin.pojo.vo.RoleVO;
import com.whackon.witmed.system.admin.pojo.vo.RouterVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统功能菜单传输层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/17
 * @since 1.0.0
 */
@FeignClient(name = "witmed-system-provider")
//@RequestMapping("/system/admin/menu/trans")
public interface MenuTransport {
	/**
	 * <b>根据角色信息获得路由列表</b>
	 * @param roleVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/system/admin/menu/trans/routerlist")
	List<RouterVO> getRouterVOByRole(@RequestBody RoleVO roleVO) throws Exception;
}
