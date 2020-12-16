package com.alayon.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void test() {
		final String responseFromService = "[\n" + "{\"id\":1000, \"name\":\"Pencil\", \"quantity\":5},\n"
				+ "{\"id\":1001, \"name\":\"Pen\", \"quantity\":15},\n"
				+ "{\"id\":1002, \"name\":\"Eraser\", \"quantity\":1}\n" + "]";

		final DocumentContext context = JsonPath.parse(responseFromService);
		final int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
	}
}
