package com.whackon.witmed.system.tech.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.tech.dao.TechCategoryDao;
import com.whackon.witmed.system.tech.pojo.entity.TechCategory;
import com.whackon.witmed.system.tech.pojo.vo.TechCategoryVO;
import com.whackon.witmed.system.tech.service.TechCategoryService;
import com.whackon.witmed.system.tech.util.TechPojoMapper;
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
@Service("techCategoryService")
public class TechCategoryServiceImpl implements TechCategoryService {
	@Resource(name = "techCategoryDao")
	private TechCategoryDao techCategoryDao;

	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<TechCategoryVO> getPage(QueryPageVO<TechCategoryVO> queryPageVO) throws Exception {
		// 根据查询视图创建 MyBatis Plus 的 QueryWrapper 对象
		QueryWrapper<TechCategory> query = new QueryWrapper<TechCategory>(
				TechPojoMapper.INSTANCE.parseToEntityForTechCategory(queryPageVO.getQueryVO()));
		// 开启 PageHelper 分页过滤器
		PageVO<TechCategoryVO> pageVO = queryPageVO.getPageVO();
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行列表查询，并且创建 PageInfo 对象
		PageInfo<TechCategory> pageInfo = new PageInfo<TechCategory>(techCategoryDao.selectList(query));
		// 提取信息封装 PageVO
		// 提取分页列表，并且转换为视图列表
		pageVO.setList(TechPojoMapper.INSTANCE.parseToVOListForTechCategory(pageInfo.getList()));
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
	public List<TechCategoryVO> getList(TechCategoryVO queryVO) throws Exception {
		// 根据查询视图创建 MyBatis Plus 的 QueryWrapper 对象
		QueryWrapper<TechCategory> query = new QueryWrapper<TechCategory>(TechPojoMapper.INSTANCE.parseToEntityForTechCategory(queryVO));
		// 进行查询，获得实体列表
		List<TechCategory> entityList = techCategoryDao.selectList(query);
		// 将实体列表转换为视图列表，返回结果
		return TechPojoMapper.INSTANCE.parseToVOListForTechCategory(entityList);
	}

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public TechCategoryVO getById(Long id) throws Exception {
		// 查询获得实体信息
		TechCategory entity = techCategoryDao.selectById(id);
		// 将实体信息转换为视图信息
		return TechPojoMapper.INSTANCE.parseToVOForTechCategory(entity);
	}

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public TechCategoryVO getByCode(String code) throws Exception {
		// 查询获得实体信息
		TechCategory entity = techCategoryDao.selectOne(new QueryWrapper<TechCategory>().eq("code", code));
		// 将实体信息转换为视图信息
		return TechPojoMapper.INSTANCE.parseToVOForTechCategory(entity);
	}

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(TechCategoryVO saveVO) throws Exception {
		// 将视图转换为实体，进行保存
		int count = techCategoryDao.insert(TechPojoMapper.INSTANCE.parseToEntityForTechCategory(saveVO));
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
	public boolean update(TechCategoryVO updateVO) throws Exception {
		// 将视图转换为实体，进行保存
		int count = techCategoryDao.updateById(TechPojoMapper.INSTANCE.parseToEntityForTechCategory(updateVO));
		if (count > 0) {
			return true;
		}
		return false;
	}
}
