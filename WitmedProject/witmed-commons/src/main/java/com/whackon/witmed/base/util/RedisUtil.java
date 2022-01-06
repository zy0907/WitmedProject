package com.whackon.witmed.base.util;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <b>基础信息功能 - Redis 操作工具类</b>
 *
 * @author Arthur
 * @date 2022/1/6
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("redisUtil")
public class RedisUtil {
	@Autowired
	private StringRedisTemplate redisTemplate;
	private Logger logger = LoggerFactory.getLogger(RedisUtil.class);

	/**
	 * <b>根据所给定的 key 和 value 将信息存储到 Redis 中</b>
	 * @param key
	 * @param value
	 * @param expireSec
	 * @return
	 */
	public boolean saveToRedis(String key, Object value, Long expireSec) {
		try {
			// 将 Object 类型的 value 变为 String 类型的 JSON
			// 创建 JsonMapper 对象
			JsonMapper jsonMapper = new JsonMapper();
			String JSONString = jsonMapper.writeValueAsString(value);
			// 存储到 Redis 中
			redisTemplate.opsForValue().set(key, JSONString);
			// 设定存储时长
			redisTemplate.expire(key, expireSec, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage() + " : " + new Date(), e);
		}
		return false;
	}

	/**
	 * <b>根据 key 和所给定的数据类型，从 Redis 中获得对象</b>
	 * @param key
	 * @param type
	 * @return
	 */
	public Object findFromRedis(String key, Class type) {
		try {
			// 通过 Redis 根据 Key 获得 String 类型的 value
			String jsonString = redisTemplate.opsForValue().get(key);
			// 判断是否能够获得有效的结果
			if (StrUtil.isNotBlank(jsonString)) {
				// 根据所给定的类型将字符串 JSON 变为对应的对象
				JsonMapper jsonMapper = new JsonMapper();
				return jsonMapper.readValue(jsonString, type);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage() + " : " + new Date(), e);
		}
		return null;
	}
}
