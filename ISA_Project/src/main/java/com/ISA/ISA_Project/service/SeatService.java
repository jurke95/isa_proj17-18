package com.ISA.ISA_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ISA.ISA_Project.domain.CinemaSeat;
import com.ISA.ISA_Project.repository.SeatRepository;

@Service
public class SeatService {

	
	@Autowired
	private SeatRepository seatRepository;
	
	
	
	public CinemaSeat saveSeat(CinemaSeat seat) {
    	seatRepository.save(seat);
    	return seat;
    }
	
	
    public void deleteSeat(Long id){
		
		seatRepository.delete(seatRepository.findOneById(id));
	}
	
	
	
	
	
	
	
}
