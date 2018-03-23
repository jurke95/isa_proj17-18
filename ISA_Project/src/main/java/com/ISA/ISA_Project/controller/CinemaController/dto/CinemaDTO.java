package com.ISA.ISA_Project.controller.CinemaController.dto;

public class CinemaDTO {

	
	private Long id;
	private String name;
	private String location;
	//private List<Projection>repertoar;
	private String promOpis;
	
	public CinemaDTO(){
		
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

	/*public List<Projection> getRepertoar() {
		return repertoar;
	}

	public void setRepertoar(List<Projection> repertoar) {
		this.repertoar = repertoar;
	}*/

	public String getPromOpis() {
		return promOpis;
	}

	public void setPromOpis(String promOpis) {
		this.promOpis = promOpis;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
