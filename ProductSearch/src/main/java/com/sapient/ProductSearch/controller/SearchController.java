package com.sapient.ProductSearch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.ProductSearch.bean.Product;
import com.sapient.ProductSearch.service.ProductService;

@RestController
public class SearchController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/products/{filterBy}/{data}")
	public List<Product> getGroupByProducts(@PathVariable String filterBy, @PathVariable String data){		
		return productService.getGroupByProduct(filterBy, data);
	}
	
	@GetMapping("/products/sku/{skuName}")
	public Optional<Product> getProductsBySKU(@PathVariable String skuName){
		return productService.getProductsBySKU(skuName);
	}
	
	@GetMapping("/products/seller/{sellerName}")
	public long getNumberOfProductBySeller(@PathVariable String sellerName){
		return productService.getNumberOfProductBySeller(sellerName);
	}
}
