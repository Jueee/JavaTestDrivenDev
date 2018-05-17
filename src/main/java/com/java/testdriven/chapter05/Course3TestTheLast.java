package com.java.testdriven.chapter05;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Pattern;

/**
 * 	完成 Connect4 实现后再测试
 *
 *	
 *	这是传统的开发方法，专注于解决问题而不是测试。
 *	有些人和公司对自动化测试的价值置若罔闻，而依赖用户执行用户验收测试。
 *	
 *	这种用户验收测试在受控环境（最好与生产环境完全相同）中重现真实场景，让用户执行大量不同的任务，以验证应用程序的正确性。
 *	如果有操作失败，代码就是不可接受的，因为它们破坏了某些功能，或不像预期的那样工作。
 *
 *	@author hzweiyongqiang
 */
public class Course3TestTheLast {

	/***    ----------需求 1------------
	 *		棋盘为7列6行，所有格子都是空的   ***/
	
	// 定义“空”的表示方式，并创建存储游戏数据的数据结构
	public enum Color{
		RED('R'), GREEN('G'), EMPTY(' ');
		private final char value;
		Color(char value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}
	
	private static final int COLUMNS = 7;
	
	private static final int ROWS = 6;
	
	private Color[][] board = new Color[COLUMNS][ROWS];
	
	public Course3TestTheLast() {
		for(Color[] column:board) {
			Arrays.fill(column, Color.EMPTY);
		}
	}

	/***    ----------需求 2------------
	 *		玩家从列顶放入碟片。如果整列都是空的，放入的碟片将落到底部。
	 *		在特定列中，后放入的碟片将叠在前面放入的碟片之上。   ***/
	
	// 需要考虑棋盘的边界，还需标出哪些位置被占据（使用 Color.RED 指出）。
	public void putDisc(int column) {
		if (column > 0 && column <= COLUMNS) {
			int numOfDiscs = getNumberOfDiscsInColumn(column - 1);
			if (numOfDiscs < ROWS) {
				board[column-1][numOfDiscs] = currentPlayer;
				printBoard();		// 4.打印
				checkWinCondition(column-1, numOfDiscs);// 6.检查获胜
				switchPlayer();		// 3.切换玩家
			} else {				// 4.打印
				System.out.println(numOfDiscs);
				System.out.println("There's no room for a new disc in this column");
				printBoard();
			}
		} else {					// 4.打印
			System.out.println("Column out of bounds");
			printBoard();
		}
	}
	// 计算在给定列放入多少个碟片
	private int getNumberOfDiscsInColumn(int column) {
		if (column >= 0 && column < COLUMNS) {
			int row;
			for (row = 0; row < ROWS; row++) {
				if (Color.EMPTY == board[column][row]) {
					return row;
				}
			}
			return row;
		}
		return -1;
	}

	/***    ----------需求 3------------
	 *		这是一款两人玩的游戏，每位玩家的碟片用一种颜色表示：
	 *		一位玩家为红色（'R'），另一位玩家为绿色（'G'）。
	 *		玩家轮流放入碟片，每次放入一个。   ***/
	
	// 保存当前玩家
	private Color currentPlayer = Color.RED;
	
	// 切换玩家的函数，以实现轮流逻辑。
	private void switchPlayer() {
		if (Color.RED == currentPlayer) {
			currentPlayer = Color.GREEN;
		} else {
			currentPlayer = Color.RED;
		}
		System.out.println("Current turn:" + currentPlayer);
	}

	/***    ----------需求 4------------
	 *		我们要在玩家放入碟片或发生错误时提供反馈：
	 *		每当玩家放入碟片后，都使用输出指出棋盘状态。   ***/
	
	private static final String DELIMITER = "|";
	
	// 输出棋盘状态
	public void printBoard() {
		for (int row = ROWS-1; row >=0 ; row--) {
			StringJoiner stringJoiner = new StringJoiner(DELIMITER,DELIMITER,DELIMITER);
			for(int col = 0;col<COLUMNS; ++ col) {
				stringJoiner.add(board[col][row].toString());
			}
			System.out.println(stringJoiner.toString());
		}
	}

	/***    ----------需求 5------------
	 *		无法再放入碟片时游戏结束，结果为平局。   ***/
	
	// 判断游戏是否结束
	public boolean isFinished() {
		if (winner != null) {	// 6.检查获胜
			return true;
		}
		int numOfDiscs = 0;
		for (int col = 0; col < COLUMNS; col++) {
			numOfDiscs += getNumberOfDiscsInColumn(col);
		}
		if (numOfDiscs >= COLUMNS * ROWS) {
			System.out.println("It's a draw");
			return true;
		}
		return false;
	}

	/***    ----------需求 6------------
	 *		玩家放入碟片后，如果将其3个以上碟片连成垂直线，该玩家将获胜。   ***/
	/***    ----------需求 7------------
	 *		玩家放入碟片后，如果将其3个以上碟片连成水平线，该玩家将获胜。   ***/
	/***    ----------需求 7------------
	 *		玩家放入碟片后，如果将其3个以上碟片连成对角线，该玩家将获胜。   ***/
	
	private Color winner;
	
	public static final int DISCS_FOUR_WIN = 4;
	
	/**
	 * 	检查获胜
	 *	@param col
	 *	@param row
	 */
	private void checkWinCondition(int col,int row) {
		Pattern winPattern = Pattern.compile(".*" + currentPlayer + "{" + DISCS_FOUR_WIN + "}.*");
		// 检查垂直方向
		StringJoiner stringJoiner = new StringJoiner("");
		for (int auxRow = 0; auxRow < ROWS; auxRow++) {
			stringJoiner.add(board[col][auxRow].toString());
		}
		if (winPattern.matcher(stringJoiner.toString()).matches()) {
			winner = currentPlayer;
			System.out.println(currentPlayer + " wins");
			return;
		}
		// 检查水平方向
		stringJoiner = new StringJoiner("");
		for (int column = 0; column < COLUMNS; ++column) {
			stringJoiner.add(board[column][row].toString());
		}
		if (winPattern.matcher(stringJoiner.toString()).matches()) {
			winner = currentPlayer;
			System.out.println(currentPlayer + " wins");
			return;
		}
		// 检查对角线方向(左上到右下)
		int startOffset = Math.min(col, row);
		int column = col - startOffset, auxRow = row - startOffset;
		stringJoiner = new StringJoiner("");
		do {
			stringJoiner.add(board[column++][auxRow++].toString());
		} while (column < COLUMNS && auxRow < ROWS);
		if (winPattern.matcher(stringJoiner.toString()).matches()) {
			winner = currentPlayer;
			System.out.println(currentPlayer + " wins");
			return;
		}
		// 检查对角线方向(左下到右上)
		startOffset = Math.min(col, ROWS - 1 - row);
		column = col - startOffset;
		auxRow = row + startOffset;
		stringJoiner = new StringJoiner("");
		do {
			stringJoiner.add(board[column++][auxRow--].toString());
		} while (column < COLUMNS && auxRow >= 0);
		if (winPattern.matcher(stringJoiner.toString()).matches()) {
			winner = currentPlayer;
			System.out.println(currentPlayer + " wins");
			return;
		}
	}
	
}
