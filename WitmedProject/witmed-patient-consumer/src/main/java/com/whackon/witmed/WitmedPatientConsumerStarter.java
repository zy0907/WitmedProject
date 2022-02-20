package com.whackon.witmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>智慧医疗信息平台 - 患者功能 - Consumer 项目启动类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class WitmedPatientConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(WitmedPatientConsumerStarter.class, args);
	}
}
