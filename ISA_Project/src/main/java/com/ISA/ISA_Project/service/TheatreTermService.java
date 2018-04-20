package com.ISA.ISA_Project.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.CinemaTerm;
import com.ISA.ISA_Project.domain.TheatreTerm;
import com.ISA.ISA_Project.repository.TheatreTermRepository;




@Service
public class TheatreTermService {

	
	@Autowired 
	private TheatreTermRepository theatreTermRepository;
	
	
	
	public TheatreTerm saveTheatreTerm(TheatreTerm tt) {
    	theatreTermRepository.save(tt);
    	return tt;
    }

	   public void deleteTheatreTerm(Long id){
			
			theatreTermRepository.delete(theatreTermRepository.findOneById(id));
		}
	
  public Set<TheatreTerm> getAllTermsByTprojection(Long id){
		   
		   
		   return theatreTermRepository.findAllByTprojection(id);
	   }
	   
	   
	   public TheatreTerm getTermById(Long id){
			
			return theatreTermRepository.findOneById(id);
		}
	
}
