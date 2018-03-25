package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.domain.CinemaHall;

@Repository
public interface  CinemaHallRepository extends JpaRepository<CinemaHall,Long> {

	CinemaHall findOneById(Long id);
	
	
	
}
