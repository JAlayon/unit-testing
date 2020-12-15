package com.alayon.unittesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alayon.unittesting.business.ItemBusinessService;
import com.alayon.unittesting.models.Item;

@RestController
public class ItemController {

	@Autowired
	private ItemBusinessService itemBusinessService;

	@GetMapping("/dummy-item")
	public Item getItem() {
		return new Item(1, "Ball", 10, 100);
	}

	@GetMapping("/item-from-business-service")
	public Item getItemFromBusinessService() {
		return itemBusinessService.retrieveHarcodedItem();
	}
}
