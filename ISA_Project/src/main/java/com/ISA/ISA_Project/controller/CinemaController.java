package com.ISA.ISA_Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
	
	
	
	
	
	
}
