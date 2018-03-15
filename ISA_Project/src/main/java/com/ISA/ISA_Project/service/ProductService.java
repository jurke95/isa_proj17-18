package com.ISA.ISA_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.Product;
import com.ISA.ISA_Project.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository itemRepository;
	
	
	
	public List<Product>getAllItems(){
		
		return itemRepository.findAll();
	}
	
}
