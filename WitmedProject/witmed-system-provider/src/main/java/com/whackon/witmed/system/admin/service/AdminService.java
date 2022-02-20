package com.whackon.witmed.system.admin.service;

import com.whackon.witmed.system.admin.pojo.vo.AdminVO;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 系统人员业务层接口</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/17
 * @since 1.0.0
 */
public interface AdminService {
	/**
	 * <b>根据手机号码查询信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	AdminVO getByCellphone(String cellphone) throws Exception;
}
