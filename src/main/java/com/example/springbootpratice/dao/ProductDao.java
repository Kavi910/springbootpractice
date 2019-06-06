package com.example.springbootpratice.dao;

import java.util.List;

import com.example.springbootpratice.model.Product;

public interface ProductDao {
	
	public String addProduct(Product product);
	
	public List<Product>  getProducts();
	
	public String updateProduct(int id,Product product);
	
	public String deleteProduct(int id);
	
	public Product  searchProduct(int id);
	
	public Product  searchProduct(String name);

}
