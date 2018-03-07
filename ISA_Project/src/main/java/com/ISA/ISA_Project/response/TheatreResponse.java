package com.ISA.ISA_Project.response;

import java.util.List;

import com.ISA.ISA_Project.theatre.Theatre;

public class TheatreResponse {
	
	
	private List<Theatre>th;
	

	
	public TheatreResponse(List<Theatre>theatres){
		
		this.th=theatres;
	}



	public List<Theatre> getTh() {
		return th;
	}



	public void setTh(List<Theatre> th) {
		this.th = th;
	}
	
	
}
