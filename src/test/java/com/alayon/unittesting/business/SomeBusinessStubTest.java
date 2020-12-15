package com.alayon.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SomeBusinessStubTest {

	@Test
	public void calculateSumWithDataService_basics() {
		final SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(() -> new int[] { 1, 2, 3 });
		final int result = business.calculateSumWithDataService();
		final int expectedResult = 6;
		assertEquals(result, expectedResult);
	}

	@Test
	public void calculateSumWithDataService_empty() {
		final SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(() -> new int[] {});
		final int result = business.calculateSumWithDataService();
		final int expectedResult = 0;
		assertEquals(result, expectedResult);
	}

	@Test
	public void calculateSumWithDataService_oneValue() {
		final SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(() -> new int[] { 6 });
		final int result = business.calculateSumWithDataService();
		final int expectedResult = 6;
		assertEquals(result, expectedResult);
	}

}
