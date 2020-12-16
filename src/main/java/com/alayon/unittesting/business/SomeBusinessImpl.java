
package com.alayon.unittesting.business;

import java.util.Arrays;

import com.alayon.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

	private SomeDataService someDataService;

	public void setSomeDataService(final SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(final int[] data) {
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}

	public int calculateSumWithDataService() {
		return Arrays.stream(someDataService.retrieveAllData()).reduce(Integer::sum).orElse(0);
	}
}
