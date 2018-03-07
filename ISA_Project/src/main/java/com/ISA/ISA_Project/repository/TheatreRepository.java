package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ISA.ISA_Project.theatre.Theatre;
@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Long>{

}
