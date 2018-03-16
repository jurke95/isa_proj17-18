package com.ISA.ISA_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.Ad;
import com.ISA.ISA_Project.domain.Product;
import com.ISA.ISA_Project.domain.User;
import com.ISA.ISA_Project.repository.AdRepository;
import com.ISA.ISA_Project.repository.ProductRepository;

@Service
public class AdService {

	
	@Autowired
	private AdRepository adRepository;
	
	
	
	public List<Ad>getAllItems(){
		
		return adRepository.findAll();
	}
	
	
	
	public Ad getAd(Long id){
		
		return adRepository.findOneById(id);
		
	}
	
	public boolean checkUniqueAd(Long id) {
		if (adRepository.findOneById(id) != null) {
			return false;
		}
		return true;
	}
	
	public Ad saveAd(Ad ad) {
    	adRepository.save(ad);
    	return ad;
    }
	
	public void deleteAd(Long id){
		
		adRepository.delete(adRepository.findOneById(id));
	}
	
}