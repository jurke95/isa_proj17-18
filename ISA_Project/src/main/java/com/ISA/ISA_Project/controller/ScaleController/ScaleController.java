package com.ISA.ISA_Project.controller.ScaleController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ISA.ISA_Project.controller.dto.MessageResponseDTO;
import com.ISA.ISA_Project.domain.Friendship;
import com.ISA.ISA_Project.domain.Scale;
import com.ISA.ISA_Project.service.ScaleService;


@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping(value="/scale")
public class ScaleController {

	
	@Autowired
	private ScaleService scaleService;
	
	
	
	
	@PostMapping("/addScale")
	public MessageResponseDTO addScale(@RequestBody Scale s){
		
		
		Scale scale = scaleService.addScale(s);
		
		if(!(scale==null)) {
			return new MessageResponseDTO("Successfully added scale");
		}
		return new MessageResponseDTO("Cannot add scale");
		
	}
	
	@GetMapping("/getScale/{id}")
	public Scale getScale(@PathVariable Long id){
		
		
		Scale scale = scaleService.getscale(id);
		
		return scale;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
