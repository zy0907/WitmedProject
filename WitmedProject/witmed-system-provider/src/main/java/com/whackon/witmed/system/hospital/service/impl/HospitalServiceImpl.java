package com.whackon.witmed.system.hospital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.hospital.dao.HospitalDao;
import com.whackon.witmed.system.hospital.pojo.entity.Hospital;
import com.whackon.witmed.system.hospital.pojo.vo.HospitalVO;
import com.whackon.witmed.system.hospital.service.HospitalService;
import com.whackon.witmed.system.hospital.util.HospitalPojoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 学历业务层接口实现类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@Service("hospitalService")
@Transactional
public class HospitalServiceImpl implements HospitalService {
	@Resource(name = "hospitalDao")
	private HospitalDao hospitalDao;

	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<HospitalVO> getPage(QueryPageVO<HospitalVO> queryPageVO) throws Exception {
		// 根据查询视图创建 MyBatis Plus 的 QueryWrapper 对象
		QueryWrapper<Hospital> query = new QueryWrapper<Hospital>(
				HospitalPojoMapper.INSTANCE.parseToEntityForHospital(queryPageVO.getQueryVO()));
		// 开启 PageHelper 分页过滤器
		PageVO<HospitalVO> pageVO = queryPageVO.getPageVO();
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行列表查询，并且创建 PageInfo 对象
		PageInfo<Hospital> pageInfo = new PageInfo<Hospital>(hospitalDao.selectList(query));
		// 提取信息封装 PageVO
		// 提取分页列表，并且转换为视图列表
		pageVO.setList(HospitalPojoMapper.INSTANCE.parseToVOListForHospital(pageInfo.getList()));
		// 提取总条数和总页数
		pageVO.setTotalCount(pageInfo.getTotal());
		pageVO.setTotalPage((long) pageInfo.getPages());
		return pageVO;
	}

	/**
	 * <b>根据查询信息进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<HospitalVO> getList(HospitalVO queryVO) throws Exception {
		// 根据查询视图创建 MyBatis Plus 的 QueryWrapper 对象
		QueryWrapper<Hospital> query = new QueryWrapper<Hospital>(HospitalPojoMapper.INSTANCE.parseToEntityForHospital(queryVO));
		// 进行查询，获得实体列表
		List<Hospital> entityList = hospitalDao.selectList(query);
		// 将实体列表转换为视图列表，返回结果
		return HospitalPojoMapper.INSTANCE.parseToVOListForHospital(entityList);
	}

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public HospitalVO getById(Long id) throws Exception {
		// 查询获得实体信息
		Hospital entity = hospitalDao.selectById(id);
		// 将实体信息转换为视图信息
		return HospitalPojoMapper.INSTANCE.parseToVOForHospital(entity);
	}

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public HospitalVO getByCode(String code) throws Exception {
		// 查询获得实体信息
		Hospital entity = hospitalDao.selectOne(new QueryWrapper<Hospital>().eq("code", code));
		// 将实体信息转换为视图信息
		return HospitalPojoMapper.INSTANCE.parseToVOForHospital(entity);
	}

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(HospitalVO saveVO) throws Exception {
		// 将视图转换为实体，进行保存
		int count = hospitalDao.insert(HospitalPojoMapper.INSTANCE.parseToEntityForHospital(saveVO));
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>修改信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean update(HospitalVO updateVO) throws Exception {
		// 将视图转换为实体，进行保存
		int count = hospitalDao.updateById(HospitalPojoMapper.INSTANCE.parseToEntityForHospital(updateVO));
		if (count > 0) {
			return true;
		}
		return false;
	}
}
