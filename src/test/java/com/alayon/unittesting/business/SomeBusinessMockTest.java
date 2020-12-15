package com.alayon.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alayon.unittesting.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl business = new SomeBusinessImpl();

	@Mock
	SomeDataService dataServiceMock;

	/*
	 * When use @InjectMocks annotation, you dont have to "inject" manually the
	 * dependency. For example here in our beforeEach annotation, we were injecting
	 * via set method.
	 *
	 * @BeforeEach public void setup() {
	 * business.setSomeDataService(dataServiceMock); }
	 */

	@Test
	public void calculateSumWithDataService_basics() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, business.calculateSumWithDataService());
	}

	@Test
	public void calculateSumWithDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumWithDataService());
	}

	@Test
	public void calculateSumWithDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 6 });
		assertEquals(6, business.calculateSumWithDataService());
	}
}
