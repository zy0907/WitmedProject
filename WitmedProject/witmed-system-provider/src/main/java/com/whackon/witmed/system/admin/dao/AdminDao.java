package com.whackon.witmed.system.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whackon.witmed.system.admin.pojo.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统人员数据持久层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@Repository("adminDao")
public interface AdminDao extends BaseMapper<Admin> {
}
