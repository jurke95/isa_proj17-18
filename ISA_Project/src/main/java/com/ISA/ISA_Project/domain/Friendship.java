package com.ISA.ISA_Project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Friendship {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	private User firstfriend;
	
	
	@ManyToOne
	private User secondfriend;
	
	@Column(name="status")
	private String status;
	//pending 
	//accepted
	//declined
	
	public Friendship(){
		
	}
	

	public Friendship(Long id, User firstfriend, User secondfriend, String status) {
		super();
		this.id = id;
		this.firstfriend = firstfriend;
		this.secondfriend = secondfriend;
		this.status = status;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getFirstfriend() {
		return firstfriend;
	}

	public void setFirstfriend(User firstfriend) {
		this.firstfriend = firstfriend;
	}

	public User getSecondfriend() {
		return secondfriend;
	}

	public void setSecondfriend(User secondfriend) {
		this.secondfriend = secondfriend;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	
	

}
