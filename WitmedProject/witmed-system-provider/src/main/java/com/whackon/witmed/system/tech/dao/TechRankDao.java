package com.whackon.witmed.system.tech.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whackon.witmed.system.tech.pojo.entity.TechRank;
import org.springframework.stereotype.Repository;

/**
 * <b></b>
 *
 * @author zyuan
 * @date 2022/2/18
 */
@Repository("techRankDao")
public interface TechRankDao extends BaseMapper<TechRank> {
}
