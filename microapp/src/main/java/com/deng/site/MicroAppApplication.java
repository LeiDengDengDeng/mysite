package com.deng.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroAppApplication.class, args);
	}
}
