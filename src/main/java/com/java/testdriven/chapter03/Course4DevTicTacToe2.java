package com.java.testdriven.chapter03;

/**
 * 	需求 2
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
public class Course4DevTicTacToe2 {

	/***    ----------需求一------------    ***/
	
	private Character[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};

	
	/**
	 * 	放置棋子
	 *	@param x
	 *	@param y
	 */
	public void play(int x,int y) {
		checkAxis(x);
		checkAxis(y);
		setBox(x, y);
		lastPlayer = nextPlayer();	// 记录下一次玩家
	}
	private void checkAxis(int axis) {
		if (axis < 1 || axis >3) {
			throw new RuntimeException("is outside board");
		}
	}
	private void setBox(int x,int y) {
		if (board[x-1][y-1] != '\0') {
			throw new RuntimeException("Box is occupied");
		} else {
			board[x-1][y-1] = 'X';
		}
	}
	
	/***    ----------需求二------------    ***/
	
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
}
