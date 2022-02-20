package com.whackon.witmed.system.tech.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.tech.dao.TechTitleDao;
import com.whackon.witmed.system.tech.pojo.entity.TechTitle;
import com.whackon.witmed.system.tech.pojo.vo.TechTitleVO;
import com.whackon.witmed.system.tech.service.TechTitleService;
import com.whackon.witmed.system.tech.util.TechPojoMapper;
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
@Service("techTitleService")
@Transactional
public class TechTitleServiceImpl implements TechTitleService {
	@Resource(name = "techTitleDao")
	private TechTitleDao techTitleDao;

	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<TechTitleVO> getPage(QueryPageVO<TechTitleVO> queryPageVO) throws Exception {
		// 根据查询视图创建 MyBatis Plus 的 QueryWrapper 对象
		QueryWrapper<TechTitle> query = new QueryWrapper<TechTitle>(
				TechPojoMapper.INSTANCE.parseToEntityForTechTitle(queryPageVO.getQueryVO()));
		// 开启 PageHelper 分页过滤器
		PageVO<TechTitleVO> pageVO = queryPageVO.getPageVO();
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行列表查询，并且创建 PageInfo 对象
		PageInfo<TechTitle> pageInfo = new PageInfo<TechTitle>(techTitleDao.selectList(query));
		// 提取信息封装 PageVO
		// 提取分页列表，并且转换为视图列表
		pageVO.setList(TechPojoMapper.INSTANCE.parseToVOListForTechTitle(pageInfo.getList()));
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
	public List<TechTitleVO> getList(TechTitleVO queryVO) throws Exception {
		// 根据查询视图创建 MyBatis Plus 的 QueryWrapper 对象
		QueryWrapper<TechTitle> query = new QueryWrapper<TechTitle>(TechPojoMapper.INSTANCE.parseToEntityForTechTitle(queryVO));
		// 进行查询，获得实体列表
		List<TechTitle> entityList = techTitleDao.selectList(query);
		// 将实体列表转换为视图列表，返回结果
		return TechPojoMapper.INSTANCE.parseToVOListForTechTitle(entityList);
	}

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public TechTitleVO getById(Long id) throws Exception {
		// 查询获得实体信息
		TechTitle entity = techTitleDao.selectById(id);
		// 将实体信息转换为视图信息
		return TechPojoMapper.INSTANCE.parseToVOForTechTitle(entity);
	}

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public TechTitleVO getByCode(String code) throws Exception {
		// 查询获得实体信息
		TechTitle entity = techTitleDao.selectOne(new QueryWrapper<TechTitle>().eq("code", code));
		// 将实体信息转换为视图信息
		return TechPojoMapper.INSTANCE.parseToVOForTechTitle(entity);
	}

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(TechTitleVO saveVO) throws Exception {
		// 将视图转换为实体，进行保存
		int count = techTitleDao.insert(TechPojoMapper.INSTANCE.parseToEntityForTechTitle(saveVO));
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
	public boolean update(TechTitleVO updateVO) throws Exception {
		// 将视图转换为实体，进行保存
		int count = techTitleDao.updateById(TechPojoMapper.INSTANCE.parseToEntityForTechTitle(updateVO));
		if (count > 0) {
			return true;
		}
		return false;
	}
}
