package com.ISA.ISA_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.Scale;
import com.ISA.ISA_Project.repository.ScaleRepository;

@Service
public class ScaleService {

	@Autowired
	private ScaleRepository scaleRepository;
	
	
	
public Scale addScale(Scale s) {
		
		Scale sc = scaleRepository.findByIdEquals(s.getId());
		
		if(sc==null) {
			scaleRepository.save(s);
			return s;
		}
		return null;
	}

	
	public Scale getscale(Long id) {
		
		Scale sc = scaleRepository.findByIdEquals(id);
		return sc;
	}
	
	
	
}
