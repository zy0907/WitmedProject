package com.whackon.witmed.emr.resume.service.impl;

import com.whackon.witmed.base.util.IdGenerator;
import com.whackon.witmed.emr.resume.dao.ResumeDao;
import com.whackon.witmed.emr.resume.pojo.entity.Resume;
import com.whackon.witmed.emr.resume.pojo.vo.ResumeVO;
import com.whackon.witmed.emr.resume.service.ResumeService;
import com.whackon.witmed.emr.resume.util.ResumePojoMapper;
import com.whackon.witmed.opc.register.pojo.vo.RegisterRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>智慧医疗信息平台 - 电子病历功能 - 病历概要数据业务层接口实现类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@Service("resumeService")
@Transactional
public class ResumeServiceImpl implements ResumeService {
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>增加病历概要信息</b>
	 * @param registerRecordVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public ResumeVO saveByRegisterRecordVO(RegisterRecordVO registerRecordVO) throws Exception {
		// 获得病历概要数据实体
		Resume entity = ResumePojoMapper.INSTANCE.parseToEntityByRegisterRecordVO(registerRecordVO);
		// 获得主键
		String id = idGenerator.createId();
		entity.setId(id);
		// 进行保存
		if (resumeDao.insert(entity) > 0) {
			return ResumePojoMapper.INSTANCE.parseToVOForResume(resumeDao.selectById(id));
		}
		return null;
	}
}
