package com.ISA.ISA_Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.repository.TheatreRepository;
import com.ISA.ISA_Project.theatre.Theatre;

@Service
public class TheatreService {

private TheatreRepository therep;





public List<Theatre>getAllTheatres(){
	
	return therep.findAll();
	
}





}
