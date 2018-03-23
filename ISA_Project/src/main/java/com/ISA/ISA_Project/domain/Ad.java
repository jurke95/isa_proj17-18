package com.ISA.ISA_Project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ad implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	private String description;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date date;

	private String image;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User adMaker;

	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "bidder_ad", joinColumns = @JoinColumn(name = "ad_id",
	 * referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name =
	 * "user_id", referencedColumnName = "id")) private Set<User> bidders;
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getAdMaker() {
		return adMaker;
	}

	public void setAdMaker(User adMaker) {
		this.adMaker = adMaker;
	}

}
