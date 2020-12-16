package com.alayon.unittesting.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alayon.unittesting.data.ItemRepository;
import com.alayon.unittesting.models.Item;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessTest {

	@InjectMocks
	ItemBusinessService itemBusinessService;

	@Mock
	ItemRepository itemRepository;

	@Test
	public void retrieveAllItems_basics() {

		when(itemRepository.findAll()).thenReturn(
				List.of(new Item(1, "item1", 10, 10), new Item(2, "item2", 20, 10), new Item(3, "item3", 5, 10)));

		final List<Item> items = itemBusinessService.retrieveAllItems();

		assertThat(100).isEqualTo(items.get(0).getValue());
		assertThat(200).isEqualTo(items.get(1).getValue());
		assertThat(50).isEqualTo(items.get(2).getValue());
	}
}
