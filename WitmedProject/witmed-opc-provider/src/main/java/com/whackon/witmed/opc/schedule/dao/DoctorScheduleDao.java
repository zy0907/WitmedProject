package com.whackon.witmed.opc.schedule.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whackon.witmed.opc.schedule.pojo.entity.DoctorSchedule;
import org.springframework.stereotype.Repository;

/**
 * <b>智慧医疗信息平台 - 门诊功能 - 医生接诊排班数据持久层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/21
 * @since 1.0.0
 */
@Repository("doctorScheduleDao")
public interface DoctorScheduleDao extends BaseMapper<DoctorSchedule> {
}
