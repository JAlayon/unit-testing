package com.alayon.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SomeBusinessTest {

	@Test
	public void calculateSum_basics() {
		final SomeBusinessImpl business = new SomeBusinessImpl();
		final int result = business.calculateSum(new int[] { 1, 2, 3 });
		final int expectedResult = 6;
		assertEquals(result, expectedResult);
	}

	@Test
	public void calculateSum_empty() {
		final SomeBusinessImpl business = new SomeBusinessImpl();
		final int result = business.calculateSum(new int[] {});
		final int expectedResult = 0;
		assertEquals(result, expectedResult);
	}

	@Test
	public void calculateSum_oneValue() {
		final SomeBusinessImpl business = new SomeBusinessImpl();
		final int result = business.calculateSum(new int[] { 5 });
		final int expectedResult = 5;
		assertEquals(result, expectedResult);
	}

}
