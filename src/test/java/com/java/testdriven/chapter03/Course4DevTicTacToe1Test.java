package com.java.testdriven.chapter03;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
/**
 * 	需求 1 测试
 * 
 * 	首先定义边界，以及将棋子放在哪些地方非法：可将棋子放在3×3棋盘上任何没有棋子的地方。
 * 	可将这个需求分成三个测试：
  1、如果棋子放在超出了X轴边界的地方，就引发 RuntimeException 异常；
  2、如果棋子放在超出了Y轴边界的地方，就引发 RuntimeException 异常；
  3、如果棋子放在已经有棋子的地方，就引发 RuntimeException 异常。
 *	
 *	@author hzweiyongqiang
 */
public class Course4DevTicTacToe1Test {
	
	// 指定 ExpectedException 是一条规则
	// 如果这种异常是在实例化前引发的，这个测试将失败；反之，测试将成功。
	@Rule
	public ExpectedException exception = ExpectedException.none();	
	
	private Course4DevTicTacToe1 ticTacToe;
	
	/**
	 * 	@Before 可用来标注要在每个测试前运行的方法
	 * 	可使用它实例化测试中使用的类，或者指定要在每个测试前执行的其他操作
	 */
	@Before
	public final void Before() {
		ticTacToe = new Course4DevTicTacToe1();
	}

	/**
	 * 	棋子放在超出X轴边界的地方时，将引发 RuntimeException 异常。
	 */
	@Test
	public void whenXOutsideBoardThenRuntimeException() {
		exception.expect(RuntimeException.class);		// 期望引发 RuntimeException 异常。
		ticTacToe.play(5, 2);
	}

	/**
	 * 	棋子放在超出Y轴边界的地方时，将引发 RuntimeException 异常。
	 */
	@Test
	public void whenYOutsideBoardThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 5);
	}

	/**
	 * 	确定棋子在棋盘边界内后，还需确保它放在未被别的棋子占据的地方。
	 */
	@Test
	public void whenOccupiedThenRuntimeException() {
		ticTacToe.play(1, 2);
		exception.expect(RuntimeException.class);
		ticTacToe.play(1, 2);
	}

}
