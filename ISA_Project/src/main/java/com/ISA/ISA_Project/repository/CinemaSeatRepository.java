package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.domain.CinemaSeat;

@Repository
public interface  CinemaSeatRepository extends JpaRepository<CinemaSeat, Long> {

	
	CinemaSeat findOneById(Long id);
	
}
