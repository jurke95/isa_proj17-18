package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ISA.ISA_Project.domain.TheatreSeat;

@Repository
public interface  TheatreSeatRepository extends JpaRepository<TheatreSeat, Long> {

	
	TheatreSeat findOneById(Long id);
	
}
