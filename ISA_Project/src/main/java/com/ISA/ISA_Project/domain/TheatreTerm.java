package com.ISA.ISA_Project.domain;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TheatreTerm implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="theatrehall_id")
	private TheatreHall theatreHall;
	
	private Long price;
	private Time time;
	
	public TheatreTerm() {
		
	}

	public TheatreHall getTheatreHall() {
		return theatreHall;
	}

	public void setTheatreHall(TheatreHall theatreHall) {
		this.theatreHall = theatreHall;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	
}
