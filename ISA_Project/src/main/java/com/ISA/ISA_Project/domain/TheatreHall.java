package com.ISA.ISA_Project.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TheatreHall {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	
	
	private String name;
	
	
	
	@ManyToOne
	@JoinColumn(name = "theatre_id")
	private Theatre theatre;
	
	
	
	
	@OneToMany(mappedBy = "theatrehall")
	private Set<TheatreSeat> seats;




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




	public Theatre getTheatre() {
		return theatre;
	}




	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}




	public Set<TheatreSeat> getSeats() {
		return seats;
	}




	public void setSeats(Set<TheatreSeat> seats) {
		this.seats = seats;
	}


	
	
}
