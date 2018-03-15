package com.ISA.ISA_Project.response;

import java.util.List;

import com.ISA.ISA_Project.domain.Product;

public class ProductResponse {

	
	private List<Product> products;
	
	
	public ProductResponse(List<Product>listProducts){
		
		
		this.products=listProducts;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	
	
}
