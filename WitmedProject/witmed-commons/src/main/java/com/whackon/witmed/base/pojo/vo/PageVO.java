package com.whackon.witmed.base.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <b>项目基础框架 - 系统分页视图信息</b>
 * <p>
 *     系统基础视图信息设置了如下属性：
 *     1、pageNum：当前页码<br/>
 *     2、pageSize：每页显示数量<br/>
 *     3、list：分页列表<br/>
 *     4、totalCount：总数量<br/>
 *     5、totalPage：总页数<br/>
 *     <p>所有项目功能分页信息都必须以本系统分页视图信息返回</p>
 * </p>
 *
 * @author zyuan
 * @date 2022/1/18
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class PageVO<E extends BaseVO> implements Serializable {
	private static final long serialVersionUID = -3458922961994208370L;
	private Integer pageNum;                        // 当前页码
	private Integer pageSize;                       // 每页显示数量
	private List<E> list;                           // 分页列表
	private Long totalCount;                        // 总数量
	private Long totalPage;                         // 总页数

	public PageVO() {}

	public PageVO(Integer pageNum, Integer pageSize) {
		if (pageNum != null && pageNum > 0) {
			this.pageNum = pageNum;
		} else {
			this.pageNum = 1;
		}

		if (pageSize != null && pageSize > 0) {
			this.pageSize = 10;
		}
	}
}
