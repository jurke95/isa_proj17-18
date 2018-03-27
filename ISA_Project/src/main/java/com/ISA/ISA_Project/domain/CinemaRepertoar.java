package com.ISA.ISA_Project.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class CinemaRepertoar implements Serializable {

	@Id
	private Long id;
	
	
	
	@OneToOne
	@JoinColumn(name="cinema_id")
	private Cinema cinema;
	
	@OneToMany(mappedBy = "crepertoar")
	private Set<CinemaProjection> projections;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	 @JsonIgnore
	public Set<CinemaProjection> getProjections() {
		return projections;
	}

	public void setProjections(Set<CinemaProjection> projections) {
		this.projections = projections;
	}

	
	
}
