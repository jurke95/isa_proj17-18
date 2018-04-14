package com.ISA.ISA_Project.controller.FanZoneController.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AdDTO {

	private Long id;
	private String name;
	private String description;
	@DateTimeFormat(pattern = " YYYY-MM-DD")
	private Date date;
	private String image;
	
	
	public AdDTO(){
		
		
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
