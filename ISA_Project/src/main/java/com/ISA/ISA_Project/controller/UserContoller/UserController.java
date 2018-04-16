package com.ISA.ISA_Project.controller.UserContoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ISA.ISA_Project.controller.UserContoller.dto.LoginDTO;
import com.ISA.ISA_Project.controller.UserContoller.dto.RegistrationDTO;
import com.ISA.ISA_Project.controller.dto.MessageResponseDTO;
import com.ISA.ISA_Project.domain.User;
import com.ISA.ISA_Project.response.UserResponse;
import com.ISA.ISA_Project.service.UserService;
import com.fasterxml.jackson.annotation.JsonValue;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class UserController {

	@Autowired
	private UserService userService;
	
	private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	

	// @RequestMapping(value ="/registration",method= RequestMethod.POST)
	
	
	
	/**
	 * POST /registration : Registrate user
	 *
	 * @param registrationDTO
	 *            object providing information required for registration
	 * @return
	 */
	
	@GetMapping("/deleteActiveUser")
    public  MessageResponseDTO deleteActiveUser(){
        System.out.println("usao");
        UserService.activeUser = null;
        return new MessageResponseDTO("There is no active users!");
    }
	
	
	@PostMapping("/setActiveUser/{userId}")
    public  MessageResponseDTO setActiveUser(@PathVariable Long userId){
        User activeUser = userService.findOneUserById(userId);
        UserService.activeUser = activeUser;
        return new MessageResponseDTO("User is now active!");
    }

    @GetMapping("/getActiveUser")
    public User getActiveUser(){
    	User activeUser = UserService.activeUser;
        return activeUser;
    }
	
	@PostMapping("/registration")
	public MessageResponseDTO registration(@RequestBody RegistrationDTO registrationDTO) {
		System.out.println("pozvan");
		
		User user = new User();
       
		if (!(userService.checkUniqueEmail(registrationDTO.getEmail()))) {
			return new MessageResponseDTO("This email already exists");
		}
		user.setEmail(registrationDTO.getEmail());
		if (registrationDTO.getPassword1().equals((registrationDTO.getPassword2())))
			user.setPassword(registrationDTO.getPassword1());
		else
			return new MessageResponseDTO("password1 and password2 are not equal");
		user.setName(registrationDTO.getName());
		user.setSurname(registrationDTO.getSurname());
		user.setCity(registrationDTO.getCity());
		user.setPhonenumber(registrationDTO.getPhonenumber());
		System.out.println(registrationDTO.getPhonenumber());

		User temp = userService.registrateUser(user);

		if (temp == null) {
			return new MessageResponseDTO("User is not registrated");
		}

		return new MessageResponseDTO("User is registrated");
	}

	@PostMapping("/login")
	public MessageResponseDTO login(@RequestBody LoginDTO loginDTO) {
		User temp = userService.findOneUserByEmail(loginDTO.getEmail());

		if (temp == null)
			return new MessageResponseDTO("Invalid email address");
		if (!(temp.getPassword().equals(loginDTO.getPassword())))
			return new MessageResponseDTO("Invalid password");
		if (!(temp.isActive()))
			return new MessageResponseDTO("User is not active");
		
		UserService.activeUser = temp;

		return new MessageResponseDTO("Login success");
	}

	@PostMapping("/edituser")
	public MessageResponseDTO edituser(@RequestBody RegistrationDTO registrationDTO) {
		System.out.println("pozvan edit");
		Boolean changeEmail=false;
		User user = new User();
		// user= getsesion....
	    if(!(registrationDTO.getEmail().equals(userService.activeUser.getEmail()))){
		if (!(userService.checkUniqueEmail(registrationDTO.getEmail()))) {
			return new MessageResponseDTO("This email already exists");
		} else {
			 userService.activeUser.setEmail(registrationDTO.getEmail()); // Must make a activate link for email
			changeEmail=true;
		}}
	    if(userService.activeUser.getRole()!="USER") {
		if (registrationDTO.getPassword1().equals((registrationDTO.getPassword2())))
			 userService.activeUser.setPassword(registrationDTO.getPassword1());
		else
			return new MessageResponseDTO("password1 and password2 are not equal");
	    }
	    userService.activeUser.setName(registrationDTO.getName());
	    userService.activeUser.setSurname(registrationDTO.getSurname());
	    userService.activeUser.setCity(registrationDTO.getCity());
	    userService.activeUser.setPhonenumber(registrationDTO.getPhonenumber());

		// if Activation on the email is accepted
		
		if(changeEmail) {
		User temp = userService.registrateUser(userService.activeUser);

		if (temp == null) {
			return new MessageResponseDTO("User is edited with a new email");
		}}
		userService.saveUser(userService.activeUser);
		return new MessageResponseDTO("User is edited");
	}
	@PostMapping("/confirm")
	public MessageResponseDTO emailConfirm(@RequestParam("token") String token) {
		
		User user = userService.findByConfirmationToken(token);
		
		if(user==null) {
			return new MessageResponseDTO("Oops! This token is invalid!");
		}
		user.setActive(true);
		userService.saveUser(user);
	return new MessageResponseDTO("User is activated");
	}
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable("id")Long id){
		System.out.println("pozvan get user");
		User user=userService.findOneUserById(id);
		return user;		
	}
	
	@JsonValue
	@GetMapping("/getUsers")
	public UserResponse getUsers(){
		List<User>listUsers=userService.findAllUsers();
		return new UserResponse(listUsers);	
	}
}
