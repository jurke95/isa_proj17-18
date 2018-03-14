package com.ISA.ISA_Project.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String email;
    private String role;
    private String password;
    private String name;
    private String surname;
    private String city;
    private String phoneNumber;   
    private boolean active;
    private String confirmationToken;

    public User(){
    
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}
    
	
    
}
