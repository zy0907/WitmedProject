package com.whackon.witmed.system.tech.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whackon.witmed.system.tech.pojo.entity.TechTitle;
import org.springframework.stereotype.Repository;

/**
 * <b></b>
 *
 * @author zyuan
 * @date 2022/2/18
 */
@Repository("techTitleDao")
public interface TechTitleDao extends BaseMapper<TechTitle> {
}
