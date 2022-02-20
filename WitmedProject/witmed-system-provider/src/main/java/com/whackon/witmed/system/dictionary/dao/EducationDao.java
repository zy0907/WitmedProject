package com.whackon.witmed.system.dictionary.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whackon.witmed.system.dictionary.pojo.entity.Education;
import org.springframework.stereotype.Repository;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 学历数据持久层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@Repository("educationDao")
public interface EducationDao extends BaseMapper<Education> {
}
