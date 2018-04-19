package com.ISA.ISA_Project.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.CinemaProjection;
import com.ISA.ISA_Project.repository.CinemaProjectionRepository;

@Service
public class CinemaProjectionService {

	@Autowired
	private CinemaProjectionRepository cinemaProjectionRepository;
	
	public CinemaProjection createProjection(CinemaProjection projection) {
		projection = cinemaProjectionRepository.save(projection);
		return projection;
	}
	
	public List<CinemaProjection>getAllProjection(){
		return cinemaProjectionRepository.findAll();
	}
	
	public boolean checkUniqueName(String name) {
		if (cinemaProjectionRepository.findOneByName(name) != null) {
			return false;
		}
		return true;
	}
	
	
	public Set<CinemaProjection>getAllByRepertoar(Long id){
		System.out.println("dosaooo u servis  "+id);
		return cinemaProjectionRepository.findAllByCrepertoar(id);
	}
	
	public CinemaProjection findOneByName(String name){
		
		return cinemaProjectionRepository.findOneByName(name);
	}
}
