package com.java.testdriven.chapter08;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.java.testdriven.chapter08.Course10LegacyCode.TicTacToe0;
import com.java.testdriven.chapter08.Course10LegacyCode.TicTacToe1;
import com.java.testdriven.chapter08.Course10LegacyCode.TicTacToe2;

public class Course10LegacyCodeTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private Course10LegacyCode test;
	private TicTacToe0 ticTacToe0;
	private TicTacToe1 ticTacToe1;
	private TicTacToe2 ticTacToe2;
	
	@Before
	public void Before() {
		test = new Course10LegacyCode();
		ticTacToe0 = test.new TicTacToe0();
		ticTacToe1 = test.new TicTacToe1();
		ticTacToe2 = test.new TicTacToe2();
	}
	
	@Test
	public void whenXOutsideBoardThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe0.validatePosition(5, 2);
	}
	
	@Test
	public void whenYOutsideBoardThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe0.validatePosition(2, 5);
	}
	
	@Test
	public void whenXOutsideBoardThenRuntimeException1() {
		exception.expect(RuntimeException.class);
		ticTacToe1.validatePosition(5, 2);
	}
	
	@Test
	public void whenYOutsideBoardThenRuntimeException1() {
		exception.expect(RuntimeException.class);
		ticTacToe1.validatePosition(2, 5);
	}
	
	@Test
	public void whenXOutsideBoardThenRuntimeException2() {
		exception.expect(RuntimeException.class);
		ticTacToe2.validatePosition(5, 2);
	}
	
	@Test
	public void whenYOutsideBoardThenRuntimeException2() {
		exception.expect(RuntimeException.class);
		ticTacToe2.validatePosition(2, 5);
	}

}
