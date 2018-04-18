package com.ISA.ISA_Project.controller.TheatreController;

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

import com.ISA.ISA_Project.controller.TheatreController.dto.TheatreDTO;
import com.ISA.ISA_Project.controller.dto.MessageResponseDTO;
import com.ISA.ISA_Project.domain.CinemaProjection;
import com.ISA.ISA_Project.domain.CinemaRepertoar;
import com.ISA.ISA_Project.domain.Theatre;
import com.ISA.ISA_Project.domain.TheatreProjection;
import com.ISA.ISA_Project.domain.TheatreRepertoar;
import com.ISA.ISA_Project.domain.User;
import com.ISA.ISA_Project.repository.TheatreRepository;
import com.ISA.ISA_Project.response.TheatreResponse;
import com.ISA.ISA_Project.service.TheatreProjectionService;
import com.ISA.ISA_Project.service.TheatreRepertoarService;
import com.ISA.ISA_Project.service.TheatreService;
import com.ISA.ISA_Project.service.UserService;
import com.fasterxml.jackson.annotation.JsonValue;

@RestController
@RequestMapping("/theatres")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class TheatreController {

	
	
	@Autowired
	private TheatreRepository theatreRepository;
	
	@Autowired 
	private TheatreService theatreService;
	
	@Autowired 
	private TheatreRepertoarService theatreRepertoarService;
	
	@Autowired 
	private TheatreProjectionService theatreProjectionService;
	
	@Autowired 
	private UserService userService;
	
	@JsonValue
	@GetMapping("/getTheatres")
	public TheatreResponse getTheatres(){
		
		List<Theatre>listt=theatreService.getAllTheatres();
		
		
		return new TheatreResponse(listt);
		
	}
	
	@GetMapping("getTheatres/{id}")
	public Theatre getTheatre(@PathVariable("id")Long id){
		
		Theatre theatre=theatreService.getTheatre(id);
		return theatre;
		
		
		
	}
	
	
	
	
	@PostMapping("/registration")
	@JsonValue
	public MessageResponseDTO registrationThe(@RequestBody TheatreDTO theatreDTO){
		
		Theatre t=new Theatre();
		//t.setId(theatreDTO.getId());
		t.setName(theatreDTO.getName());
		t.setLocation(theatreDTO.getLocation());
		t.setAdmin(theatreDTO.getAdmin());
		t.setPromOpis(theatreDTO.getPromOpis());
		
		 if(theatreDTO.getAdmin()!=null){
			  User adminthe=userService.findOneUserByEmail(theatreDTO.getAdmin());
		      adminthe.setRole("ADMIN_THEATRE");
		  
		    userService.saveUser(adminthe);
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
	
	@PostMapping("/editTheatre/{id}")
	public MessageResponseDTO editTheatre(@RequestBody TheatreDTO theatreDTO,@PathVariable("id")Long id){
		
		theatreService.TheatreEdit(theatreDTO, id);
		
		
		return new MessageResponseDTO("Theatre edited");
	}
	
	@DeleteMapping("/deleteTheatre/{id}")
	public MessageResponseDTO deleteTheatre(@PathVariable("id")Long id){
		
		theatreService.TheatreDelete(id);
		
		
		return new MessageResponseDTO("Theatre deleted");
	}
	
	
	@GetMapping("repertoar/{id}")
	public Set<TheatreProjection> getRepertoar(@PathVariable("id")Long id){
		
		TheatreRepertoar tr=theatreRepertoarService.getRepertoarFromTheatre(id);
		

		
		Set<TheatreProjection>tps=theatreProjectionService.getAllByRepertoar(tr.getId());
		
			
		
		return tps;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
