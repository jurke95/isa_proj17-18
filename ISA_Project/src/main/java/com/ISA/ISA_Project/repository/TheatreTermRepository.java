package com.ISA.ISA_Project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ISA.ISA_Project.domain.TheatreTerm;

public interface TheatreTermRepository extends JpaRepository<TheatreTerm, Long> {
	
	List<TheatreTerm> findAll();

	TheatreTerm findOneById(Long id);

}
