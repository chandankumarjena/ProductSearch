package com.sapient.ProductSearch.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.sapient.ProductSearch.bean.Product;

@Component
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Cacheable("products")
	public List<Product> getGroupByProduct(String filterBy, String data){
		List<Product> products = productRepository.findAll();
		List<Product> filteredProduct = null;
		if(filterBy.equalsIgnoreCase("price")) {
			filteredProduct = products.stream().filter(p -> p.getPrice() == Double.parseDouble(data)).collect(Collectors.toList());
		} else if(filterBy.equalsIgnoreCase("brand")) {
			filteredProduct = products.stream().filter(p -> p.getBrand().equalsIgnoreCase(data)).collect(Collectors.toList());
		} else if(filterBy.equalsIgnoreCase("color")) {
			filteredProduct = products.stream().filter(p -> p.getColor().equalsIgnoreCase(data)).collect(Collectors.toList());
		} else if(filterBy.equalsIgnoreCase("size")) {
			filteredProduct = products.stream().filter(p -> p.getSize().equalsIgnoreCase(data)).collect(Collectors.toList());
		}
		return filteredProduct;
	}
	
	@Cacheable("optionalProduct")
	public Optional<Product> getProductsBySKU(String sku) {
		List<Product> products = productRepository.findAll();		
		return products.stream().filter(p -> p.getSkuId().equalsIgnoreCase(sku)).findFirst();
	}
	
	@Cacheable("calculateProduct")
	public long getNumberOfProductBySeller(String seller) {
		List<Product> products = productRepository.findAll();	
		return products.stream().filter(p -> p.getSeller().equalsIgnoreCase(seller)).count();
	}

}
