package com.ISA.ISA_Project.controller.TheatreController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ISA.ISA_Project.controller.TheatreController.dto.TheatreDTO;
import com.ISA.ISA_Project.controller.dto.MessageResponseDTO;
import com.ISA.ISA_Project.domain.Theatre;
import com.ISA.ISA_Project.repository.TheatreRepository;
import com.ISA.ISA_Project.response.TheatreResponse;
import com.ISA.ISA_Project.service.TheatreService;

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
	
	@GetMapping("getTheatres/{id}")
	public Theatre getTheatre(@PathVariable("id")Long id){
		
		Theatre theatre=theatreService.getTheatre(id);
		return theatre;
		
		
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
}
