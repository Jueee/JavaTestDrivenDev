package com.java.testdriven.chapter05;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 	使用 TDD 实现 Connect4
 *	
 *
 *	TDD的工作原理：先编写测试，再编写实现，然后进行重构。
 *
 *	@author hzweiyongqiang
 */
public class Course4TheTDD {

	/***    ----------需求 1------------
	 *		棋盘为7列6行，所有格子都是空的   ***/

	/**
	 * 	返回总碟片数
	 *	@return
	 */
	public int getNumberOfDiscs() {
		return IntStream.range(0, COLUMNS)
						.map(this::getNumberOfDiscsInColumn)
						.sum();
	}
	


	/***    ----------需求 2------------
	 *		玩家从列顶放入碟片。如果整列都是空的，放入的碟片将落到底部。
	 *		在特定列中，后放入的碟片将叠在前面放入的碟片之上。   ***/
	
	private static final int ROWS = 6;
	
	private static final int COLUMNS = 7;
	
	private static final String EMPTY = " ";
	
	private String[][] board = new String[ROWS][COLUMNS];
	
	public Course4TheTDD() {
		for(String[] row:board) {
			Arrays.fill(row, EMPTY);
		}
	}
	
	/**
	 * 	当前列的碟片位置
	 *	@param column
	 *	@return
	 */
	public int putDiscInColumn(int column) {
		if (column < 0 || column >= COLUMNS) {
			throw new RuntimeException("Invalid column " + column);
		}
		int row = getNumberOfDiscsInColumn(column);
		checkPositionToInsert(row, column);
		board[row][column] = currentPlayer;
		printBoard();				// 4.打印棋盘
		checkWinner(row, column); 	// 5.检查获胜
		switchPlayer();				// 3.交换玩家
		return row;
	}
	
	private int getNumberOfDiscsInColumn(int column) {
		return (int) IntStream.range(0, ROWS)
							  .filter(row->!EMPTY.equals(board[row][column]))
							  .count();
	}
	
	private void checkPositionToInsert(int row,int column) {
		if (row == ROWS) {
			throw new RuntimeException("No more room in column "+column);
		}
	}

	/***    ----------需求 3------------
	 *		这是一款两人玩的游戏，每位玩家的碟片用一种颜色表示：
	 *		一位玩家为红色（'R'），另一位玩家为绿色（'G'）。
	 *		玩家轮流放入碟片，每次放入一个。   ***/
	
	private static final String RED = "R";
	
	private static final String GREEN = "G";
	
	private String currentPlayer = RED;
	
	public String getCurrentPlayer() {
		output.printf("Player %s turn%n",currentPlayer);
		return currentPlayer;
	}
	
	/**
	 * 	交换玩家
	 */
	public void switchPlayer() {
		if (RED.equals(currentPlayer)) {
			currentPlayer = GREEN;
		} else {
			currentPlayer = RED;
		}
	}

	/***    ----------需求 4------------
	 *		我们要在玩家放入碟片或发生错误时提供反馈：
	 *		每当玩家放入碟片后，都使用输出指出棋盘状态。   ***/
	
	private static final String DELIMITER = "|";
	
	// 通过引入这个参数，输出测试将更容易：
	private PrintStream output;
	
	public Course4TheTDD(PrintStream out) {
		this.output = out;
		for(String[] row:board) {
			Arrays.fill(row, EMPTY);
		}
	}
	
	/**
	 * 	打印棋盘
	 */
	private void printBoard() {
		for (int row = ROWS-1; row >= 0; row--) {
			StringJoiner stringJoiner = new StringJoiner(DELIMITER,DELIMITER,DELIMITER);
			Stream.of(board[row])
			 	  .forEachOrdered(stringJoiner::add);
			output.println(stringJoiner.toString());
		}
	}
	

	/***    ----------需求 5------------
	 *		无法再放入碟片时游戏结束，结果为平局。   ***/
	
	
	public boolean isFinished() {
		return getNumberOfDiscs() == ROWS * COLUMNS;
	}

	
	/***    ----------需求 6------------
	 *		玩家放入碟片后，如果将其3个以上碟片连成垂直线，该玩家将获胜。   ***/
	

	/***    ----------需求 7------------
	 *		玩家放入碟片后，如果将其3个以上碟片连成水平线，该玩家将获胜。   ***/


	/***    ----------需求 8------------
	 *		玩家放入碟片后，如果将其3个以上碟片连成对角线，该玩家将获胜。   ***/
	
	private static final int DISCS_TO_WIN = 4;
	
	private String winner = "";

	public String getWinner() {
		return winner;
	}

	private void checkWinner(int row,int column) {
		String colour = board[row][column];
		Pattern winPattern = Pattern.compile(".*" + currentPlayer + "{" + DISCS_TO_WIN + "}.*");
		
		// 检查垂直方向
		if (winner.isEmpty()) {
			String vertical = IntStream.range(0, ROWS)
									   .mapToObj(r->board[r][column])
									   .reduce(String::concat)
									   .get();
			if (winPattern.matcher(vertical).matches()) {
				winner = colour;
			}
		}
		
		// 检查水平方向
		if (winner.isEmpty()) {
			String horizontal = Stream.of(board[row])
									  .reduce(String::concat)
									  .get();
			if (winPattern.matcher(horizontal).matches()) {
				winner = colour;
			}
		}
		
		// 从右上角到左下角的对角线
		if (winner.isEmpty()) {
			int startOffset = Math.min(column, row);
			int myColumn = column - startOffset, myRow = row - startOffset;
			StringJoiner stringJoiner = new StringJoiner("");
			do {
				stringJoiner.add(board[myRow++][myColumn++].toString());
			} while (myColumn < COLUMNS && myRow < ROWS);
			if (winPattern.matcher(stringJoiner.toString()).matches()) {
				winner = colour;
			}
		}
		
		// 从右下角到左上角的对角线
		if (winner.isEmpty()) {
			int startOffset = Math.min(column, ROWS - 1 - row);
			int myColumn = column - startOffset, myRow = row + startOffset;
			StringJoiner stringJoiner = new StringJoiner("");
			do {
				stringJoiner.add(board[myRow--][myColumn++].toString());
			} while (myColumn < COLUMNS && myRow >= 0);
			if (winPattern.matcher(stringJoiner.toString()).matches()) {
				winner = colour;
			}
		}
	}
}
