package com.ISA.ISA_Project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ISA.ISA_Project.domain.TheatreHall;
import com.ISA.ISA_Project.repository.TheatreHallRepository;




public class TheatreHallService {

	
	@Autowired
	private TheatreHallRepository theatreHallRepository;
	
	public TheatreHall saveTheatreHall(TheatreHall th) {
    	theatreHallRepository.save(th);
    	return th;
    }
	
	
     public void deleteTheatreHall(Long id){
		
		theatreHallRepository.delete(theatreHallRepository.findOneById(id));
	}
	
}
