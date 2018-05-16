package com.java.testdriven.chapter03;

/**
 * 	最终版本
 * 	
 * 	重构 isWin,我们无需检查所有获胜条件，而只需检查与最后一个棋子的位置相关的获胜条件。
 *	
 *	@author hzweiyongqiang
 */
public class Course4DevTicTacToeAll {

	
	private Character[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};

	
	/**
	 * 	放置棋子
	 *	@param x
	 *	@param y
	 */
	public String play(int x,int y) {
		checkAxis(x);
		checkAxis(y);
		lastPlayer = nextPlayer();	// 记录下一次玩家
		setBox(x, y, lastPlayer);
		if (isWin(x, y)) {
			return lastPlayer + " is the winner";
		}
		if (isDraw()) {
			return "The result is draw";
		}
		return "No winner";
	}
	private void checkAxis(int axis) {
		if (axis < 1 || axis >3) {
			throw new RuntimeException("is outside board");
		}
	}
	/**
	 * 	下棋
	 *	@param x
	 *	@param y
	 *	@param lastPlayer
	 */
	private void setBox(int x,int y,char lastPlayer) {
		if (board[x-1][y-1] != '\0') {
			throw new RuntimeException("Box is occupied");
		} else {
			board[x-1][y-1] = lastPlayer;
		}
	}
	
	
	/**
	 * 	为跟踪接下来该谁下，需要存储前一次下棋的玩家：
	 */
	private char lastPlayer = '\0';
	
	public char nextPlayer() {
		// 如果前一次是玩家 X 下的，接下来应轮到玩家 O 。
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}
	
	
	private static final int SIZE = 3;
	/**
	 * 	检查获胜条件：只需检查与最后一个棋子的位置相关的获胜条件
	 *	@return
	 */
	private boolean isWin(int x,int y) {
		int playerTotal = lastPlayer*SIZE;
		char diagonal1 = '\0';	// 从左上角到右下角的整条对角线和
		char diagonal2 = '\0';	// 从左下角到右上角的整条对角线和
		char horizontal = '\0';	// 水平的和
		char vertical = '\0';	// 垂直的和
		for (int i = 0; i < SIZE; i++) {
			diagonal1 += board[i][i];
			diagonal2 += board[i][SIZE - i - 1];
			horizontal += board[i][y-1];
			vertical += board[x-1][i];
			
		}
		if (diagonal1 == playerTotal || diagonal2 == playerTotal || horizontal == playerTotal || vertical == playerTotal) {
			return true;
		}
		return false;
	}
	
	/**
	 * 	检查是否为平局非常简单——只需检查是否已占满整个棋盘。
	 *	@return
	 */
	public boolean isDraw() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j] == '\0') {
					return false;
				}
			}
		}
		return true;
	}
}
