package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ISA.ISA_Project.domain.CinemaHall;

public interface  CinemaHallRepository extends JpaRepository<CinemaHall,Long> {

	CinemaHall findOneById(CinemaHall id);
	
	
	
}
