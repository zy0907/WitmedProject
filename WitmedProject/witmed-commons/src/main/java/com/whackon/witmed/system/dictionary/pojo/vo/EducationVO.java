package com.whackon.witmed.system.dictionary.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 学历视图信息</b>
 *
 * @author Arthur
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class EducationVO extends BaseVO {
	private static final long serialVersionUID = 5407503726036271826L;
	private Integer id;       //主键
	private String code;      //学历编号
	private String name;      //学历名称

}
