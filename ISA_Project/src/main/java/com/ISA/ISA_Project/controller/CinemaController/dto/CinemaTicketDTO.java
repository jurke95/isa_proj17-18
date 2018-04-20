package com.ISA.ISA_Project.controller.CinemaController.dto;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CinemaTicketDTO {

	
	
private Long Id;
	
	private String usermail;
	
	
	private String cinemaname;
	
	private String projectionname;
	
	@JsonFormat(pattern="KK:mm")
	private Time reservationtime;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone="UTC+1")
	private Date reservationdate;
	
	
	private String ticketprice;
	
	private String cinemarow;
	
	private String cinemacolumn;
	


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getUsermail() {
		return usermail;
	}


	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}


	public String getCinemaname() {
		return cinemaname;
	}


	public void setCinemaname(String cinemaname) {
		this.cinemaname = cinemaname;
	}


	public String getProjectionname() {
		return projectionname;
	}


	public void setProjectionname(String projectionname) {
		this.projectionname = projectionname;
	}


	public Time getReservationtime() {
		return reservationtime;
	}


	public void setReservationtime(Time reservationtime) {
		this.reservationtime = reservationtime;
	}


	public Date getReservationdate() {
		return reservationdate;
	}


	public void setReservationdate(Date reservationdate) {
		this.reservationdate = reservationdate;
	}


	public String getTicketprice() {
		return ticketprice;
	}


	public void setTicketprice(String ticketprice) {
		this.ticketprice = ticketprice;
	}


	public String getCinemarow() {
		return cinemarow;
	}


	public void setCinemarow(String cinemarow) {
		this.cinemarow = cinemarow;
	}


	public String getCinemacolumn() {
		return cinemacolumn;
	}


	public void setCinemacolumn(String cinemacolumn) {
		this.cinemacolumn = cinemacolumn;
	}




	


	
	
	
	
	
	
	
	
}
