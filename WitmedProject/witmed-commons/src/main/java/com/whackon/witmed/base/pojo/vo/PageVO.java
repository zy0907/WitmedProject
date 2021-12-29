package com.whackon.witmed.base.pojo.vo;

import java.io.Serializable;
import java.util.List;

/**
 * <b>基础信息功能 - 系统分页视图信息</b>
 *
 * @author zyuan
 * @date 2021/12/29
 * @since
 */
public class PageVO<E extends BaseVO> implements Serializable {
	private static final long serialVersionUID = -455093949216052594L;
	private Integer pageNum;                        // 当前页码
	private Integer pageSize;                       // 每页显示数量
	private List<E> list;                           // 分页列表
	private Long totalCount;                        // 总条数
	private Integer totalPage;                      // 总页数

	public PageVO() {}

	public PageVO(Integer pageNum, Integer pageSize) {
		if (pageNum != null && pageNum > 0) {
			this.pageNum = pageNum;
		} else {
			this.pageNum = 1;
		}

		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = 10;
		}
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
