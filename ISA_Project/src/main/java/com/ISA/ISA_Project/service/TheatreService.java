package com.ISA.ISA_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.Theatre;
import com.ISA.ISA_Project.repository.TheatreRepository;

@Service
public class TheatreService {
	@Autowired
	private TheatreRepository therep;

	public List<Theatre> getAllTheatres() {

		return therep.findAll();

	}
	
    public Theatre getTheatre(Long id){
		
		return therep.findOneById(id);
	}
	
	
    public Theatre registrateTheatre(Theatre t){
		
		
		therep.save(t);
		return t;
	}
	
	public boolean checkUniqueId(Long idd){
		
		if(therep.findOneById(idd)!=null){
			return false;
		}else
			return true;
			

	}
	
	public boolean checkUniqueName(String n){
			
		
		if(therep.findOneByName(n)!=null){
			return false;
		}else
			return true;
	}
	
	
	
	
	
	

}
