package com.java.testdriven.chapter03;

import static org.testng.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 	需求 2 测试
 *	
 *	现在处理轮到哪个玩家落子的问题。
 *	需要提供一种途径，用于判断接下来该谁落子。
 *
 *	可将这个需求分成三个测试：
  1、玩家 X 先下；
  2、如果上一次是 X 下的，接下来将轮到 O 下；
  3、如果上一次是 O 下的，接下来将轮到 X 下。
 *
 *	在这里，我们需要比较两个字符，其中第一个是预期的字符，而第二个是方法 nextPlayer 返回的实际字符。
 *
 *	@author hzweiyongqiang
 */
public class Course4DevTicTacToe2Test {

	// 指定 ExpectedException 是一条规则
	// 如果这种异常是在实例化前引发的，这个测试将失败；反之，测试将成功。
	@Rule
	public ExpectedException exception = ExpectedException.none();	
	
	private Course4DevTicTacToe2 ticTacToe;
	
	
	/***    ----------需求一测试------------    ***/
	
	/**
	 * 	@Before 可用来标注要在每个测试前运行的方法
	 * 	可使用它实例化测试中使用的类，或者指定要在每个测试前执行的其他操作
	 */
	@Before
	public final void Before() {
		ticTacToe = new Course4DevTicTacToe2();
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

	/***    ----------需求二测试------------    ***/
	
	/**
	 * 	玩家X先下：
	 */
	@Test
	public void givenFirstTurnWhenNextPlayerThenX() {
		assertEquals('X', ticTacToe.nextPlayer());
	}
	
	/**
	 * 	如果上一次是 X 下的，接下来将轮到 O 下；
	 */
	@Test
	public void givenLastTurnWasXWhenNextPlayerThenO() {
		ticTacToe.play(1, 1);
		assertEquals('O', ticTacToe.nextPlayer());
	}
	
	/**
	 * 	如果上一次是 O 下的，接下来将轮到 X 下。
	 * 	即使什么都不用做，这个测试也能通过。因此它毫无用处，应当删除。
	 * 	【编写测试后，如果它在没有编写任何实现代码时就能通过，应将其删除。】
	 */
	@Test
	public void givenLastTurnWasOWhenNextPlayerThenX() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 2);
		assertEquals('X', ticTacToe.nextPlayer());
	}
}
