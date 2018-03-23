package com.ISA.ISA_Project.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;





@Entity
@IdClass(CinemaSeat.class)
public class CinemaSeat implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "theatrehall_id"),
		@JoinColumn(name = "theatre_id")})
	private CinemaHall hall;
	
	private int row;
	
	private int seatNumber;
	
	@Enumerated(EnumType.STRING)
	private HallSegment segment;
	
	
	private boolean isfree;

	public CinemaHall getHall() {
		return hall;
	}

	public void setHall(CinemaHall hall) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	
	
	
	
	
}
