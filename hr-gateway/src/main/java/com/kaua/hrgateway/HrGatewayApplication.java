package com.kaua.hrgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class HrGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrGatewayApplication.class, args);
	}

}
