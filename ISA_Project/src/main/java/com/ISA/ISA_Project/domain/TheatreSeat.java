package com.ISA.ISA_Project.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TheatreSeat {

	
	
	@ManyToOne
	@JoinColumn(name = "theatrehall_id")
	private TheatreHall hall;
	
	private int row;
	
	private int seatNumber;
	
	@Enumerated(EnumType.STRING)
	private HallSegment segment;
	
	
	private boolean isfree;


	public TheatreHall getHall() {
		return hall;
	}


	public void setHall(TheatreHall hall) {
		this.hall = hall;
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getSeatNumber() {
		return seatNumber;
	}


	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}


	public HallSegment getSegment() {
		return segment;
	}


	public void setSegment(HallSegment segment) {
		this.segment = segment;
	}


	public boolean isIsfree() {
		return isfree;
	}


	public void setIsfree(boolean isfree) {
		this.isfree = isfree;
	}
	
	
	
	
	
	
	
}
