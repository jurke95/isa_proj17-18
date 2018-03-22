package com.ISA.ISA_Project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ISA.ISA_Project.domain.CinemaSeat;
import com.ISA.ISA_Project.domain.TheatreSeat;
import com.ISA.ISA_Project.repository.CinemaSeatRepository;
import com.ISA.ISA_Project.repository.TheatreSeatRepository;


@Service
public class TheatreSeatService {

	
	@Autowired
	private TheatreSeatRepository theatreSeatRepository;
	
	
	
	public TheatreSeat saveSeat(TheatreSeat seat) {
    	theatreSeatRepository.save(seat);
    	return seat;
    }
	
	
    public void deleteSeat(Long id){
		
		theatreSeatRepository.delete(theatreSeatRepository.findOneById(id));
	}
	
	
	
	
	
	
	
}
