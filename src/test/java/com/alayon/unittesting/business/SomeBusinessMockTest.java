package com.alayon.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.alayon.unittesting.data.SomeDataService;

public class SomeBusinessMockTest {

	final SomeBusinessImpl business = new SomeBusinessImpl();
	final SomeDataService dataServiceMock = mock(SomeDataService.class);

	@BeforeEach
	public void setup() {
		business.setSomeDataService(dataServiceMock);
	}

	@Test
	public void calculateSumWithDataService_basics() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, business.calculateSumWithDataService());
	}

	@Test
	public void calculateSumWithDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(6, business.calculateSumWithDataService());
	}

	@Test
	public void calculateSumWithDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 6 });
		assertEquals(6, business.calculateSumWithDataService());
	}
}
