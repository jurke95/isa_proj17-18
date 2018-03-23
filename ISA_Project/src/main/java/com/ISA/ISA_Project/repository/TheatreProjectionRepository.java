package com.ISA.ISA_Project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.domain.TheatreProjection;

@Repository
public interface TheatreProjectionRepository extends JpaRepository<TheatreProjection, Long> {

	List<TheatreProjection> findAll();

	List<TheatreProjection> findAllByName(String name);

	TheatreProjection findOneById(Long id);

	TheatreProjection findOneByName(String name);

}
