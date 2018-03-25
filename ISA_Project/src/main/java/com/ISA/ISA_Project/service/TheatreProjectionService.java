package com.ISA.ISA_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.TheatreProjection;
import com.ISA.ISA_Project.repository.TheatreProjectionRepository;


@Service
public class TheatreProjectionService {

	@Autowired
	private TheatreProjectionRepository theatreProjectionRepository;
	
	public TheatreProjection createTheatreProjection(TheatreProjection projection) {
		projection = theatreProjectionRepository.save(projection);
		return projection;
	}
	
	public List<TheatreProjection>getAllProjection(){
		return theatreProjectionRepository.findAll();
	}
	
	public boolean checkUniqueName(String name) {
		if (theatreProjectionRepository.findOneByName(name) != null) {
			return false;
		}
		return true;
	}
	
	
	
}
