package com.alayon.unittesting.business;

import com.alayon.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

	private SomeDataService someDataService;

	public void setSomeDataService(final SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(final int[] data) {
		int sum = 0;
		for (final int value : data) {
			sum += value;
		}
		return sum;
	}

	public int calculateSumWithDataService() {
		int sum = 0;
		final int data[] = someDataService.retrieveAllData();
		for (final int value : data) {
			sum += value;

		}
		return sum;
	}
}
