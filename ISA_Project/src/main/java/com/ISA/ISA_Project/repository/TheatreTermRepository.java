package com.ISA.ISA_Project.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ISA.ISA_Project.domain.TheatreTerm;

public interface TheatreTermRepository extends JpaRepository<TheatreTerm, Long> {
	
	List<TheatreTerm> findAll();

	TheatreTerm findOneById(Long id);
	
	@Query("select tt from TheatreTerm tt where (tt.tprojection.id) = (:id)")
	Set<TheatreTerm>findAllByTprojection(@Param("id")Long id);
	

}
