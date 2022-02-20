package com.whackon.witmed.base.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>项目基础框架 - 系统 Token 工具类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/15
 * @since 1.0.0
 */
public class TokenUtil {
	private static Logger logger = LoggerFactory.getLogger(TokenUtil.class);
	// 设置加密算法
	private static Algorithm algorithm = Algorithm.HMAC256(BaseConstants.BASE_SECRET_KEY);
	// 设置载荷对应的 key
	private static final String CLAIM_KEY = "CLAIM_KEY";
	// 设置 Token 消息头信息
	private static Map<String, Object> header = new HashMap<String, Object>();

	static {
		// 设置 Token 消息头信息
		header.put("typ", "jwt");
		header.put("alg", "HS256");
	}

	/**
	 * <b>创建 Token 信息</b>
	 * @param claimObj
	 * @param expireSec
	 * @return
	 */
	public static String createToken(Object claimObj, Long expireSec) {
		// 创建 JWT Token 信息对象
		JWTCreator.Builder builder = JWT.create();
		// 设置 JWT Token 消息头
		builder.withHeader(header);
		// 将需要添加的载荷变为 JSON 格式数据
		String claimJSON = "";
		try {
			// 创建 JsonMapper 对象
			JsonMapper jsonMapper = new JsonMapper();
			// 将载荷数据变为 JSON 格式数据
			claimJSON = jsonMapper.writeValueAsString(claimObj);
			// 将转换后的信息加载到载荷中
			builder.withClaim(CLAIM_KEY, claimJSON);
			// 计算过期日期
			Date expireDate = new Date(new Date().getTime() + expireSec * 1000);
			// 设置过期日期
			builder.withExpiresAt(expireDate);
			// 对 Token 信息进行签名生成 Token
			return builder.sign(algorithm);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage() + " : " + new Date(), e);
		}
		return "";
	}

	/**
	 * <b>根据所给定的 Token 进行校验并提取数据</b>
	 * @param token
	 * @param objClass
	 * @return
	 */
	public static Object verifyToken(String token, Class objClass) {
		if (token != null && !"".equals(token.trim())) {
			// 根据加密算法获得 Token 校验对象
			JWTVerifier jwtVerifier = JWT.require(algorithm).build();
			// 对 Token 进行校验
			try {
				// 校验 Token，获得 DecodedJWT 对象
				DecodedJWT decodedJWT = jwtVerifier.verify(token);
				if (decodedJWT != null) {
					// Token 校验成功，提取 Token 中的数据
					String claimJSON = decodedJWT.getClaim(CLAIM_KEY).asString();
					// 根据用户所给定的数据类型进行类型转换
					JsonMapper jsonMapper = new JsonMapper();
					// 将 JSON 格式的数据变为对象
					return jsonMapper.readValue(claimJSON, objClass);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage() + " : " + new Date(), e);
			}
		}
		return null;
	}
}
