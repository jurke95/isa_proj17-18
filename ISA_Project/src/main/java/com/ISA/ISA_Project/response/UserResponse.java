package com.ISA.ISA_Project.response;

import java.util.List;

import com.ISA.ISA_Project.domain.User;

public class UserResponse {

private List<User>users;
	
	
	
	public UserResponse(List<User>users){
		
		this.users=users;
	}



	public List<User> getUsers() {
		return users;
	}



	public void setCin(List<User> users) {
		this.users = users;
	}
}
