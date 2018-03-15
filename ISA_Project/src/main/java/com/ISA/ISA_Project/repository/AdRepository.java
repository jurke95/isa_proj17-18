package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ISA.ISA_Project.domain.Ad;
import com.ISA.ISA_Project.domain.Product;

public interface AdRepository extends JpaRepository<Ad,Long>{

	Ad findOneById(Long id);
}
