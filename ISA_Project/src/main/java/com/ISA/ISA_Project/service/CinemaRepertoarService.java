package com.ISA.ISA_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.CinemaRepertoar;
import com.ISA.ISA_Project.repository.CinemaRepertoarRepository;


@Service
public class CinemaRepertoarService {

	
	@Autowired
	private CinemaRepertoarRepository cinemaRepertoarRepository;
	
	
	
	
	
	
	public CinemaRepertoar getRepertoarFromCinema(Long id){
		
		
		return cinemaRepertoarRepository.findOneByCinema(id);
		
		
		
	}
	
	
	
	
	
}
