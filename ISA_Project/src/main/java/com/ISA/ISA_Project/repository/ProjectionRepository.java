package com.ISA.ISA_Project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.domain.Projection;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection,Long> {
	
	List<Projection> findAll();
	List<Projection> findAllByName(String name);
	Projection findOneById(Long id);
	Projection findOneByName(String name);

}
