package com.deng.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroAppApplication.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		return restTemplate;
	}
}
