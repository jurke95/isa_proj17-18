package com.ISA.ISA_Project.response;

import java.util.List;

import com.ISA.ISA_Project.domain.Item;

public class ItemResponse {

	
	private List<Item> items;
	
	
	public ItemResponse(List<Item>listItems){
		
		
		this.items=listItems;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
	
	
}
