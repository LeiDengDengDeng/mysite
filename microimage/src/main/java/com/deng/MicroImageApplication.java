package com.deng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.deng.dao")
public class MicroImageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroImageApplication.class, args);
	}
}
