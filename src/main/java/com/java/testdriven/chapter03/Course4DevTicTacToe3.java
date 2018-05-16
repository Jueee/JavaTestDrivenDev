package com.java.testdriven.chapter03;

/**
 * 	需求 3
 *	
 *	考虑这个游戏的获胜规则。
 *	我们必须检查所有可能获胜的情况，只要满足其中一个，就宣布相应玩家获胜。
 *	
 *	最先在水平、垂直或对角线上将自己的3个标记连起来的玩家获胜。
 *
 *
 *	@author hzweiyongqiang
 */
public class Course4DevTicTacToe3 {


	/***    ----------需求一------------    ***/
	
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
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == lastPlayer && board[1][i] == lastPlayer && board[2][i] == lastPlayer) {
				// 一个玩家的棋子占据整条水平线就赢了
				return lastPlayer + " is the winner";
			} else if (board[i][0] == lastPlayer && board[i][1] == lastPlayer && board[i][2] == lastPlayer) {
				// 一个玩家的棋子占据整条垂直线就赢了
				return lastPlayer + " is the winner";
			}
		}
		if (board[0][0] == lastPlayer && board[1][1] == lastPlayer && board[2][2] == lastPlayer) {
			// 一个玩家的棋子占据从左上角到右下角的整条对角线就赢了。
			return lastPlayer + " is the winner";
		}
		if (board[0][2] == lastPlayer && board[1][1] == lastPlayer && board[2][0] == lastPlayer) {
			// 一个玩家的棋子占据从左下角到右上角的整条对角线就赢了。
			return lastPlayer + " is the winner";
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
	
	/***    ----------需求三------------    ***/
	
	private static final int SIZE = 3;
	/**
	 * 	重构 play
	 *	@param x
	 *	@param y
	 *	@return
	 */
	public String play2(int x,int y) {
		checkAxis(x);
		checkAxis(y);
		lastPlayer = nextPlayer();	// 记录下一次玩家
		setBox(x, y, lastPlayer);
		if (isWin()) {
			return lastPlayer + " is the winner";
		}
		return "No winner";
	}
	/**
	 * 	检查获胜条件
	 *	@return
	 */
	private boolean isWin() {
		int playerTotal = lastPlayer*SIZE;
		char diagonal1 = '\0';	// 从左上角到右下角的整条对角线和
		char diagonal2 = '\0';	// 从左下角到右上角的整条对角线和
		for (int i = 0; i < SIZE; i++) {
			if ((board[0][i] + board[1][i] + board[2][i]) == playerTotal) {
				// 一个玩家的棋子占据整条水平线就赢了
				return true;
			} else if ((board[i][0] + board[i][1] + board[i][2]) == playerTotal) {
				// 一个玩家的棋子占据整条垂直线就赢了
				return true;
			}
			diagonal1 += board[i][i];
			diagonal2 += board[i][SIZE - i - 1];
		}
		if (diagonal1 == playerTotal || diagonal2 == playerTotal) {
			// 判断对角线
			return true;
		}
		return false;
	}
}
