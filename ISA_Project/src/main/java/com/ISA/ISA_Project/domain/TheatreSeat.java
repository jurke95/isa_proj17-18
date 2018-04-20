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

public class TheatreSeat implements Serializable  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "theatrehall")
		
	private TheatreHall theatrehall;
	
	private int row;
	
	private int seatnumber;
	
	@Enumerated(EnumType.STRING)
	private HallSegment segment;
	
	
	private boolean isfree;


	


	public TheatreHall getTheatrehall() {
		return theatrehall;
	}


	public void setTheatrehall(TheatreHall theatrehall) {
		this.theatrehall = theatrehall;
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	


	public int getSeatnumber() {
		return seatnumber;
	}


	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
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
