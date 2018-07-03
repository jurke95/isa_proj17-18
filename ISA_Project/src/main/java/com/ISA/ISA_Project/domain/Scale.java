package com.ISA.ISA_Project.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Scale {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	
	private String name;
	
	
	private int gold;
	

	private int silver;
	
	private int bronze;
	
	@OneToMany
	private Set<User> user = new HashSet();
	
	
	
	
	public Scale(){
		
		
	}




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




	public int getGold() {
		return gold;
	}




	public void setGold(int gold) {
		this.gold = gold;
	}




	public int getSilver() {
		return silver;
	}




	public void setSilver(int silver) {
		this.silver = silver;
	}




	public int getBronze() {
		return bronze;
	}




	public void setBronze(int bronze) {
		this.bronze = bronze;
	}




	public Set<User> getUser() {
		return user;
	}




	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
