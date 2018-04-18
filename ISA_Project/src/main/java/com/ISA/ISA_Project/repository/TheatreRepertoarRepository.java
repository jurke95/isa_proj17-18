package com.ISA.ISA_Project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.domain.TheatreRepertoar;

@Repository
public interface TheatreRepertoarRepository extends JpaRepository<TheatreRepertoar,Long> {

	
	
	
	List<TheatreRepertoar> findAll();
	TheatreRepertoar findOneById(Long id);
	@Query("select tr from TheatreRepertoar tr where (tr.theatre.id) = (:id)")
	TheatreRepertoar findOneByTheatre(@Param("id")Long id);
}
