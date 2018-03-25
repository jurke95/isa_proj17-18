package com.ISA.ISA_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ISA.ISA_Project.domain.CinemaHall;
import com.ISA.ISA_Project.repository.CinemaHallRepository;

@Service
public class CinemaHallService {
	
	@Autowired
	private CinemaHallRepository cinemaHallRepository;
	
	public CinemaHall saveCinemaHall(CinemaHall ch) {
    	cinemaHallRepository.save(ch);
    	return ch;
    }
	
	
	
	
	

}
