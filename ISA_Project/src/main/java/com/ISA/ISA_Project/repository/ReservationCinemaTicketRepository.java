package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ISA.ISA_Project.domain.ReservationCinemaTicket;

@Repository
public interface ReservationCinemaTicketRepository extends JpaRepository<ReservationCinemaTicket,Long> {
	
	ReservationCinemaTicket findOneById(Long id);

}
