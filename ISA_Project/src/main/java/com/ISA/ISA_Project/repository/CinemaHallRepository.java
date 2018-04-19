package com.ISA.ISA_Project.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.domain.CinemaHall;
import com.ISA.ISA_Project.domain.CinemaProjection;

@Repository
public interface  CinemaHallRepository extends JpaRepository<CinemaHall,Long> {

	CinemaHall findOneById(Long id);
	
	
	
	
}
