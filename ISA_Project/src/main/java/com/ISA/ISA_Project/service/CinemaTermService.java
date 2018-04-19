package com.ISA.ISA_Project.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.CinemaHall;
import com.ISA.ISA_Project.domain.CinemaTerm;

import com.ISA.ISA_Project.repository.CinemaTermRepository;

@Service
public class CinemaTermService {

	
	@Autowired 
	private CinemaTermRepository cinemaTermRepository;
	
	
	
	public CinemaTerm saveCinemaTerm(CinemaTerm ct) {
    	cinemaTermRepository.save(ct);
    	return ct;
    }

	   public void deleteCinemaTerm(Long id){
			
			cinemaTermRepository.delete(cinemaTermRepository.findOneById(id));
		}
	
	
	   public Set<CinemaTerm> getAllTermsByCprojection(Long id){
		   
		   
		   return cinemaTermRepository.findAllByCprojection(id);
	   }
	   
	   
	   public CinemaTerm getTermById(Long id){
			
			return cinemaTermRepository.findOneById(id);
		}
	 
	
}
