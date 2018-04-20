package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.domain.ReservationTheatreTicket;



@Repository
public interface ReservationTheatreTicketRepository extends JpaRepository<ReservationTheatreTicket,Long> {
	
	ReservationTheatreTicket findOneById(Long id);

}
