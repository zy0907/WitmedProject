package com.whackon.witmed.system.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whackon.witmed.system.admin.dao.AdminDao;
import com.whackon.witmed.system.admin.pojo.entity.Admin;
import com.whackon.witmed.system.admin.pojo.vo.AdminVO;
import com.whackon.witmed.system.admin.util.AdminPojoMapper;
import com.whackon.witmed.system.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统人员业务层接口实现类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/17
 * @since 1.0.0
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	/**
	 * <b>根据手机号码查询信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@Override
	public AdminVO getByCellphone(String cellphone) throws Exception {
		// 根据手机号码进行查询获得实体信息
		Admin admin = adminDao.selectOne(new QueryWrapper<Admin>().eq("cellphone", cellphone));
		return AdminPojoMapper.INSTANCE.parseToVOForAdmin(admin);
	}
}
