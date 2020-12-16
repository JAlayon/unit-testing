package com.alayon.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.alayon.unittesting.business.ItemBusinessService;
import com.alayon.unittesting.models.Item;

@WebMvcTest(ItemController.class)

public class ItemControllerTest {

	private static final String URI_DUMMIE = "/dummy-item";
	private static final String URI_FROM_BUSINESS = "/item-from-business-service";
	private static final String URI_FROM_DB = "/all-items-from-db";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemBusinessService itemBusinessService;

	@Test
	public void getItem_basic() throws Exception {
		// call GET /hello-world application/json
		final RequestBuilder request = MockMvcRequestBuilders.get(URI_DUMMIE).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10}")).andReturn();

		// verify
		// assertThat("Hello
		// world").isEqualTo(result.getResponse().getContentAsString());

	}

	@Test
	public void getItemFromBusinessService_basic() throws Exception {

		when(itemBusinessService.retrieveHarcodedItem()).thenReturn(new Item(1, "Item1", 10, 10));

		// call GET /hello-world application/json
		final RequestBuilder request = MockMvcRequestBuilders.get(URI_FROM_BUSINESS).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Item1\",\"price\":10,\"quantity\":10}")).andReturn();

	}

	@Test
	public void getAllItems_basic() throws Exception {
		when(itemBusinessService.retrieveAllItems()).thenReturn(
				Arrays.asList(new Item(1, "item1", 10, 10), new Item(2, "item2", 10, 10), new Item(3, "item3", 5, 10)));
		// call GET /hello-world application/json
		final RequestBuilder request = MockMvcRequestBuilders.get(URI_FROM_DB).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":1,\"name\":\"item1\",\"price\":10,\"quantity\":10}, "
						+ "{\"id\":2,\"name\":\"item2\",\"price\":10,\"quantity\":10}, "
						+ "{\"id\":3,\"name\":\"item3\",\"price\":5,\"quantity\":10}]"))
				.andReturn();

	}
}
