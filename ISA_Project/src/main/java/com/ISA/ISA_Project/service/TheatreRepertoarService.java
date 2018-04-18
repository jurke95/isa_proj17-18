package com.ISA.ISA_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ISA.ISA_Project.domain.TheatreRepertoar;
import com.ISA.ISA_Project.repository.TheatreRepertoarRepository;



@Service
public class TheatreRepertoarService {

	@Autowired
	private TheatreRepertoarRepository theatreRepertoarRepository;
	
	
	
	
	
	
	public TheatreRepertoar getRepertoarFromTheatre(Long id){
		
		
		return theatreRepertoarRepository.findOneByTheatre(id);
		
		
		
	}
}
