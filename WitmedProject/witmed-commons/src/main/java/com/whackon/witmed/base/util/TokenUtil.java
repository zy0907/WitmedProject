package com.whackon.witmed.base.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.security.Key;
import java.util.*;

/**
 * <b>基础信息功能 - Token 工具类</b>
 * <p>
 *     为了能够实现 Token 机制，选择借助于 JWT（JSON Web Token） 来实现，
 *     通过 JWT 能够实现一个唯一经过加密的 Token
 * </p>
 *
 * @author Arthur
 * @date 2022/1/6
 * @version 1.0.0
 * @since 1.0.0
 */
public class TokenUtil {
	// 设定系统加密算法
	private static Algorithm algorithm = Algorithm.HMAC256(BaseConstants.SECRET_KEY);

	/**
	 * <b>根据用户所给定的信息生成 Token</b>
	 * @param claimMap
	 * @param expireSec
	 * @return
	 */
	public static String createToken(Map<String, String> claimMap, Long expireSec) {
		// 创建 JWT Token 生成器
		JWTCreator.Builder builder = JWT.create();
		// 创建 Map 集合，用于设定生成 Token 的头部信息
		Map<String, Object> headerMap = new HashMap<String, Object>();
		// 设定 Token 的生成方式是使用了 jwt
		headerMap.put("typ", "jwt");
		// 设定整体 Token 的加密算法
		headerMap.put("alg", "HS256");
		// 设定头部信息
		builder.withHeader(headerMap);
		// 设定 Token 的有效载荷部分
		// 取出所给定的 Map 集合中的每一个 key-value 组合，逐一的添加到有效载荷中
		// 循环 Map 集合
//		Set<String> keySet = claimMap.keySet();
//		for (String key : keySet) {
//			Object value = claimMap.get(key);
//			builder.withClaim(key, String.valueOf(value));
//		}
		// 在 JDK 8 的时候提供了 foreach() 可能快速的实现对 Map 集合的循环
		claimMap.forEach((key, value) -> {
			builder.withClaim(key, value);
		});
		// 设置 Token 的有效时间，需要获得 Token 到期的时间 Date
		builder.withExpiresAt(new Date(System.currentTimeMillis() + expireSec * 1000));
		return builder.sign(algorithm);
	}

	/**
	 * <b>校验 Token 信息，获得该 Token 中的有效载荷数据</b>
	 * @param token
	 * @return
	 */
	public static Map<String, String> verifyToken(String token) {
		// 校验此时所给定的 Token 是符合相关形式的
		if (token != null && !"".equals(token.trim())) {
			// 此时 Token 格式有效
			// 获得 Token 校验对象 JWTVerifier
			JWTVerifier verifier = JWT.require(algorithm).build();
			// 对于该 Token 进行校验
			DecodedJWT decodedJWT = verifier.verify(token);
			// 如果能够获得 DecodedJWT 则说明通过秘钥能够将加密 Token 进行解密
			// 提取绑定在 Token 中的有效载荷信息
			Map<String, String> resultMap = new HashMap<String, String>();
			decodedJWT.getClaims().forEach((key, value) -> {
				resultMap.put(key, value.asString());
			});
			return resultMap;
		}
		return null;
	}
}
