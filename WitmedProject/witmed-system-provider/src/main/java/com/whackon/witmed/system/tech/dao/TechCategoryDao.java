package com.whackon.witmed.system.tech.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whackon.witmed.system.tech.pojo.entity.TechCategory;
import org.springframework.stereotype.Repository;

/**
 * <b></b>
 *
 * @author zyuan
 * @date 2022/2/18
 */
@Repository("techCategoryDao")
public interface TechCategoryDao extends BaseMapper<TechCategory> {
}
