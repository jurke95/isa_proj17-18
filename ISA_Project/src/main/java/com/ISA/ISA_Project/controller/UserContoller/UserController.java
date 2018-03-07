package com.ISA.ISA_Project.controller.UserContoller;

import com.ISA.ISA_Project.controller.UserContoller.dto.LoginDTO;
import com.ISA.ISA_Project.controller.UserContoller.dto.RegistrationDTO;
import com.ISA.ISA_Project.controller.dto.MessageResponseDTO;
import com.ISA.ISA_Project.domain.User;
import com.ISA.ISA_Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


//    @RequestMapping(value ="/registration",method= RequestMethod.POST)
    @PostMapping("/registration")
    public MessageResponseDTO registration(@RequestBody RegistrationDTO registrationDTO){

        User user = new User();
 
        user.setEmail(registrationDTO.getEmail());
        if(registrationDTO.getPassword1().equals((registrationDTO.getPassword2())))
        	user.setPassword(registrationDTO.getPassword1());
        else return new MessageResponseDTO("password1 and password2 are not equal");
        user.setName(registrationDTO.getName());
        user.setSurname(registrationDTO.getSurname());
        user.setCity(registrationDTO.getCity());
        user.setPhoneNumber(registrationDTO.getPhoneNumber());
        if(!(userService.checkUniqueEmail(registrationDTO.getEmail()))) {
        	return new MessageResponseDTO("This email already exists");
        }
        User temp = userService.registrateUser(user);

        if(temp == null){
            return new MessageResponseDTO("User is not registrated");
        }

        return new MessageResponseDTO("User is registrated");
    }
    
    @PostMapping("/login")
    public MessageResponseDTO login(@RequestBody LoginDTO loginDTO){
    	User temp = userService.findOneUserByEmail(loginDTO.getEmail());
    	
    	if(temp == null)
    		return new MessageResponseDTO("Invalid email address");
    	if(!(temp.getPassword().equals(loginDTO.getPassword())))
    		return new MessageResponseDTO("Invalid password");
    	if(!(temp.isActive()))
    		return new MessageResponseDTO("User is not active");
    	
    	
    	return new MessageResponseDTO("Login success");
    }
}
