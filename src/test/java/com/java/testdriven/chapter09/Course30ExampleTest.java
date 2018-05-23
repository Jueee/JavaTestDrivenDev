package com.java.testdriven.chapter09;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Course30ExampleTest {

	private Course31Fibonacci test;
	
	private final String expectedExceptionMessage = "Requested number " +
			"must be a positive number no bigger than " + Course31Fibonacci.LIMIT;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void Before() {
		test = new Course31Fibonacci();
	}
	
	@Test
	public void test0() {
		int actual = test.getNthNumber(0);
		assertEquals(0, actual);
	}
	
	@Test
	public void test1() {
		int actual = test.getNthNumber(1);
		assertEquals(1, actual);
	}
	
	@Test
	public void test7() {
		int actual = test.getNthNumber(7);
		assertEquals(13, actual);
	}
	
	@Test
	public void testNegative() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(is(expectedExceptionMessage));
		test.getNthNumber(-1);
	}
	
	@Test
	public void testOutOfBounce() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(is(expectedExceptionMessage));
		test.getNthNumber(31);
	}

}
