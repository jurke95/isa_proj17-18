package com.ISA.ISA_Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ISA.ISA_Project.controller.dto.MessageResponseDTO;
import com.ISA.ISA_Project.domain.Cinema;
import com.ISA.ISA_Project.repository.CinemaRepository;
import com.ISA.ISA_Project.service.CinemaService;
import com.ISA.ISA_Project.response.CinemaResponse;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

	
	@Autowired
	private CinemaRepository cinemaRepository;

    @Autowired 
    private CinemaService cinemaService;
	
	@GetMapping("/getCinemas")
	public CinemaResponse getCinemas(){
		
		List<Cinema>listc=cinemaService.getAllCinemas();
		return new CinemaResponse(listc);
		
	}
	
	
	@GetMapping("getCinemas/{id}")
	public Cinema getCinema(@PathVariable("id")Long id){
		
		Cinema cinema=cinemaService.getCinema(id);
		return cinema;
		
		
		
	}
	
	
	
	@PostMapping("/registration")
	public MessageResponseDTO registrationCin(@RequestBody CinemaDTO cinemaDTO){
		Cinema c=new Cinema();
		c.setId(cinemaDTO.getId());
		c.setName(cinemaDTO.getName());
		c.setLocation(cinemaDTO.getLocation());
		
		if(cinemaService.checkUniqueId(c.getId()) ==false){
			
			return new MessageResponseDTO("There is already Cinema with the same ID");
			
		}
		if(cinemaService.checkUniqueName(c.getName())==false){
			
			return new MessageResponseDTO("There is alrady Cinema with that name");
		}
		
		Cinema temp=cinemaService.registrateCinema(c);
		
		if(temp==null){
			
			return new MessageResponseDTO("Cannot registrate Cinema");
		}
		
		return new MessageResponseDTO("Successfully registered Cinema");
		
	}
	
	
	
	
}
