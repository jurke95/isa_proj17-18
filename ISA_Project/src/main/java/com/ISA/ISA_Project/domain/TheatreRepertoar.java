package com.ISA.ISA_Project.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class TheatreRepertoar implements Serializable {

	
	
	@Id
	private Long id;
	
	
	
	@OneToOne
	@JoinColumn(name="theatre_id")
	private Theatre theatre;
	
	@OneToMany(mappedBy = "trepertoar")
	private Set<TheatreProjection> projections;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Set<TheatreProjection> getProjections() {
		return projections;
	}

	public void setProjections(Set<TheatreProjection> projections) {
		this.projections = projections;
	}
	
	
	
	
	
	
	
}
