package com.example.springbootpratice.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.example.springbootpratice.dao.ProductDao;

@Profile("test")
@Configuration
public class ProductServiceTestConfiguration {

	@Bean
	@Primary
	public ProductDao productService() {
		return Mockito.mock(ProductDao.class);
	}

}
