package com.ISA.ISA_Project.response;

import java.util.List;

import com.ISA.ISA_Project.domain.Ad;

public class AdResponse {

	
	private List<Ad> ads;
	
	
	public AdResponse(List<Ad>listAds){
		
		
		this.ads=listAds;
	}


	public List<Ad> getAds() {
		return ads;
	}


	public void setProducts(List<Ad> adss) {
		this.ads = adss;
	}
	
	
	
	
	
}
