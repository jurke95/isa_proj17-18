package com.ISA.ISA_Project.domain;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ReservationCinemaTicket {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String usermail;
	
	
	private String cinemaname;
	
	private String projectionname;
	
	@JsonFormat(pattern="KK:mm")
	private Time reservationtime;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone="UTC+1")
	private Date reservationdate;
	
	
	private String ticketprice;

    private String seatrow;
	
	private String  seatcolumn;
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getSeatrow() {
		return seatrow;
	}


	public void setSeatrow(String seatrow) {
		this.seatrow = seatrow;
	}


	public String getSeatcolumn() {
		return seatcolumn;
	}


	public void setSeatcolumn(String seatcolumn) {
		this.seatcolumn = seatcolumn;
	}


	

	
	
	
	
	
	
	
	
	
}
