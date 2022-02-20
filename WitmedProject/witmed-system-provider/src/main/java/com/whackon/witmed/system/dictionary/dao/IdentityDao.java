package com.whackon.witmed.system.dictionary.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whackon.witmed.system.dictionary.pojo.entity.Identity;
import org.springframework.stereotype.Repository;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 人员身份信息数据持久层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Repository("identityDao")
public interface IdentityDao extends BaseMapper<Identity> {
}
