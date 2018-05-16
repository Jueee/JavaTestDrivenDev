package com.java.testdriven.chapter03;

/**
 * 	需求 1
 * 
 * 	首先定义边界，以及将棋子放在哪些地方非法：可将棋子放在3×3棋盘上任何没有棋子的地方。
 * 	可将这个需求分成三个测试：
  1、如果棋子放在超出了X轴边界的地方，就引发 RuntimeException 异常；
  2、如果棋子放在超出了Y轴边界的地方，就引发 RuntimeException 异常；
  3、如果棋子放在已经有棋子的地方，就引发 RuntimeException 异常。
 *	
 *	@author hzweiyongqiang
 */
public class Course4DevTicTacToe1 {
	
	// 为实现最后一个测试，应将既有棋子的位置存储在一个数组中。
	private Character[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};

	/**
	 * 	放置棋子
	 *	@param x
	 *	@param y
	 */
	public void play(int x,int y) {
		if (x < 1 || x > 3) {
			// 如果棋子放在超出了X轴边界的地方，就引发 RuntimeException 异常；
			throw new RuntimeException("X is outside board");
		} else if (y < 1 || y > 3) {
			// 如果棋子放在超出了Y轴边界的地方，就引发 RuntimeException 异常；
			throw new RuntimeException("Y is outside board");
		}
		// 检查要放置棋子的位置是否被占用
		if (board[x-1][y-1] != '\0') {
			// 如果棋子放在已经有棋子的地方，就引发 RuntimeException 异常。
			throw new RuntimeException("Box is occupied");
		} else {
			// 如果未占用，就将相应数组元素的值从空（\0）改为被占用（X）。
			// 注意，我们还没有记录棋子是谁（X还是O）的。
			board[x-1][y-1] = 'X';
		}
	}
	
	
	/**
	 * 	重构 play 方法
	 * 	这个重构过程中，没有改变方法 play 的功能，其行为与以前完全相同，但代码的可读性更强了。
	 *	@param x
	 *	@param y
	 */
	public void play2(int x,int y) {
		checkAxis(x);
		checkAxis(y);
		setBox(x, y);
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
}
