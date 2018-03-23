package com.ISA.ISA_Project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ISA.ISA_Project.domain.CinemaTerm;

public interface CinemaTermRepository extends JpaRepository<CinemaTerm, Long> {
	
	List<CinemaTerm> findAll();

	CinemaTerm findOneById(Long id);

}
