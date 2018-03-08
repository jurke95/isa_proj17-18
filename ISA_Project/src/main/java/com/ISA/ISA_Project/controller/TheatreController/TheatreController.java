package com.ISA.ISA_Project.controller.TheatreController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ISA.ISA_Project.controller.dto.MessageResponseDTO;
import com.ISA.ISA_Project.domain.Cinema;
import com.ISA.ISA_Project.repository.TheatreRepository;
import com.ISA.ISA_Project.response.CinemaResponse;
import com.ISA.ISA_Project.response.TheatreResponse;
import com.ISA.ISA_Project.service.TheatreService;
import com.ISA.ISA_Project.theatre.Theatre;

@RestController
@RequestMapping("/theatres")

public class TheatreController {

	
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	@Autowired 
	private TheatreService theatreService;
	
	
	@GetMapping("/getTheatres")
	public TheatreResponse getTheatres(){
		
		List<Theatre>listt=theatreService.getAllTheatres();
		
		
		return new TheatreResponse(listt);
		
	}
	
	@PostMapping("/registration")
	public MessageResponseDTO registrationThe(@RequestBody TheatreDTO theatreDTO){
		
		Theatre t=new Theatre();
		t.setId(theatreDTO.getId());
		t.setName(theatreDTO.getName());
		t.setLocation(theatreDTO.getLocation());
		
		if(theatreService.checkUniqueId(t.getId()) ==false){
			
			return new MessageResponseDTO("There is already Theatre with the same ID");
			
		}
		if(theatreService.checkUniqueName(t.getName())==false){
			
			return new MessageResponseDTO("There is alrady Theatre with that name");
		}
		
		Theatre temp=theatreService.registrateTheatre(t);
		
		if(temp==null){
			
			return new MessageResponseDTO("Cannot registrate Theatre");
		}
		
		return new MessageResponseDTO("Successfully registered Theatre");
		
		
	}
	
	
	
}
