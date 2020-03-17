package com.feign.feigndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeigndemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeigndemoApplication.class, args);
	}

}
