package com.example.springbootpratice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@EnableSwagger2
//@EnableEurekaClient
@SpringBootApplication
public class SpringbootpraticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootpraticeApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.springbootpratice.controller")).build();
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Application Started !! ");
//	}

//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		System.out.println("Appication Started !!");
//		
//	}

}
