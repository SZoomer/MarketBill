package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {
	
	boolean addProduct(Product product);

	List<Product> getAllProduct();

	Product getProductById(int id);

	boolean updateProduct(Product product);

	List<Product> getProductByProductname(String productname);

}
