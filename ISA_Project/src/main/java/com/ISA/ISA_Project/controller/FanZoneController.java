package com.ISA.ISA_Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ISA.ISA_Project.domain.Cinema;
import com.ISA.ISA_Project.domain.Item;
import com.ISA.ISA_Project.repository.FanZoneRepository;
import com.ISA.ISA_Project.repository.ItemRepository;
import com.ISA.ISA_Project.response.CinemaResponse;
import com.ISA.ISA_Project.response.ItemResponse;
import com.ISA.ISA_Project.service.ItemService;

@RestController
@RequestMapping("/fanzone")
public class FanZoneController {

	
	@Autowired
	private FanZoneRepository fanzoneRepository;
	
	
	@Autowired
	private ItemService itemService;
	
	
	
	@GetMapping("/getItems")
	public ItemResponse getItems() {

		List<Item>listi=itemService.getAllItems();
		return new ItemResponse(listi);
		
		
	}
	
	
}
