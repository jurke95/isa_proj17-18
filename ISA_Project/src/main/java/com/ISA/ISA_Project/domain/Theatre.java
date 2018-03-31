package com.ISA.ISA_Project.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Theatre implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String location;
	//private List<Projection>repertoar;
	private String promOpis;
	/*
	@OneToMany
	@JoinColumn(name = "theatreprojection_id")
	private Set<TheatreProjection> repertoar;
	
	@OneToMany(mappedBy = "theatre")
	private Set<TheatreHall> halls;
	
	*/
	public Theatre(){
		
		
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
	public Set<TheatreProjection> getRepertoar() {
		return repertoar;
	}

	public void setRepertoar(Set<TheatreProjection> repertoar) {
		this.repertoar = repertoar;
	}

	public Set<TheatreHall> getHalls() {
		return halls;
	}

	public void setHalls(Set<TheatreHall> halls) {
		this.halls = halls;
	}
	*/
	
}
