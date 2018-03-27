package com.ISA.ISA_Project.response;

import java.util.Set;


import com.ISA.ISA_Project.domain.CinemaProjection;
public class CinemaRepertoarResponse {

	private Set<CinemaProjection>repertoar;
	
     public CinemaRepertoarResponse(Set<CinemaProjection>rep){
		
		this.repertoar=rep;
	}

	public Set<CinemaProjection> getRepertoar() {
		return repertoar;
	}

	public void setRepertoar(Set<CinemaProjection> repertoar) {
		this.repertoar = repertoar;
	}

	
}
