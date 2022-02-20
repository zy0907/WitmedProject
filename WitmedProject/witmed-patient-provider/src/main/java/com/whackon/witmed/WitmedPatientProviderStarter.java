package com.whackon.witmed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>智慧医疗信息平台 - 患者功能 - Provider 项目启动类</b>
 *
 * @author Arthur
 * @version 1.0.0
 * @date 2022/2/19
 * @since 1.0.0
 */
@MapperScan("com.whackon.witmed.patient.*.dao")
@EnableEurekaClient
@SpringBootApplication
public class WitmedPatientProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(WitmedPatientProviderStarter.class, args);
	}
}
