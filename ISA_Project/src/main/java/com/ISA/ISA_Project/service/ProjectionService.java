package com.ISA.ISA_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.Projection;
import com.ISA.ISA_Project.domain.User;
import com.ISA.ISA_Project.repository.ProjectionRepository;

@Service
public class ProjectionService {

	@Autowired
	private ProjectionRepository projectionRepository;
	
	public Projection createProjection(Projection projection) {
		projection = projectionRepository.save(projection);
		return projection;
	}
	
	public List<Projection>getAllProjection(){
		return projectionRepository.findAll();
	}
	
	public boolean checkUniqueName(String name) {
		if (projectionRepository.findOneByName(name) != null) {
			return false;
		}
		return true;
	}
}
