package com.ISA.ISA_Project.response;

import java.util.List;

import com.ISA.ISA_Project.domain.Cinema;

public class CinemaResponse {

	private List<Cinema>cin;
	
	
	
	public CinemaResponse(List<Cinema>cinemas){
		
		this.cin=cinemas;
	}



	public List<Cinema> getCin() {
		return cin;
	}



	public void setCin(List<Cinema> cin) {
		this.cin = cin;
	}
	
	
	
	
	
	
	
}
