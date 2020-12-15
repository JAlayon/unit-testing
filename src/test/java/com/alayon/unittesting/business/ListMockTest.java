package com.alayon.unittesting.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {

	@SuppressWarnings("unchecked")
	List<? super String> mock = mock(List.class);

	@Test
	public void size_basic() {

		when(mock.size()).thenReturn(5);
		assertThat(5).isEqualTo(mock.size());
	}

	@Test
	public void returnDifferentValues() {

		when(mock.size()).thenReturn(5).thenReturn(10);
		assertThat(5).isEqualTo(mock.size());
		assertThat(10).isEqualTo(mock.size());
	}

	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("hello");
		assertThat("hello").isEqualTo(mock.get(0));
		assertThat(mock.get(1)).isNull();
	}

	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("hello");
		assertThat("hello").isEqualTo(mock.get((int) (Math.random())));
	}

	@Test
	public void verificationBasics() {
		mock.get(0);
		mock.get(1);

		// verify
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}

	@Test
	public void argumentCapturing() {
		mock.add("SomeString");

		// Verification
		final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

		verify(mock).add(captor.capture());

		assertEquals("SomeString", captor.getValue());
	}

	@Test
	public void multipleArgumentCapturing() {
		mock.add("SomeString1");
		mock.add("SomeString2");

		// Verification
		final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

		verify(mock, times(2)).add(captor.capture());

		assertEquals("SomeString1", captor.getAllValues().get(0));
		assertEquals("SomeString2", captor.getAllValues().get(1));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void mocking() {
		/**
		 * A mock does not retain behaviour (code) of the original class
		 */
		final ArrayList<Object> arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0)); // null

		System.out.println(arrayListMock.size()); // 0
		arrayListMock.add("test1");
		arrayListMock.add("test2");

		System.out.println(arrayListMock.size()); // 0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());// 5

	}

	@SuppressWarnings("unchecked")
	@Test
	public void spying() {
		/**
		 * A spy, by default, retains behavior of the original class
		 */
		final ArrayList<Object> arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("test0");
		System.out.println(arrayListSpy.get(0)); // test0

		System.out.println(arrayListSpy.size()); // 1
		arrayListSpy.add("test1");
		arrayListSpy.add("test2");

		System.out.println(arrayListSpy.size()); // 3
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());// 5

		arrayListSpy.add("test3");
		System.out.println(arrayListSpy.size()); // 5

		verify(arrayListSpy).add("test3");

	}
}
