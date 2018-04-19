package com.ISA.ISA_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.controller.CinemaController.dto.CinemaDTO;
import com.ISA.ISA_Project.domain.Cinema;
import com.ISA.ISA_Project.repository.CinemaRepository;


/*
 *Servis za upravljanje bioskopom
 
 */
@Service
public class CinemaService {

	
	@Autowired
	private CinemaRepository cinrep;
	
	
	public List<Cinema>getAllCinemas(){

		return cinrep.findAll();
	}
	
	public Cinema getCinema(Long id){
		
		return cinrep.findOneById(id);
	}
	
	public Cinema getCinemaByName(String name){
		
		return cinrep.findOneByName(name);
	}
	
	
	public Cinema registrateCinema(Cinema cinema){
		
		
		cinrep.save(cinema);
		return cinema;
	}
	
	public boolean checkUniqueId(Long idd){
		
		if(cinrep.findOneById(idd)!=null){
			return false;
		}else
			return true;
			

	}
	
	public boolean checkUniqueName(String n){
			
		
		if(cinrep.findOneByName(n)!=null){
			return false;
		}else
			return true;
	}
	
	public void  CinemaEdit(CinemaDTO cinemaDTO,Long id){
		
		Cinema c=cinrep.findOneById(id);
		c.setName(cinemaDTO.getName());
		c.setLocation(cinemaDTO.getLocation());
		c.setPromOpis(cinemaDTO.getPromOpis());
		
		cinrep.save(c);
		
		
	}
	
	public void CinemaDelete(Long id){
		
		cinrep.delete(cinrep.findOneById(id));
	}
	
	
	
	
	
	
	
	
	
	
	
	

	}
