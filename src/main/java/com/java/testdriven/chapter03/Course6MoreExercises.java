package com.java.testdriven.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 	更多练习
 *	
 *	通过实现AI让计算机充当玩家O。
 *
 *	由于“井字游戏”通常以平局告终，因此你只要实现这样的AI即可，即不管玩家X怎么走都至少能打成平局。
 *
 *	@author hzweiyongqiang
 */
public class Course6MoreExercises{
	
	private static final int BOX_SIZE = 3;
	
	List<String> getBoxList(){
		List<String> boxList = new ArrayList<String>();
		for (int i = 1; i <= BOX_SIZE; i++) {
			for (int j = 1; j <= BOX_SIZE; j++) {
				boxList.add(i+","+j);
			}
		}
		return boxList;
	}

	public String nextGamer(String nowGamer) {
		return nowGamer.equals("X")?"O":"X";
	}
	
	public String getRandomBox() {
		Random rand = new Random();
		Integer xRandom = rand.nextInt(3)+1;
		Integer yRandom = rand.nextInt(3)+1;
		return xRandom+","+yRandom;
	}
	
	public String oneSetBox(Course4DevTicTacToeAll game,String nowGamer,List<String> boxList) {
		String boxInfo = boxList.get(new Random().nextInt(boxList.size()));
		String[] randomBox = boxInfo.split(",");
		Integer xRandom = Integer.valueOf(randomBox[0]);
		Integer yRandom = Integer.valueOf(randomBox[1]);
		boxList.remove(boxInfo);
		String actual = game.play(xRandom, yRandom);
//		if (!actual.equals("No winner")) {
			System.out.println("[Gamer]"+nowGamer+"\t[X]"+xRandom+"\t[Y]"+yRandom+"\t[Result]"+actual);
//		}
		return actual;
	}
	
	public void startGame(Course4DevTicTacToeAll game) {
		String nowGamer = "X";
		String actual = "";
		List<String> boxList = getBoxList();
		do {
			actual = oneSetBox(game,nowGamer,boxList);
			nowGamer = nextGamer(nowGamer);
		} while (actual.equals("No winner"));
	}
	
	public static void main(String[] args) {
		Course6MoreExercises exercises = new Course6MoreExercises();
		for (int i = 0; i < 100; i++) {
			Course4DevTicTacToeAll game = new Course4DevTicTacToeAll();
			exercises.startGame(game);
		}
		
	}
}
