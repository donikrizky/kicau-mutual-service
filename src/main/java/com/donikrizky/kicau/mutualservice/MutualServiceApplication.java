package com.donikrizky.kicau.mutualservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.donikrizky.kicau.mutualservice.config.JwtConfig;

@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableHystrix
@SpringBootApplication
@EnableAutoConfiguration
public class MutualServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutualServiceApplication.class, args);
	}

	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}
}
