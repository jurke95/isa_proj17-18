package com.ISA.ISA_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.Ad;
import com.ISA.ISA_Project.domain.Product;
import com.ISA.ISA_Project.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	
	
	public List<Product>getAllItems(){
		
		return productRepository.findAll();
	}
	
	public Product getProduct(Long id){
		
		return productRepository.findOneById(id);
	}
	
	
	
	
	public boolean checkUniqueProduct(Long id) {
		if (productRepository.findOneById(id) != null) {
			return false;
		}
		return true;
	}
	
	public Product saveProduct(Product product) {
    	productRepository.save(product);
    	return product;
    }
	
	public void deleteProduct(Long id){
		
		productRepository.delete(productRepository.findOneById(id));
	}
	
	
}
