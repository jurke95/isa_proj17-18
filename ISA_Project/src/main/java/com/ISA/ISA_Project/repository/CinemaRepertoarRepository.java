package com.ISA.ISA_Project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.ISA.ISA_Project.domain.CinemaRepertoar;



@Repository
public interface CinemaRepertoarRepository extends JpaRepository<CinemaRepertoar,Long> {

	List<CinemaRepertoar> findAll();
	CinemaRepertoar findOneById(Long id);
	@Query("select cr from CinemaRepertoar cr where (cr.cinema.id) = (:id)")
	CinemaRepertoar findOneByCinema(@Param("id")Long id);
	
}
