package com.whackon.witmed.system.tech.service;


import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.tech.pojo.vo.TechRankVO;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 人员身份信息业务层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
public interface TechRankService {
	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	PageVO<TechRankVO> getPage(QueryPageVO<TechRankVO> queryPageVO) throws Exception;

	/**
	 * <b>根据查询信息进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<TechRankVO> getList(TechRankVO queryVO) throws Exception;

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	TechRankVO getById(Long id) throws Exception;

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	TechRankVO getByCode(String code) throws Exception;

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	boolean save(TechRankVO saveVO) throws Exception;

	/**
	 * <b>修改信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	boolean update(TechRankVO updateVO) throws Exception;
}
