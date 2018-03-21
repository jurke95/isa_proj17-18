package com.ISA.ISA_Project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.controller.EmailController.EmailController;
import com.ISA.ISA_Project.domain.Ad;
import com.ISA.ISA_Project.domain.Offer;
import com.ISA.ISA_Project.domain.User;
import com.ISA.ISA_Project.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmailController emailController;
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private OfferService offerService;
	
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
	
	public void aceptTheOffer(User user ,User winner,Ad ad) {
		List<Offer> listOffers = offerService.getAllOffersByAd(ad); 
		List<User> listUsers = new ArrayList<User>();

		for(Offer temp : listOffers) {
			listUsers.add(temp.getBidder()); //punimo listu sa userima koji su dali ponudu bas na ovaj oglas
		}
		
		for (User temp: listUsers) {
		    if (temp==winner) {
		    	SimpleMailMessage registrationEmail=new SimpleMailMessage();
				registrationEmail.setTo(temp.getEmail());
				registrationEmail.setSubject("Auction for "+ad.getName());
				registrationEmail.setText("Your bid for the "+ ad.getName() + "has been accepted by "+ user.getName()+"\n"
						+"Contact seller: "+user.getName()+" "+user.getSurname()+" "+"Email: "+user.getEmail()+" Phone: "+ user.getPhoneNumber());
				emailService.sendEmail(registrationEmail);
		    }
		    else {
		    	SimpleMailMessage registrationEmail=new SimpleMailMessage();
				registrationEmail.setTo(temp.getEmail());
				registrationEmail.setSubject("Auction for "+ad.getName());
				registrationEmail.setText("Your bid for the "+ ad.getName() + " is not accepted. ");
				emailService.sendEmail(registrationEmail);
		    }
		}
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

    public List<User> findAllUsers() {
		return userRepository.findAll();
	}
    
    
    
    
    
    
    
    
    
    
}
