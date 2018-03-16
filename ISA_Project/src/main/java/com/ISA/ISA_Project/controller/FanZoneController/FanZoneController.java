package com.ISA.ISA_Project.controller.FanZoneController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ISA.ISA_Project.controller.FanZoneController.dto.AdDTO;
import com.ISA.ISA_Project.controller.FanZoneController.dto.ProductDTO;
import com.ISA.ISA_Project.controller.dto.MessageResponseDTO;
import com.ISA.ISA_Project.domain.Ad;
import com.ISA.ISA_Project.domain.Cinema;
import com.ISA.ISA_Project.domain.Product;
import com.ISA.ISA_Project.domain.User;
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
	
	@GetMapping("getProducts/{id}")
	public Product getProduct(@PathVariable("id")Long id){
		
		Product product=productService.getProduct(id);
		return product;
	}
	
	@GetMapping("getAds/{id}")
	public Ad getAds(@PathVariable("id")Long id){
		
		Ad ad=adService.getAd(id);
		return ad;
	}
	
	
	@PostMapping("/addProducts")
	public MessageResponseDTO addProduct(@RequestBody ProductDTO productDTO){
		
		Product p=new Product();
		if (!(productService.checkUniqueProduct(productDTO.getId()))) {
			return new MessageResponseDTO("This product already exists");
		}
		
		p.setName(productDTO.getName());
		p.setDescription(productDTO.getDescription());
		p.setImage(productDTO.getImage());
		p.setBoxoffice(productDTO.getBoxoffice());
		
		Product temp=productService.saveProduct(p);
		

		if (temp == null) 
			return new MessageResponseDTO("Cannot add product");
		
		
		
		
		return new MessageResponseDTO("Successfully added product");
	}
	
	@PostMapping("/addAd")
	public MessageResponseDTO addAd(@RequestBody AdDTO adDTO){
		
		Ad a=new Ad();
		if (!(adService.checkUniqueAd(adDTO.getId()))) {
			return new MessageResponseDTO("This ad already exists");
		}
		
		a.setName(adDTO.getName());
		a.setDescription(adDTO.getDescription());
		a.setImage(adDTO.getImage());
		a.setDate(adDTO.getDate());
		
		Ad temp=adService.saveAd(a);
		

		if (temp == null) 
			return new MessageResponseDTO("Cannot add ad");
		
		
		
		
		return new MessageResponseDTO("Successfully added ad");
	}
	
	@PostMapping("/editProduct")
    public MessageResponseDTO editProduct(@RequestBody ProductDTO productDTO){
		// treba samo ispraviti da prilikom editovanja ne dozvolimo da se id inkrementuje i sacuva  rekvizit kao sasvim novi
		Product p=new Product();
		
		
		if ((productService.checkUniqueProduct(productDTO.getId()))) {
			return new MessageResponseDTO("You cannot edit non-existing product");
		}
		
		
		p.setName(productDTO.getName());
		p.setDescription(productDTO.getDescription());
		p.setImage(productDTO.getImage());
		p.setBoxoffice(productDTO.getBoxoffice());
		
		Product temp=productService.saveProduct(p);
		

		if (temp == null) 
			return new MessageResponseDTO("Cannot edit product");
		
		
		
		return new MessageResponseDTO("Successfully edited product");
	}
	
	@PostMapping("/editAd")
    public MessageResponseDTO editAd(@RequestBody AdDTO adDTO){
		
		Ad a=new Ad();
		
		
		if ((adService.checkUniqueAd(adDTO.getId()))) {
			return new MessageResponseDTO("You cannot edit non-existing ad");
		}
		
		
		a.setName(adDTO.getName());
		a.setDescription(adDTO.getDescription());
		a.setImage(adDTO.getImage());
		a.setDate(adDTO.getDate());
		
		Ad temp=adService.saveAd(a);
		

		if (temp == null) 
			return new MessageResponseDTO("Cannot edit ad");
		
		
		
		
		return new MessageResponseDTO("Successfully edited ad");
	}
	
	
	@DeleteMapping("/deleteProducts/{id}")
	public MessageResponseDTO deleteProducts(@PathVariable("id")Long id){
		
		
		productService.deleteProduct(id);
		
	
		return new MessageResponseDTO("Successfully deleted product");
	}
	
	@DeleteMapping("/deleteAds/{id}")
	public MessageResponseDTO deleteAds(@PathVariable("id")Long id){
		
		
		adService.deleteAd(id);
		
	
		return new MessageResponseDTO("Successfully deleted ad");
	}
	
	
	
	
}
