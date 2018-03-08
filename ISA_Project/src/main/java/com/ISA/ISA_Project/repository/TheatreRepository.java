package com.ISA.ISA_Project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.domain.Cinema;
import com.ISA.ISA_Project.theatre.Theatre;
@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Long>{
	
	List<Theatre> findAll();
	List<Theatre> findAllByName(String name);
	Theatre findOneById(Long id);
	Theatre findOneByName(String name);

}
