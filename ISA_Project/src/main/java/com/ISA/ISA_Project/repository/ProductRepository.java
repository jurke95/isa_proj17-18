package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ISA.ISA_Project.domain.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

	Product findOneById(Long id);
}
