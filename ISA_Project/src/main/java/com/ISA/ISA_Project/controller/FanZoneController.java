package com.ISA.ISA_Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ISA.ISA_Project.domain.Ad;
import com.ISA.ISA_Project.domain.Cinema;
import com.ISA.ISA_Project.domain.Product;
import com.ISA.ISA_Project.repository.FanZoneRepository;
import com.ISA.ISA_Project.repository.ProductRepository;
import com.ISA.ISA_Project.response.AdResponse;
import com.ISA.ISA_Project.response.CinemaResponse;
import com.ISA.ISA_Project.response.ProductResponse;
import com.ISA.ISA_Project.service.AdService;
import com.ISA.ISA_Project.service.ProductService;

@RestController
@RequestMapping("/fanzone")
public class FanZoneController {

	
	@Autowired
	private FanZoneRepository fanzoneRepository;
	
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private AdService adService;
	
	
	
	@GetMapping("/getProducts")
	public ProductResponse getProducts() {

		List<Product>listp=productService.getAllItems();
		return new ProductResponse(listp);
		
		
	}
	
	
	@GetMapping("/getAds")
	public AdResponse getAds() {

		List<Ad>lista=adService.getAllItems();
		return new AdResponse(lista);
		
		
	}
	
}
