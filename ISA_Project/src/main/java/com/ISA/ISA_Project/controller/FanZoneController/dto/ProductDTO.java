package com.ISA.ISA_Project.controller.FanZoneController.dto;

public class ProductDTO {

	
	private Long id;
	private String name;
	private String description;
	private String image;
	private String boxoffice;
	private Long iduser;
	
	
	public ProductDTO(){
		
		
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getBoxoffice() {
		return boxoffice;
	}


	public void setBoxoffice(String boxoffice) {
		this.boxoffice = boxoffice;
	}


	public Long getIduser() {
		return iduser;
	}


	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}
	
	
	
	
}
