package com.example.springbootpratice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.springbootpratice.model.Product;
import com.example.springbootpratice.model.ProductNotFoundException;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	static Map<Integer,Product> products=new HashMap<Integer,Product>();
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public String addProduct(Product product) {
		String insertQuery = "insert into PRODUCTS(ID,NAME,PRICE) values(?,?,?)";
		int count = jdbcTemplate.update(insertQuery, new Object[] {product.getId(),product.getName(),product.getPrice()});
		
		if(count>0)
			return "SUCCESS";
		else
			return "FAILURE";
	}
	
	@Override
	public List<Product> getProducts() {
		
		String selectQuery = "select * from PRODUCTS";
		List<Product> products = jdbcTemplate.query(selectQuery, new RowMapper<Product>(){

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("ID"));
				product.setName(rs.getString("NAME"));
				product.setPrice(rs.getInt("PRICE"));
				return product;
			}});
		return products;
		
		//return ((Map<Integer, Product>) products).values().stream().collect(Collectors.toList());
	}
	
	@Override
	public String updateProduct(int id,Product product) {
		//products.put(id, product);
		int count = jdbcTemplate.update("update PRODUCTS set PRICE=? where ID=?", new Object[] {product.getPrice(),id});
		
		if(count>0)
			return "SUCCESS";
		else
			return "FAILURE";
	}
	
	@Override
	public String deleteProduct(int id) {
		//products.remove(id);
		int count = jdbcTemplate.update("delete from PRODUCTS where ID=?", new Object[] {id});
		
		if(count>0)
			return "SUCCESS";
		else
			return "FAILURE";
	}
	
	@Override
	public Product searchProduct(int id) {
		/*
		 * if(products.containsKey(id)) return products.get(id); else throw new
		 * ProductNotFoundException();
		 */
		Product product = jdbcTemplate.queryForObject("select * from PRODUCTS where ID=?", new Object[] {id}, new BeanPropertyRowMapper<Product>(Product.class));
		return product;
		
	}

	@Override
	public Product searchProduct(String name) {
		Product product = jdbcTemplate.queryForObject("select * from PRODUCTS where name like %?%", new Object[] {name}, new BeanPropertyRowMapper<Product>(Product.class));
		return product;
	}

}
