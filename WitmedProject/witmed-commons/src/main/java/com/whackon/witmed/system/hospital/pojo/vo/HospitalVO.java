package com.whackon.witmed.system.hospital.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 医院视图信息</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/16
 * @since 1.0.0
 */
@Data
public class HospitalVO extends BaseVO {
	private static final long serialVersionUID = -4229064825457047768L;
	private Long id;                        // 主键
	private String name;                    // 机构名称
	private String authority;               // 上级主管机构名称
	private String orgCode;                 // 组织机构代码
	private String orgLeader;               // 机构负责人
	private String addrCatCode;             // 标识地址类别的代码
	private String province;                // 地址-省（自治区、直辖市）
	private String city;                    // 地址-市（地区）
	private String county;                  // 地址-县（区）
	private String countryside;             // 地址-乡（镇、街道办事处）
	private String village;                 // 地址-村（街、路、弄等）
	private String doorNo;                  // 地址-门牌号码
	private String zipcode;                 // 邮政编码
	private String division;                // 行政区划代码
	private String phoneCat;                // 联系电话-类别信息
	private String phone;                   // 联系电话-号码
	private String email;                   // 电子邮件地址
}