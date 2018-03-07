package com.ISA.ISA_Project.service;

import com.ISA.ISA_Project.domain.User;
import com.ISA.ISA_Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User registrateUser(User user) {
		user.setRole("USER");
		user.setActive(false);
		user = userRepository.save(user);
		return user;
	}

	public boolean checkUniqueEmail(String email) {
		if (userRepository.findOneByEmail(email) != null) {
			return false;
		}
		return true;
	}

}
