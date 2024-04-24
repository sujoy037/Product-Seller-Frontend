package com.sha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
