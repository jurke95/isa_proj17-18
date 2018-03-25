package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.domain.TheatreHall;

@Repository
public interface  TheatreHallRepository extends JpaRepository<TheatreHall,Long> {

	TheatreHall findOneById(TheatreHall id);
	
	
	
}
