package com.whackon.witmed.opc.register.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whackon.witmed.opc.register.pojo.entity.RegisterRecord;
import org.springframework.stereotype.Repository;

/**
 * <b>智慧医疗信息平台 - 门诊功能 - 患者就诊数据持久层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@Repository("registerDao")
public interface RegisterDao extends BaseMapper<RegisterRecord> {
}
