package com.whackon.witmed.base.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Properties;

/**
 * <b>项目基础框架 - 系统常量工具类</b>
 *
 * @author zyuan
 * @date 2022/1/18
 * @version 1.0.0
 * @since 1.0.0
 */
public class BaseConstants {
	private static Logger logger = LoggerFactory.getLogger(BaseConstants.class);
	private static Properties props = new Properties();

	static {
		try {
			props.load(BaseConstants.class.getClassLoader().getResourceAsStream("props/base/base.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage() + " : " + new Date(), e);
		}
	}

	/**
	 * <b>Token 私钥信息</b>
	 */
	public static String BASE_SECRET_KEY = props.getProperty("base.secret.key");

	/**
	 * <b>Token 默认有效时长（秒）</b>
	 */
	public static Long BASE_TOKEN_EXPIRE = Long.parseLong(props.getProperty("base.token.expire"));
}
