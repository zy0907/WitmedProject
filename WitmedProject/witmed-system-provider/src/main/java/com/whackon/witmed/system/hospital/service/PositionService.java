package com.whackon.witmed.system.hospital.service;


import com.whackon.witmed.base.pojo.vo.PageVO;
import com.whackon.witmed.base.pojo.vo.QueryPageVO;
import com.whackon.witmed.system.hospital.pojo.vo.PositionVO;

import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 学历业务层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
public interface PositionService {
	/**
	 * <b>根据查询信息进行分页查询</b>
	 * @param queryPageVO
	 * @return
	 * @throws Exception
	 */
	PageVO<PositionVO> getPage(QueryPageVO<PositionVO> queryPageVO) throws Exception;

	/**
	 * <b>根据查询信息进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<PositionVO> getList(PositionVO queryVO) throws Exception;

	/**
	 * <b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	PositionVO getById(Long id) throws Exception;

	/**
	 * <b>根据编码查询信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	PositionVO getByCode(String code) throws Exception;

	/**
	 * <b>保存信息</b>
	 * @param saveVO
	 * @return
	 * @throws Exception
	 */
	boolean save(PositionVO saveVO) throws Exception;

	/**
	 * <b>修改信息</b>
	 * @param updateVO
	 * @return
	 * @throws Exception
	 */
	boolean update(PositionVO updateVO) throws Exception;
}
