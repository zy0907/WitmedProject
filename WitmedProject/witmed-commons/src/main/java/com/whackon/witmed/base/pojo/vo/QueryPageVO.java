package com.whackon.witmed.base.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <b>项目基础框架 - 系统查询分页视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
public class QueryPageVO<E extends BaseVO> implements Serializable {
	private static final long serialVersionUID = -7051580131896636576L;
	private E queryVO;                      // 查询视图
	private PageVO<E> pageVO;               // 分页视图

	public QueryPageVO() {}

	public QueryPageVO(E queryVO, PageVO<E> pageVO) {
		this.queryVO = queryVO;
		this.pageVO = pageVO;
	}

	public QueryPageVO(E queryVO, Integer pageNum, Integer pageSize) {
		// 根据 pageNum 和 pageSize 创建 PageVO 对象
		PageVO<E> pageVO = new PageVO<E>(pageNum, pageSize);
		this.pageVO = pageVO;
		this.queryVO = queryVO;
	}
}
