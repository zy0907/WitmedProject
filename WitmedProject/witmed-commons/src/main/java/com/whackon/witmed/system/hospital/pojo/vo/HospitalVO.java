package com.whackon.witmed.system.hospital.pojo.vo;

import com.whackon.witmed.base.pojo.vo.BaseVO;
import lombok.Data;

/**
 * <b>系统功能 - 医院视图信息</b>
 *
 * @author Arthur
 * @date 2022/1/4
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class HospitalVO extends BaseVO {
	private static final long serialVersionUID = -5604109754746085573L;
	private Integer id;             //主键
	private String name;            //机构名称
	private String authority;       //上级主管机构名称
	private String orgCode;        //机构组织机构代码
	private String charge;         //机构负责人（法人）
	private String addressCatCode; //标识地址类别的代码
	private String province;       //所在省份
	private String city;           //所在市
	private String country;        //所在区县
	private String town;           //地址-乡（镇、街道办事处）
	private String village;        //地址-村（街、路、弄等）
	private String doorNo;         //地址-门牌号码
	private String zipCode;        //邮政编码
	private String divisionCode;   //行政区划代码
	private String cellphoneCat;   //联系电话-类别信息
	private String cellphone;      //联系电话-号码
	private String email;          //电子邮箱地址
}

