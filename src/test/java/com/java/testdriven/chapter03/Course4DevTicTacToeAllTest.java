package com.java.testdriven.chapter03;

import static org.testng.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Course4DevTicTacToeAllTest {

	// 指定 ExpectedException 是一条规则
	// 如果这种异常是在实例化前引发的，这个测试将失败；反之，测试将成功。
	@Rule
	public ExpectedException exception = ExpectedException.none();	
	
	private Course4DevTicTacToeAll ticTacToe;
	
	
	/***    ----------需求一测试------------    ***/
	
	/**
	 * 	@Before 可用来标注要在每个测试前运行的方法
	 * 	可使用它实例化测试中使用的类，或者指定要在每个测试前执行的其他操作
	 */
	@Before
	public final void Before() {
		ticTacToe = new Course4DevTicTacToeAll();
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


	/***    ----------需求三测试------------    ***/
	
	/**
	 * 	定义方法 play 的默认返回值：
	 */
	@Test
	public void whenPlayThenNoWinner() {
		String actual = ticTacToe.play(1, 1);
		assertEquals("No winner", actual);
	}
	
	/**
	 * 	一个玩家的棋子占据整条水平线就赢了。
	 */
	@Test
	public void whenPlayAndWholeHorizontalLineThenWinner() {
		ticTacToe.play(1, 1);	// X
		ticTacToe.play(1, 2);	// O
		ticTacToe.play(2, 1);	// X
		ticTacToe.play(2, 2);	// O
		String actual = ticTacToe.play(3, 1);	// X
		assertEquals("X is the winner", actual);
	}
	
	/**
	 * 	一个玩家的棋子占据整条垂直线就赢了。
	 */
	@Test
	public void whenPlayAndWholeVerticalLineThenWinner() {
		ticTacToe.play(2, 1);	// X
		ticTacToe.play(1, 1);	// O
		ticTacToe.play(3, 1);	// X
		ticTacToe.play(1, 2);	// O
		ticTacToe.play(2, 2);	// X
		String actual = ticTacToe.play(1, 3);	// O
		assertEquals("O is the winner", actual);
	}
	
	/**
	 * 	一个玩家的棋子占据从左上角到右下角的整条对角线就赢了。
	 */
	@Test
	public void whenPlayAndTopBottomDiagonalLineThenWinner() {
		ticTacToe.play(1, 1);	// X
		ticTacToe.play(2, 1);	// O
		ticTacToe.play(2, 2);	// X
		ticTacToe.play(2, 3);	// O
		String actual = ticTacToe.play(3, 3);	// X
		assertEquals("X is the winner", actual);
	}
	
	/**
	 * 	一个玩家的棋子占据从左下角到右上角的整条对角线就赢了。
	 */
	@Test
	public void whenPlayAndBottomTopDiagonalLineThenWinner() {
		ticTacToe.play(1, 3);	// X
		ticTacToe.play(2, 1);	// O
		ticTacToe.play(2, 2);	// X
		ticTacToe.play(2, 3);	// O
		String actual = ticTacToe.play(3, 1);	// X
		assertEquals("X is the winner", actual);
	}


	/***    ----------需求四测试------------    ***/
	@Test
	public void whenAllBoxesAreFilledThenDraw() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 2);
		ticTacToe.play(1, 3);
		ticTacToe.play(2, 1);
		ticTacToe.play(2, 3);
		ticTacToe.play(2, 2);
		ticTacToe.play(3, 1);
		ticTacToe.play(3, 3);
		String actual = ticTacToe.play(3, 2);
		assertEquals("The result is draw", actual);
	}

}
