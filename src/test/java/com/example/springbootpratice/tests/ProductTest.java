package com.example.springbootpratice.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.springbootpratice.dao.ProductDao;
import com.example.springbootpratice.model.Product;

import junit.framework.Assert;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductTest {
	
	@Autowired
	ProductDao productDao;
	

	   @Test
	   public void shouldAddaNewOProductData() {
		   
		   Product product = new Product(12,"Lays",10);
		   String result = productDao.addProduct(product);
		   Assert.assertEquals("SUCCESS", result);
	   }

}
