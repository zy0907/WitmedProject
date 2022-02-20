package com.whackon.witmed.emr.clinic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whackon.witmed.emr.clinic.pojo.entity.Clinic;
import org.springframework.stereotype.Repository;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 门（急）诊病历数据持久层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@Repository("clinicDao")
public interface ClinicDao extends BaseMapper<Clinic> {
}
