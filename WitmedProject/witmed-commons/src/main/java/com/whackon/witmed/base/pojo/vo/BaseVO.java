package com.whackon.witmed.base.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>项目基础框架 - 系统基础视图信息</b>
 * <p>
 *     系统基础视图信息设置了如下属性：
 *     1、status：系统状态（0-禁用，1-启用）<br/>
 *     2、createdTime：创建时间<br/>
 *     3、modifiedTime：修改时间<br/>
 *     <p>所有项目功能视图信息都必须继承于本系统基础视图信息</p>
 * </p>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Data
public class BaseVO implements Serializable {
	private static final long serialVersionUID = 5307507834353921384L;
	private String status;                      // 系统状态：0-禁用，1-启用
	private Date createdTime;                   // 创建时间
	private Date modifiedTime;                  // 修改时间
}
