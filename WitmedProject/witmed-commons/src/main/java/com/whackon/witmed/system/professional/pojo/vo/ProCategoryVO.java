package com.whackon.witmed.system.professional.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 专业职务类别视图信息</b>
 *
 * @author Arthur
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class ProCategoryVO extends BaseVO {
	private static final long serialVersionUID = -7472848463806780173L;
	private Integer id;    //主键
	private String code;   //类别编码
	private String name;   //类别名称
}
