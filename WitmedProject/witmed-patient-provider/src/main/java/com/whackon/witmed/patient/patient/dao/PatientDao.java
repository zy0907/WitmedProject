package com.whackon.witmed.patient.patient.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whackon.witmed.patient.patient.pojo.entity.Patient;
import org.springframework.stereotype.Repository;

/**
 * <b>智慧医疗信息平台 - 患者功能 - 患者数据持久层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@Repository("patientDao")
public interface PatientDao extends BaseMapper<Patient> {
}
