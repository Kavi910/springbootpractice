package com.example.springbootpratice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootpratice.dao.ProductDao;
import com.example.springbootpratice.model.Product;

@RestController
public class ProductsController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		String status = productDao.addProduct(product);
		if("SUCCESS".equalsIgnoreCase(status))
			return new ResponseEntity<String>("Product Added Successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Action Failed",HttpStatus.OK);
	}
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ResponseEntity<List<Product>> getProduct(){
		List<Product> productsList=productDao.getProducts();
		return new ResponseEntity<List<Product>>(productsList,HttpStatus.OK);
	}
	
	@RequestMapping(value="/searchProduct",method=RequestMethod.GET)
	public ResponseEntity<Product> searchProduct(@RequestParam("id") int id){
		Product product=productDao.searchProduct(id);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@RequestMapping(value="/searchProductbyName",method=RequestMethod.GET)
	public ResponseEntity<Product> searchProduct(@RequestParam("name") String name){
		Product product=productDao.searchProduct(name);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/products/{id}",method=RequestMethod.PUT)
	public ResponseEntity<String> updateProduct(@PathVariable("id") int id,@RequestBody Product product){
		String status = productDao.updateProduct(id,product);
		if("SUCCESS".equalsIgnoreCase(status))
			return new ResponseEntity<String>("Product Updated Successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Action Failed",HttpStatus.OK);
	}
	
	@RequestMapping(value="/products/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> updateProduct(@PathVariable("id") int id){
		String status = productDao.deleteProduct(id);
		if("SUCCESS".equalsIgnoreCase(status))
			return new ResponseEntity<String>("Product Deleted Successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Action Failed",HttpStatus.OK);
	}
	

}
