package com.whackon.witmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>智慧医疗信息平台 - 病人功能模块 - Consumer 启动类</b>
 *
 * @author zyuan
 * @date 2022/01/13
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class PaConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(PaConsumerStarter.class, args);
	}
}
