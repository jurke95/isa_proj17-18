package com.ISA.ISA_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ISA.ISA_Project.domain.ReservationCinemaTicket;
import com.ISA.ISA_Project.repository.ReservationCinemaTicketRepository;



@Service
public class ReservationCinemaTicketService {
	
	@Autowired
	private ReservationCinemaTicketRepository reservationCinemaTicketRepository;
	

	
					
	
	public void saveCinemaTicketReservation(ReservationCinemaTicket rst) {
		reservationCinemaTicketRepository.save(rst);
    	
    }
	
	
	
	
	
}
