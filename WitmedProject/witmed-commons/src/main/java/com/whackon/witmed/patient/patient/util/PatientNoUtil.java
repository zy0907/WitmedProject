package com.whackon.witmed.patient.patient.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <b>智慧医疗信息平台 - 患者功能 - 患者编号工具类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
public class PatientNoUtil {
	/**
	 * <b>生成病人病历号</b>
	 * <p>
	 *     生成规则使用当前时间生成
	 * </p>
	 * @return
	 */
	public static String createEmrNo() {
		// 获得当前时间
		Date currentDate = new Date();
		// 设置对当前时间格式化对象 SimpleDateFormat
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
		// 对当前时间进行格式化
		return simpleDateFormat.format(currentDate);
	}
}
