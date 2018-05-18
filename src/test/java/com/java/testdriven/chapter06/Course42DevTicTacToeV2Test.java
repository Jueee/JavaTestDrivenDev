package com.java.testdriven.chapter06;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;

import com.java.testdriven.chapter03.Course4DevTicTacToeAllTest;

public class Course42DevTicTacToeV2Test extends Course4DevTicTacToeAllTest{

	Course42DevTicTacToeV2 ticTacToe;
	Course41DevTicTacToeV2 collection;
	
	@Before
	public void before() throws UnknownHostException {
		collection = mock(Course41DevTicTacToeV2.class);
		doReturn(true).when(collection).drop();
//		ticTacToe = new Course42DevTicTacToeV2();
		// 确保 saveMove 默认返回 true
		doReturn(true).when(collection).saveMove(any(TicTacToeBean.class));
		ticTacToe = new Course42DevTicTacToeV2(collection);
	}
	
	/**
	 * 	确保对其进行了实例化。
	 */
	@Test
	public void test() {
		assertNotNull(ticTacToe.getTicTacToeCollection());
	}

	/**
	 * 	每当玩家落子后，都需将这步棋保存到数据库。
	 */
	@Test
	public void whenPlayThenSaveMoveIsInvoked() {
		// 实例化一个 TicTacToeBean 对象，因为它包含集合期望的数据
		TicTacToeBean move = new TicTacToeBean(1, 1, 3, 'X');
		// 实际落子
		ticTacToe.play(move.getX(), move.getY());
		// 验证确实调用了方法 saveMove
		verify(collection).saveMove(move);
	}
	
	/**
	 * 	无法保存将下的棋时
	 * 	想在辅助方法 saveMove 返回 false 时引发异常。
	 */
	@Test
	public void whenPlayAndSaveReturnsFalseThenThrowException() {
		doReturn(false).when(collection).saveMove(any(TicTacToeBean.class));
		TicTacToeBean move = new TicTacToeBean(1, 1, 3, 'X');
		exception.expect(RuntimeException.class);
		ticTacToe.play(move.getX(), move.getY());
	}
	
	/**
	 * 	调用方法 play 两次，并验证轮次从 1 变成 2
	 */
	@Test
	public void whenPlayInvokedMultipleTimesThenTurnIncreases() {
		TicTacToeBean move1 = new TicTacToeBean(1, 1, 3, 'X');
		ticTacToe.play(move1.getX(), move1.getY());
		verify(collection,times(1)).saveMove(move1);
		
		TicTacToeBean move2 = new TicTacToeBean(2, 1, 2, 'O');
		ticTacToe.play(move2.getX(), move2.getY());
		verify(collection,times(1)).saveMove(move2);
	}
	
	/**
	 * 	每当实例化 TicTacToe 类时，都应调用方法 drop() 
	 */
	@Test
	public void whenInstantiatedThenCollectionDrop() {
		verify(collection,times(1)).drop();
	}

	
	/**
	 * 	确保  drop() 返回 false 时引发 RuntimeException 异常
	 * 	为不影响其他测试，需要在 @Before 中增加：doReturn(true).when(collection).drop();
	 */
	@Test
	public void whenInstantiatedAndDropReturnsFalseThenThrowException() {
		doReturn(false).when(collection).drop();
		exception.expect(RuntimeException.class);
		new Course42DevTicTacToeV2(collection);
	}
	
}
