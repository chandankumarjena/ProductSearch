package com.sapient.ProductSearch.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.ProductSearch.bean.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
