package com.sha.service;

import java.util.List;

import com.sha.model.Product;

public interface ProductService {
	Product saveProduct(Product product);

	void deleteProduct(Long id);

	List<Product> findAllProducts();

}
