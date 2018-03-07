package com.ISA.ISA_Project.controller.TheatreController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ISA.ISA_Project.domain.Cinema;
import com.ISA.ISA_Project.repository.TheatreRepository;
import com.ISA.ISA_Project.response.CinemaResponse;
import com.ISA.ISA_Project.response.TheatreResponse;
import com.ISA.ISA_Project.service.TheatreService;
import com.ISA.ISA_Project.theatre.Theatre;

@RestController


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
	
	
	
	
}
