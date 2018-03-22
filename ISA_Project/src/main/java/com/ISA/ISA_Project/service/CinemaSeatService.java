package com.ISA.ISA_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ISA.ISA_Project.domain.CinemaSeat;
import com.ISA.ISA_Project.repository.CinemaSeatRepository;


@Service
public class CinemaSeatService {

	
	@Autowired
	private CinemaSeatRepository cinemaSeatRepository;
	
	
	
	public CinemaSeat saveSeat(CinemaSeat seat) {
    	cinemaSeatRepository.save(seat);
    	return seat;
    }
	
	
    public void deleteSeat(Long id){
		
		cinemaSeatRepository.delete(cinemaSeatRepository.findOneById(id));
	}
	
	
	
	
	
	
	
}
