package com.whackon.witmed.system.hospital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.hospital.dao.PositionDao;
import com.whackon.witmed.system.hospital.pojo.entity.Position;
import com.whackon.witmed.system.hospital.pojo.vo.PositionVO;
import com.whackon.witmed.system.hospital.service.PositionService;
import com.whackon.witmed.system.hospital.util.HospitalPojoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 人员身份信息业务层接口实现类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Service("positionService")
public class PositionServiceImpl implements PositionService {
	@Resource(name = "positionDao")
	private PositionDao positionDao;

	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<PositionVO> getPage(QueryPageVO<PositionVO> queryPageVO) throws Exception {
		// 根据查询视图创建 MyBatis Plus 的 QueryWrapper 对象
		QueryWrapper<Position> query = new QueryWrapper<Position>(
				HospitalPojoMapper.INSTANCE.parseToEntityForPosition(queryPageVO.getQueryVO()));
		// 开启 PageHelper 分页过滤器
		PageVO<PositionVO> pageVO = queryPageVO.getPageVO();
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行列表查询，并且创建 PageInfo 对象
		PageInfo<Position> pageInfo = new PageInfo<Position>(positionDao.selectList(query));
		// 提取信息封装 PageVO
		// 提取分页列表，并且转换为视图列表
		pageVO.setList(HospitalPojoMapper.INSTANCE.parseToVOListForPosition(pageInfo.getList()));
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
	public List<PositionVO> getList(PositionVO queryVO) throws Exception {
		// 根据查询视图创建 MyBatis Plus 的 QueryWrapper 对象
		QueryWrapper<Position> query = new QueryWrapper<Position>(HospitalPojoMapper.INSTANCE.parseToEntityForPosition(queryVO));
		// 进行查询，获得实体列表
		List<Position> entityList = positionDao.selectList(query);
		// 将实体列表转换为视图列表，返回结果
		return HospitalPojoMapper.INSTANCE.parseToVOListForPosition(entityList);
	}

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public PositionVO getById(Long id) throws Exception {
		// 查询获得实体信息
		Position entity = positionDao.selectById(id);
		// 将实体信息转换为视图信息
		return HospitalPojoMapper.INSTANCE.parseToVOForPosition(entity);
	}

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public PositionVO getByCode(String code) throws Exception {
		// 查询获得实体信息
		Position entity = positionDao.selectOne(new QueryWrapper<Position>().eq("code", code));
		// 将实体信息转换为视图信息
		return HospitalPojoMapper.INSTANCE.parseToVOForPosition(entity);
	}

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(PositionVO saveVO) throws Exception {
		// 将视图转换为实体，进行保存
		int count = positionDao.insert(HospitalPojoMapper.INSTANCE.parseToEntityForPosition(saveVO));
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
	public boolean update(PositionVO updateVO) throws Exception {
		// 将视图转换为实体，进行保存
		int count = positionDao.updateById(HospitalPojoMapper.INSTANCE.parseToEntityForPosition(updateVO));
		if (count > 0) {
			return true;
		}
		return false;
	}
}
