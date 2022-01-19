package com.whackon.witmed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>智慧医疗信息平台 - 系统功能 - Provider 项目启动类</b>
 *
 * @author zyuan
 * @date 2022/1/18
 * @version 1.0.0
 * @since 1.0.0
 */
@MapperScan("com.whackon.witmed.system.*.dao")
@EnableEurekaClient
@SpringBootApplication
public class WitmedSystemProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(WitmedSystemProviderStarter.class, args);
	}
}
