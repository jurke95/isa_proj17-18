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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CinemaTerm implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cinemahall")
	private CinemaHall cinemahall;

	private Long price;
	
	@JsonFormat(pattern="KK:mm")
	private Time time;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="cprojection")
	private CinemaProjection cprojection;

	public CinemaTerm() {
		
	}

	
	


  @JsonIgnore
	public CinemaHall getCinemahall() {
		return cinemahall;
	}






	public void setCinemahall(CinemaHall cinemahall) {
		this.cinemahall = cinemahall;
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
	public CinemaProjection getCprojection() {
		return cprojection;
	}



	public void setCprojection(CinemaProjection cprojection) {
		this.cprojection = cprojection;
	}


	  
	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
}
