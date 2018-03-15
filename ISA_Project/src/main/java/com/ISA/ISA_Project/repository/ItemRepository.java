package com.ISA.ISA_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ISA.ISA_Project.domain.Item;

public interface ItemRepository extends JpaRepository<Item,Long>{

	Item findOneById(Long id);
}
