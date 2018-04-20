package com.ISA.ISA_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.ReservationTheatreTicket;
import com.ISA.ISA_Project.repository.ReservationTheatreTicketRepository;



@Service
public class ReservationTheatreTicketService {
	
	@Autowired
	private ReservationTheatreTicketRepository reservationTheatreTicketRepository;
	

	
					
	
	public void saveTheatreTicketReservation(ReservationTheatreTicket rtt) {
		reservationTheatreTicketRepository.save(rtt);
    	
    }
	
	
	
	
	
}