package com.ISA.ISA_Project.controller.TheatreController.dto;

import java.util.List;

import com.ISA.ISA_Project.domain.Projection;

public class TheatreDTO {

	
	private Long id;
	private String name;
	private String location;
	private List<Projection>repertoar;
	private String promOpis;

	public TheatreDTO(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Projection> getRepertoar() {
		return repertoar;
	}

	public void setRepertoar(List<Projection> repertoar) {
		this.repertoar = repertoar;
	}

	public String getPromOpis() {
		return promOpis;
	}

	public void setPromOpis(String promOpis) {
		this.promOpis = promOpis;
	}
	
	
	
	
	
	
}
