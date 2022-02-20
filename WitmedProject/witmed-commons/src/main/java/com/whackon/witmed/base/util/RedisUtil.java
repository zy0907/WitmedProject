package com.whackon.witmed.base.util;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <b>项目基础框架 - Redis 操作工具类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
@Component("redisUtil")
public class RedisUtil {
	private Logger logger = LoggerFactory.getLogger(RedisUtil.class);
	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * <b>将所给定的信息存入 Redis 中</b>
	 * @param key
	 * @param value
	 * @param expireSec
	 * @return
	 */
	public boolean saveToRedis(String key, Object value, Long expireSec) {
		// 创建 JsonMapper 对象，用于将所给定的 Object 类型 value 变成 JSON 格式数据
		JsonMapper jsonMapper = new JsonMapper();
		try {
			// 将 Object 类型的数据转换为 JSON 格式的数据
			String valueJSON = jsonMapper.writeValueAsString(value);
			// 将对应的数据，以给定的 key 存入到 Redis 中
			redisTemplate.opsForValue().set(key, valueJSON);
			// 设置存储的时间
			redisTemplate.expire(key, expireSec, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage() + " : " + new Date(), e);
		}
		return false;
	}

	/**
	 * <b>根据所给定的 key 从 Redis 中查询数据</b>
	 * @param key
	 * @param typeClass
	 * @return
	 */
	public Object findFromRedis(String key, Class typeClass) {
		// 通过 key 从 Redis 中查询 JSON 格式数据
		String valueJSON = redisTemplate.opsForValue().get(key);
		// 判断是否能够查询到数据
		if (valueJSON != null && !"".equals(valueJSON.trim())) {
			// 根据 key 从 Redis 中查询到数据，创建 JsonMapper 对象
			JsonMapper jsonMapper = new JsonMapper();
			try {
				// 根据所给定的数据类型进行数据转换
				return jsonMapper.readValue(valueJSON, typeClass);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage() + " : " + new Date(), e);
			}
		}
		return null;
	}
}
