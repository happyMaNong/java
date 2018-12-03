package com.df;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.df.mapper")
@EnableTransactionManagement
@EnableDiscoveryClient
public class Ch0602Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch0602Application.class, args);
	}
}
