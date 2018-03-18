package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ISA.ISA_Project.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Reservation findOneBy(Long id);
}
