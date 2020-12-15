package com.alayon.unittesting.business;

import org.springframework.stereotype.Service;

import com.alayon.unittesting.models.Item;

@Service
public class ItemBusinessService {

	public Item retrieveHarcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}

}
