package com.whackon.witmed.system.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whackon.witmed.system.admin.dao.AdminDao;
import com.whackon.witmed.system.admin.pojo.entity.Admin;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.admin.service.AdminService;
import com.whackon.witmed.util.PojoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统用户业务层接口实现类</b>
 *
 * @author zyuan
 * @date 2022/1/19
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
	@Resource(name = "adminDao")
	private AdminDao adminDao;

	/**
	 * <b>根据手机号码查询系统用户视图信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@Override
	public AdminVO getAdminVOByCellphone(String cellphone) throws Exception {
		// 创建 QueryWrapper 对象
		QueryWrapper<Admin> queryWrapper = new QueryWrapper<Admin>();
		// 设定查询条件
		queryWrapper.eq("cellphone", cellphone);
		// 进行查询获得实体对象
		Admin admin = adminDao.selectOne(queryWrapper);
		// 判断是否能够获得数据
		if (admin != null) {
			// 获得查询数据，那么将实体对象转换为视图对象
			return PojoMapper.INSTANCE.parseToVO(admin);
		}
		return null;
	}
}
