package com.ISA.ISA_Project.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cinema implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String location;
	
	private String promOpis;
/*
	@OneToOne(mappedBy = "cinema")
	private CinemaRepertoar repertoar;
	
	*/

	public Cinema(){
		
		
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

	

	public String getPromOpis() {
		return promOpis;
	}

	public void setPromOpis(String promOpis) {
		this.promOpis = promOpis;
	}
	/*
  @JsonIgnore
	public CinemaRepertoar getRepertoar() {
		return repertoar;
	}

	public void setRepertoar(CinemaRepertoar repertoar) {
		this.repertoar = repertoar;
	}

	
	*/
	
	
	
}
