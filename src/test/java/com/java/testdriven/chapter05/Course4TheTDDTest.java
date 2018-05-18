package com.java.testdriven.chapter05;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 	我们将尽可能在测试中使用 Hamcrest 框架。
 *	
 *	Hamcrest 可提高测试的可读性。
 *	它使用匹配器降低复杂度，让断言的语义更明确、更容易理解。
 *	测试失败时，通过解读断言中使用的匹配器，更容易理解显示的错误。
 *
 *	@author hzweiyongqiang
 */
public class Course4TheTDDTest {

	/***    ----------需求 1------------
	 *		棋盘为7列6行，所有格子都是空的   ***/
	
	private Course4TheTDD test;
	
	@Before
	public void before() {
		output = new ByteArrayOutputStream();
		test = new Course4TheTDD(new PrintStream(output));
	}
	
	// 验证游戏开始时没有任何碟片
	@Test
	public void whenTheGameIsStartedTheBoardIsEmpty() {
		assertThat(test.getNumberOfDiscs(),is(0));
	}


	/***    ----------需求 2------------
	 *		玩家从列顶放入碟片。如果整列都是空的，放入的碟片将落到底部。
	 *		在特定列中，后放入的碟片将叠在前面放入的碟片之上。   ***/
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	// 如果碟片位于棋盘边界外，将引发运行阶段异常；
	@Test
	public void whenDiscOutsideBoardThenRuntimeException() {
		int column = -1;
		exception.expect(RuntimeException.class);
		exception.expectMessage("Invalid column " + column);
		test.putDiscInColumn(column);
	}
	// 如果碟片位于棋盘边界外，将引发运行阶段异常；
	@Test
	public void whenDiscOutsideBoardThenRuntimeException2() {
		int column = 7;
		exception.expect(RuntimeException.class);
		exception.expectMessage("Invalid column " + column);
		test.putDiscInColumn(column);
	}
	
	//   碟片被加入空列时，其位置为0；
	@Test
	public void whenFirstDiscInsertedInColumnThenPositionIsZero() {
		int column = 1;
		assertThat(test.putDiscInColumn(column), is(0));
	}
	
	// 碟片被加入已经有一个碟片的列时，其位置为1；
	@Test
	public void whenSecondDiscInsertedInColumnThenPositionIsOne() {
		int column = 1;
		test.putDiscInColumn(column);
		assertThat(test.putDiscInColumn(column), is(1));
	}
	
	// 每加入一个碟片，总碟片数都加1
	@Test
	public void whenDiscInsertedThenNumberOfDiscsIncreases() {
		int column = 1;
		test.putDiscInColumn(column);
		assertThat(test.getNumberOfDiscs(), is(1));
	}
	
	//  向已满的列中加入碟片时，将引发运行阶段异常。
	@Test
	public void whenNoMoreRoomInColumnThenRuntimeException() {
		int column = 1;
		int maxDiscsInColumn = 6; // the number of rows
		for(int times = 0; times< maxDiscsInColumn; ++ times) {
			test.putDiscInColumn(column);
		}
		exception.expect(RuntimeException.class);
		exception.expectMessage("No more room in column " + column);
		test.putDiscInColumn(column);
	}

	/***    ----------需求 3------------
	 *		这是一款两人玩的游戏，每位玩家的碟片用一种颜色表示：
	 *		一位玩家为红色（'R'），另一位玩家为绿色（'G'）。
	 *		玩家轮流放入碟片，每次放入一个。   ***/
	
	// 假定总是红方先来
	@Test
	public void whenFirstPlayerPlaysThenDiscColorIsRed() {
		assertThat(test.getCurrentPlayer(), is("R"));
	}
	// 验证第二个玩家
	@Test
	public void whenSecondPlayerPlaysThenDiscColorIsRed() {
		int column = 1;
		test.putDiscInColumn(column);
		assertThat(test.getCurrentPlayer(), is("G"));
	}
	

	/***    ----------需求 4------------
	 *		我们要在玩家放入碟片或发生错误时提供反馈：
	 *		每当玩家放入碟片后，都使用输出指出棋盘状态。   ***/
	
	// 为提高可测试性，我们需要在构造函数中新增一个参数。通过引入这个参数，输出测试将更容易：
	private OutputStream output;
	
	// 打印当前用户提示信息
	@Test
	public void whenAskedForCurrentPlayerTheOutputNotice() {
		test.getCurrentPlayer();
		assertThat(output.toString(), containsString("Player R turn"));
	}
	
	// 打印棋盘验证
	@Test
	public void whenADiscIsIntroducedTheBoardIsPrinted() {
		int column = 1;
		test.putDiscInColumn(column);
		assertThat(output.toString(), containsString("| |R| | | | | |"));
	}
	
	/***    ----------需求 5------------
	 *		无法再放入碟片时游戏结束，结果为平局。   ***/
	
	// 游戏刚开始时肯定未结束
	@Test
	public void whenTheGameStartsItIsNotFinished() {
		assertFalse("The game must not be finished", test.isFinished());
	}
	
	// 棋盘已满时必须结束
	@Test
	public void whenNoDiscCanBeIntroducedTheGamesIsFinished() {
		for (int row = 0; row < 6; row++) {
			for (int column = 0; column < 7; column++) {
				test.putDiscInColumn(column);
			}
		}
		assertTrue("The game must be finished",	test.isFinished());
	}

	/***    ----------需求 6------------
	 *		玩家放入碟片后，如果将其3个以上碟片连成垂直线，该玩家将获胜。   ***/
	
	// 如果当前加入的碟片与其他3个碟片连成一条垂直线，则当前玩家将获胜
	@Test
	public void when4VerticalDiscsAreConnectedThenPlayerWins() {
		for (int row = 0; row < 3; row++) {
			test.putDiscInColumn(1);	// R
			test.putDiscInColumn(2);	// G
		}
		assertThat(test.getWinner(), isEmptyString());
		test.putDiscInColumn(1);		// R
		assertThat(test.getWinner(), is("R"));
	}

	/***    ----------需求 7------------
	 *		玩家放入碟片后，如果将其3个以上碟片连成水平线，该玩家将获胜。   ***/

	// 在相邻的列中插入碟片以获胜
	@Test
	public void when4HorizontalDiscsAreConnectedThenPlayerWins() {
		int column;
		for (column = 0; column < 3; column++) {
			test.putDiscInColumn(column);	// R
			test.putDiscInColumn(column);	// G
		}
		assertThat(test.getWinner(), isEmptyString());
		test.putDiscInColumn(column);		// R
		assertThat(test.getWinner(), is("R"));
	}

	/***    ----------需求 8------------
	 *		玩家放入碟片后，如果将其3个以上碟片连成对角线，该玩家将获胜。   ***/
	
	// 从右上角到左下角的对角线
	@Test
	public void when4Diagonal1DiscsAreConnectedThenThatPlayerWins() {
		int[] gameplay = new int[] {1, 2, 2, 3, 4, 3, 3, 4, 4, 5, 4};
		for (int column : gameplay) {
			test.putDiscInColumn(column);
		}
		assertThat(test.getWinner(), is("R"));
	}
	// 从右下角到左上角的对角线
	@Test
	public void when4Diagonal2DiscsAreConnectedThenThatPlayerWins() {
		int[] gameplay = new int[] {3, 4, 2, 3, 2, 2, 1, 1, 1, 1};
		for (int column : gameplay) {
			test.putDiscInColumn(column);
		}
		assertThat(test.getWinner(), is("G"));
	}
}
