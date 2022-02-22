package com.whackon.witmed.opc.register.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whackon.witmed.base.util.IdGenerator;
import com.whackon.witmed.opc.dto.RegisterDto;
import com.whackon.witmed.opc.register.dao.RegisterDao;
import com.whackon.witmed.opc.register.pojo.entity.RegisterRecord;
import com.whackon.witmed.opc.register.pojo.vo.RegisterRecordVO;
import com.whackon.witmed.opc.register.service.RegisterService;
import com.whackon.witmed.opc.register.util.RegisterPojoMapper;
import com.whackon.witmed.opc.schedule.dao.DoctorScheduleDao;
import com.whackon.witmed.opc.schedule.pojo.entity.DoctorSchedule;
import com.whackon.witmed.opc.schedule.pojo.vo.DoctorScheduleVO;
import com.whackon.witmed.opc.schedule.util.SchedulePojoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <b>智慧医疗信息平台 - 门诊功能 - 患者就诊业务层接口实现类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@Service("registerService")
@Transactional
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterDao registerDao;
	@Autowired
	private DoctorScheduleDao doctorScheduleDao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据患者所选择的科室自动匹配医生信息</b>
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	@Override
	public DoctorScheduleVO matchDocForAuto(Long deptId) throws Exception {
		// 根据当前实现，查询目前接诊医生的结束时间晚于当前时间，并且还有剩余挂号量，按照时间的升序进行排列
		QueryWrapper<DoctorSchedule> query = new QueryWrapper<DoctorSchedule>();
		// 设定患者挂号科室
		query.eq("dept", deptId);
		// 设置医生接诊时间晚于当前时间
		query.gt("endTime", new Date());
		// 设置剩余挂号量大于 0
		query.gt("surplusNum", 0);
		// 按照结束实现的升序进行排列
		query.orderByAsc("endTime");
		// 进行查询
		List<DoctorSchedule> doctorScheduleList = doctorScheduleDao.selectList(query);
		if (doctorScheduleList != null && !doctorScheduleList.isEmpty()) {
			return SchedulePojoMapper.INSTANCE.parseToVOForDoctorSchedule(doctorScheduleList.get(0));
		}
		return null;
	}

	/**
	 * <b>根据所制定的医生进行查询</b>
	 * @param doctorId
	 * @return
	 * @throws Exception
	 */
	@Override
	public DoctorScheduleVO matchDocForPatient(String doctorId) throws Exception {
		// 根据用户制定的医生信息，进行查询
		QueryWrapper<DoctorSchedule> query = new QueryWrapper<DoctorSchedule>();
		// 设定患者制定医生信息
		query.eq("doctor", doctorId);
		// 设置医生接诊时间晚于当前时间
		query.gt("endTime", new Date());
		// 设置剩余挂号量大于 0
		query.gt("surplusNum", 0);
		// 按照结束实现的升序进行排列
		query.orderByAsc("endTime");
		// 进行查询
		List<DoctorSchedule> doctorScheduleList = doctorScheduleDao.selectList(query);
		if (doctorScheduleList != null && !doctorScheduleList.isEmpty()) {
			return SchedulePojoMapper.INSTANCE.parseToVOForDoctorSchedule(doctorScheduleList.get(0));
		}
		return null;
	}

	/**
	 * <b>保存挂号信息</b>
	 * @param registerDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public RegisterRecordVO save(RegisterDto registerDto) throws Exception {
		// 将视图信息转换为实体信息
		RegisterRecord entity = RegisterPojoMapper.INSTANCE.parseToEntityForRegisterRecord(registerDto.getRegisterRecordVO());
		String id = idGenerator.createId();
		// 设置主键
		entity.setId(id);
		// 获得本次就诊门诊号，以当前时间的时间戳作为门诊号
		entity.setClinicNo(String.valueOf(System.currentTimeMillis()));
		// 进行保存
		if (registerDao.insert(entity) > 0) {
			// 修改该医生的排班信息，获得排班信息主键
			DoctorSchedule doctorSchedule = SchedulePojoMapper.INSTANCE.parseToEntityForDoctorSchedule(registerDto.getDoctorScheduleVO());
			// 已挂号数量增加一个
			doctorSchedule.setUsedNum(doctorSchedule.getUsedNum() + 1);
			// 可挂号数量减少一个
			doctorSchedule.setSurplusNum(doctorSchedule.getSurplusNum() - 1);
			// 进行保存
			doctorScheduleDao.updateById(doctorSchedule);
			// 保存成功，根据主键查询，并且返回视图
			return RegisterPojoMapper.INSTANCE.parseToVOForRegisterRecord(registerDao.selectById(id));
		}
		return null;
	}
}
