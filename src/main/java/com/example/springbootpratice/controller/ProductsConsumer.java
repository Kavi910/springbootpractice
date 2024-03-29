package com.example.springbootpratice.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springbootpratice.model.Product;

@RestController
public class ProductsConsumer {
	
	@Autowired 
	RestTemplate restTemplate;
	
	@RequestMapping(value = "/template/products")
	public String getProductList() {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8081/products", HttpMethod.GET, entity, String.class).getBody();
	   }

	@RequestMapping(value="/template/addProduct",method=RequestMethod.POST)
	public String addProducts(@RequestBody Product product) {
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
	      
	      return restTemplate.exchange("http://localhost:8081/products", HttpMethod.POST, entity, String.class).getBody();
		
	}
	
	@RequestMapping(value = "/template/deleteProduct/{id}",method=RequestMethod.DELETE)	
	public String delProduct(@PathVariable("id") String id) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8081/products/"+id, HttpMethod.DELETE, entity, String.class).getBody();
	   }

	 @RequestMapping(value = "/template/updateProduct/{id}", method = RequestMethod.PUT)
	   public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
	      
	      return restTemplate.exchange(
	         "http://localhost:8081/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
	   }
}
