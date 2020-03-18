package com.sapient.ProductSearch.controller;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sapient.ProductSearch.bean.Product;
import com.sapient.ProductSearch.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SearchController.class)
public class SearchControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;
	
	Product mockProduct = new Product(1,200,"sku1","duke","red","xl","xxx");
	Optional<Product> optionalMockProduct = Optional.of(mockProduct);
	
	@Test
	public void getGroupByProducts() throws Exception{
		
	}
	
	@Test
	public void getProductsBySKU() throws Exception{
		Mockito.when(
				productService.getProductsBySKU(Mockito.anyString()))
				.thenReturn(optionalMockProduct);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/products/skus/sku1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:1,price:200,skuId:sku1,brand:duke,color:red,size:xl,seller:xxx}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void getNumberOfProductBySeller() throws Exception{
		
	}
}
