package com.ISA.ISA_Project.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class CinemaHall implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	
	
	private String name;
	
	
	
	@ManyToOne
	@JoinColumn(name = "cinema_id")
	private Cinema cinema;
	
	
	
	
	@OneToMany(mappedBy = "hall")
	private Set<CinemaSeat> seats;




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




	public Cinema getCinema() {
		return cinema;
	}




	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}




	public Set<CinemaSeat> getSeats() {
		return seats;
	}




	public void setSeats(Set<CinemaSeat> seats) {
		this.seats = seats;
	}
	
	
	
	
	
}
