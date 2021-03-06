package com.ISA.ISA_Project.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.domain.CinemaProjection;

@Repository
public interface CinemaProjectionRepository extends JpaRepository<CinemaProjection,Long> {
	
	List<CinemaProjection> findAll();
	List<CinemaProjection> findAllByName(String name);
	CinemaProjection findOneById(Long id);
	CinemaProjection findOneByName(String name);
	@Query("select cp from CinemaProjection cp where (cp.crepertoar.id) = (:id)")
	Set<CinemaProjection>findAllByCrepertoar(@Param("id")Long id);

}
