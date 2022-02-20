package com.whackon.witmed.system.hospital.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统人员部门视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@Data
public class DepartmentVO extends BaseVO {
	private static final long serialVersionUID = -1482843891494676364L;
	private Long id;                        // 主键
	private HospitalVO hospitalVO;          // 所在医院
	private DepartmentVO parentVO;          // 上级部门
	@NotBlank
	private String code;                    // 部门编码
	@NotBlank
	private String name;                    // 部门名称
}
