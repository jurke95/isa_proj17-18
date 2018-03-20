package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ISA.ISA_Project.domain.Offer;


public interface OfferRepository extends JpaRepository<Offer,Long>{
	
	Offer findOneById(Long id);
	Offer findAllByBidder(Long id);
}
