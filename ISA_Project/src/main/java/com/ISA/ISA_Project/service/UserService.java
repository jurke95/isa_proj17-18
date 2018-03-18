package com.ISA.ISA_Project.service;

import com.ISA.ISA_Project.controller.EmailController.EmailController;
import com.ISA.ISA_Project.domain.User;
import com.ISA.ISA_Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.UUID;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmailController emailController;
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private JavaMailSender sender;

	public User registrateUser(User user) {
		user.setRole("USER");
		user.setActive(false);
		user.setConfirmationToken(UUID.randomUUID().toString());
		user = userRepository.save(user);
		String appUrl = "http://localhost:8084";//request.getScheme() + "://" + request.getServerName();
		SimpleMailMessage registrationEmail=new SimpleMailMessage();
		registrationEmail.setTo(user.getEmail());
		registrationEmail.setSubject("Registration Confirmation");
		registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
		+appUrl+"/user/confirm?token="+ user.getConfirmationToken());
		emailService.sendEmail(registrationEmail);
		
		
		
		
		return user;
	}

	public boolean checkUniqueEmail(String email) {
		if (userRepository.findOneByEmail(email) != null) {
			return false;
		}
		return true;
	}
	
	public User findOneUserByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

    public User findByConfirmationToken(String confirmationToken){
    	
    	return userRepository.findByConfirmationToken(confirmationToken);
    }
    
    public void saveUser(User user) {
    	userRepository.save(user);
    }
    
    
    public User findOneUserById(Long id) {
		return userRepository.findOneById(id);
	}

    
    
    
    
    
    
    
    
    
    
    
}
