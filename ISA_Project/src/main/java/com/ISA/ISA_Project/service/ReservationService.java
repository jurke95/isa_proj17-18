package com.ISA.ISA_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.Ad;
import com.ISA.ISA_Project.domain.Reservation;
import com.ISA.ISA_Project.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public List<Reservation> getAllItems(){
		return reservationRepository.findAll();
	}
	
	public Reservation getReservation(Long id) {
		return reservationRepository.findOneBy(id);
	}
	
	public boolean checkUniqueReservation(Long id) {
		if (reservationRepository.findOneBy(id) != null) {
			return false;
		}
		return true;
	}
	
	public Reservation saveReservation(Reservation reservation) {
    	reservationRepository.save(reservation);
    	return reservation;
    }
	
	public void deleteReservation(Long id){
		
		reservationRepository.delete(reservationRepository.findOneBy(id));
	}

}
