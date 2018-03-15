package com.ISA.ISA_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ISA.ISA_Project.domain.Item;
import com.ISA.ISA_Project.repository.ItemRepository;

@Service
public class ItemService {

	
	@Autowired
	private ItemRepository itemRepository;
	
	
	
	public List<Item>getAllItems(){
		
		return itemRepository.findAll();
	}
	
}
