package com.alayon.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alayon.unittesting.data.ItemRepository;
import com.alayon.unittesting.models.Item;

@Service
public class ItemBusinessService {

	@Autowired
	private ItemRepository itemRepository;

	public Item retrieveHarcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}

	public List<Item> retrieveAllItems() {
		final List<Item> items = itemRepository.findAll();
		items.forEach(item -> item.setValue(item.getPrice() * item.getQuantity()));
		return items;
	}
}
