package com.ISA.ISA_Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.cinema.Cinema;
import com.ISA.ISA_Project.repository.CinemaRepository;


/*
 *Servis za upravljanje bioskopom
 
 */
@Service
public class CinemaService {

	private CinemaRepository cinrep;
	
	
	public List<Cinema>getAllCinemas(){
		
		return cinrep.findAll();
	}
	
	
	
	
}
