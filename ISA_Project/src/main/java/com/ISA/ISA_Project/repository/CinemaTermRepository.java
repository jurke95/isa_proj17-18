package com.ISA.ISA_Project.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ISA.ISA_Project.domain.CinemaHall;
import com.ISA.ISA_Project.domain.CinemaProjection;
import com.ISA.ISA_Project.domain.CinemaTerm;

public interface CinemaTermRepository extends JpaRepository<CinemaTerm, Long> {
	
	List<CinemaTerm> findAll();

	CinemaTerm findOneById(Long id);
	
	@Query("select ct from CinemaTerm ct where (ct.cprojection.id) = (:id)")
	Set<CinemaTerm>findAllByCprojection(@Param("id")Long id);
	

}
