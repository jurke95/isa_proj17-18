package com.ISA.ISA_Project.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"ad_id" , "user_id"})})
public class Offer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Long bid;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "ad_id")
	private Ad ad;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User bidder;

	public Offer() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public User getBidder() {
		return bidder;
	}

	public void setBidder(User bidder) {
		this.bidder = bidder;
	}

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

}
