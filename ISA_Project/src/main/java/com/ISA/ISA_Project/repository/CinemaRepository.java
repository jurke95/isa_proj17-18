package com.ISA.ISA_Project.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.domain.Cinema;
@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long>{

	List<Cinema> findAll();
	List<Cinema> findAllByName(String name);
	Cinema findOneById(Long id);
	Cinema findOneByName(String name);
}
