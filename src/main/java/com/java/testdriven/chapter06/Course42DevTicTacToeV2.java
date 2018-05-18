package com.java.testdriven.chapter06;

import java.net.UnknownHostException;

import com.java.testdriven.chapter03.Course4DevTicTacToeAll;

/***    ----------需求 2------------
 *		实现一个保存单步棋——包含轮次、X和Y坐标以及玩家（X或O）——的选项。   ***/
public class Course42DevTicTacToeV2 extends Course4DevTicTacToeAll{

	
	private Course41DevTicTacToeV2 ticTacToeCollection;

	public Course41DevTicTacToeV2 getTicTacToeCollection() {
		return ticTacToeCollection;
	}

	public Course42DevTicTacToeV2() throws UnknownHostException {
		this(new Course41DevTicTacToeV2());
	}
	
	/**
	 * 	通过参数传入一个对象。
	 * 	这将在规范内部派上用场——使用它轻松传入模拟的集合。
	 * 	@param collection
	 */
	public Course42DevTicTacToeV2(Course41DevTicTacToeV2 collection) {
		ticTacToeCollection = collection;
		boolean isDrop = ticTacToeCollection.drop();
		if (!isDrop) {
			throw new RuntimeException("Dropping DB collection failed");
		}
	}
	

	/**
	 * 	下棋
	 * 	通过 对象 TicTacToeBean 代替原有方法参数
	 *	@param x
	 *	@param y
	 *	@param lastPlayer
	 */
	private void setBox(TicTacToeBean bean) {
		if (board[bean.getX()-1][bean.getY()-1] != '\0') {
			throw new RuntimeException("Box is occupied");
		} else {
			board[bean.getX()-1][bean.getY()-1] = lastPlayer;
			boolean isSuccess = getTicTacToeCollection().saveMove(bean);	// 保存
			if (!isSuccess) {
				throw new RuntimeException("Saving to DB failed");
			}
		}
	}
	/**
	 * 	放置棋子
	 * 	由于方法 play 调用了 setBox ，我们需要在其中实例化 bean 
	 *	@param x
	 *	@param y
	 */
	public String play(int x,int y) {
		checkAxis(x);
		checkAxis(y);
		lastPlayer = nextPlayer();	// 记录下一次玩家
//		setBox(x, y, lastPlayer);
		setBox(new TicTacToeBean(++turn, x, y, lastPlayer));	// 将轮次设置成常量 1 。
		if (isWin(x, y)) {
			return lastPlayer + " is the winner";
		}
		if (isDraw()) {
			return "The result is draw";
		}
		return "No winner";
	}
	
	// 轮次
	private int turn = 0;
}
