package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ISA.ISA_Project.domain.FanZone;
import com.ISA.ISA_Project.domain.Item;

public interface FanZoneRepository extends JpaRepository<FanZone,Long> {

	
	FanZone findOneById(FanZone fanzone);
}