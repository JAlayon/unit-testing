package com.alayon.unittesting.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.alayon.unittesting.models.Item;

@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepository;

	@Test
	public void testFindAll() {
		final List<Item> items = itemRepository.findAll();
		assertEquals(3, items.size());
	}
}
