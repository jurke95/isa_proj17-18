package com.ISA.ISA_Project.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TheatreTerm implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="theatrehall")
	private TheatreHall theatrehall;
	
	private Long price;
	@JsonFormat(pattern="KK:mm")
	private Time time;
	
	@ManyToOne
	@JoinColumn(name="tprojection")
	private TheatreProjection tprojection;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;
	
	public TheatreTerm() {
		
	}

	 @JsonIgnore
	public TheatreHall getTheatrehall() {
		return theatrehall;
	}



	public void setTheatrehall(TheatreHall theatrehall) {
		this.theatrehall = theatrehall;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonIgnore
	public TheatreProjection getTprojection() {
		return tprojection;
	}

	public void setTprojection(TheatreProjection tprojection) {
		this.tprojection = tprojection;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
}
