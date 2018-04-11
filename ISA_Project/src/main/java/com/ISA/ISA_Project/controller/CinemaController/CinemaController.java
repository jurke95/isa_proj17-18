package com.ISA.ISA_Project.controller.CinemaController;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ISA.ISA_Project.controller.CinemaController.dto.CinemaDTO;
import com.ISA.ISA_Project.controller.dto.MessageResponseDTO;
import com.ISA.ISA_Project.domain.Cinema;
import com.ISA.ISA_Project.domain.CinemaProjection;
import com.ISA.ISA_Project.repository.CinemaRepository;
import com.ISA.ISA_Project.response.CinemaRepertoarResponse;
import com.ISA.ISA_Project.response.CinemaResponse;
import com.ISA.ISA_Project.service.CinemaProjectionService;
import com.ISA.ISA_Project.service.CinemaService;
import com.fasterxml.jackson.annotation.JsonValue;

@RestController
@RequestMapping("/cinemas")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class CinemaController {

	
	@Autowired
	private CinemaRepository cinemaRepository;

    @Autowired 
    private CinemaService cinemaService;
    
    @Autowired 
    private CinemaProjectionService cinemaProjectionService;
    
    @JsonValue
	@GetMapping("/getCinemas")
	public CinemaResponse getCinemas(){
		
		List<Cinema>listc=cinemaService.getAllCinemas();
		return new CinemaResponse(listc);
		
	}
	
	
	@GetMapping("getCinemas/{id}")
	@JsonValue
	public Cinema getCinema(@PathVariable("id")Long id){
		
		Cinema cinema=cinemaService.getCinema(id);
		return cinema;
		
		
		
	}
	
	
	
	@PostMapping("/registration")
	@JsonValue
	public MessageResponseDTO registrationCin(@RequestBody CinemaDTO cinemaDTO){
		System.out.println("usao u post");
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
	
	@PostMapping("/editCinema/{id}")
	public MessageResponseDTO editCinema(@RequestBody CinemaDTO cinemaDTO,@PathVariable("id")Long id){
		
		cinemaService.CinemaEdit(cinemaDTO, id);
		
		
		return new MessageResponseDTO("Cinema edited");
	}
	
	@DeleteMapping("/deleteCinema/{id}")
	public MessageResponseDTO deleteCinema(@PathVariable("id")Long id){
		

		cinemaService.CinemaDelete(id);

		return new MessageResponseDTO("Cinema deleted");
	}
	
	
	@GetMapping("repertoar/{id}")
	public CinemaRepertoarResponse getRepertoar(@PathVariable("id")Long id){
		System.out.println("dosaooo  "+id);
		Set<CinemaProjection> r=cinemaProjectionService.getAllByRepertoar(id);
		return new CinemaRepertoarResponse(r);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
