package com.whackon.witmed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>智慧医疗信息平台 - 门诊功能模块 - Provider 启动类</b>
 *
 * @author zyuan
 * @date 2022/01/13
 * @version 1.0.0
 * @since 1.0.0
 */
@MapperScan("com.whackon.witmed.system.*.dao")
@EnableEurekaClient
@SpringBootApplication
public class OpcProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(OpcProviderStarter.class, args);
	}
}
