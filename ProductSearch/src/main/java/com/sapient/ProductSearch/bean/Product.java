package com.sapient.ProductSearch.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private int id;
	private double price;
	private String skuId;
	private String brand;
	private String color;
	private String size; 
	private String seller;
	
	public Product() {
		
	}
	
	
	public Product(int id, double price, String skuId, String brand, String color, String size, String seller) {
		super();
		this.id = id;
		this.price = price;
		this.skuId = skuId;
		this.brand = brand;
		this.color = color;
		this.size = size;
		this.seller = seller;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getSkuId() {
		return skuId;
	}


	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getSeller() {
		return seller;
	}


	public void setSeller(String seller) {
		this.seller = seller;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", skuId=" + skuId + ", brand=" + brand + ", color=" + color
				+ ", size=" + size + ", seller=" + seller + "]";
	}
	
	

}
