package com.whackon.witmed.system.hospital.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whackon.witmed.system.hospital.pojo.entity.Position;
import org.springframework.stereotype.Repository;

/**
 * <b></b>
 *
 * @author zyuan
 * @date 2022/2/18
 */
@Repository("positionDao")
public interface PositionDao extends BaseMapper<Position> {
}
