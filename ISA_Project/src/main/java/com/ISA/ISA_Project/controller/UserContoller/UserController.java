package com.ISA.ISA_Project.controller.UserContoller;

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
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(registrationDTO.getPassword());
        user.setEmail(registrationDTO.getEmail());
        User temp = userService.registrateUser(user);

        if(temp == null){
            return new MessageResponseDTO("korisnik nije registrovan");
        }

        return new MessageResponseDTO("korisnik je kreiran");
    }
}
