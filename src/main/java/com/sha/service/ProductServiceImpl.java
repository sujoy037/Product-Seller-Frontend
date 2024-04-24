package com.sha.service;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.stereotype.Service;

import com.sha.model.Product;
import com.sha.repository.ProductRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		product.setCreateTime(LocalDateTime.now());

		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

}
