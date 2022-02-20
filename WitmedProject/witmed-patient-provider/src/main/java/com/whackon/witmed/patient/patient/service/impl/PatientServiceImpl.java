package com.whackon.witmed.patient.patient.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whackon.witmed.base.util.IdGenerator;
import com.whackon.witmed.patient.patient.dao.PatientDao;
import com.whackon.witmed.patient.patient.pojo.entity.Patient;
import com.whackon.witmed.patient.patient.pojo.vo.IdInfoVO;
import com.whackon.witmed.patient.patient.pojo.vo.PatientVO;
import com.whackon.witmed.patient.patient.service.PatientService;
import com.whackon.witmed.patient.patient.util.PatientNoUtil;
import com.whackon.witmed.patient.patient.util.PatientPojoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>智慧医疗信息平台 - 患者功能 - 患者业务层接口实现类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据证件号码查询患者信息</b>
	 * @param idNo
	 * @return
	 * @throws Exception
	 */
	@Override
	public PatientVO getByIdNo(String idNo) throws Exception {
		// 进行数据查询
		Patient entity = patientDao.selectOne(new QueryWrapper<Patient>().eq("idNo", idNo));
		// 将实体转换为视图，进行返回
		return PatientPojoMapper.INSTANCE.parseToVOForPatient(entity);
	}

	/**
	 * <b>根据患者证件信息进行保存</b>
	 * @param idInfoVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PatientVO saveByIdInfo(IdInfoVO idInfoVO) throws Exception {
		// 将用户证件视图信息转换为患者实体信息
		Patient entity = PatientPojoMapper.INSTANCE.parseToEntityByIdInfoVO(idInfoVO);
		// 生成主键
		String id = idGenerator.createId();
		entity.setId(id);
		// 生成患者病历号
		entity.setEmrNo(PatientNoUtil.createEmrNo());
		// 进行保存
		if (patientDao.insert(entity) > 0) {
			// 根据主键查询
			return PatientPojoMapper.INSTANCE.parseToVOForPatient(patientDao.selectById(id));
		}
		return null;
	}
}
