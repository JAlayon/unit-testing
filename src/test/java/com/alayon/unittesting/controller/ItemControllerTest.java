package com.alayon.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

		when(itemBusinessService.retrieveHarcodedItem()).thenReturn(new Item(2, "Item2", 10, 10));

		// call GET /hello-world application/json
		final RequestBuilder request = MockMvcRequestBuilders.get(URI_FROM_BUSINESS).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\"id\":2,\"name\":\"Item2\",\"price\":10,\"quantity\":10}")).andReturn();

	}
}
