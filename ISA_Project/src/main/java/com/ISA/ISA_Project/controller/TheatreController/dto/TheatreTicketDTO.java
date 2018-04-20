package com.ISA.ISA_Project.controller.TheatreController.dto;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TheatreTicketDTO {
private Long Id;
	
	private String usermail;
	
	
	private String theatrename;
	
	private String projectionname;
	
	@JsonFormat(pattern="KK:mm")
	private Time reservationtime;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone="UTC+1")
	private Date reservationdate;
	
	
	private String ticketprice;
	
	private String theatrerow;
	
	private String theatrecolumn;

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

	

	public String getTheatrename() {
		return theatrename;
	}

	public void setTheatrename(String theatrename) {
		this.theatrename = theatrename;
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

	public String getTheatrerow() {
		return theatrerow;
	}

	public void setTheatrerow(String theatrerow) {
		this.theatrerow = theatrerow;
	}

	public String getTheatrecolumn() {
		return theatrecolumn;
	}

	public void setTheatrecolumn(String theatrecolumn) {
		this.theatrecolumn = theatrecolumn;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
