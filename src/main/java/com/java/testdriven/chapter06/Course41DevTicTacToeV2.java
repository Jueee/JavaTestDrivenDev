package com.java.testdriven.chapter06;

import java.net.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;


/***    ----------需求 1------------
 *		实现一个保存单步棋——包含轮次、X和Y坐标以及玩家（X或O）——的选项。   ***/
public class Course41DevTicTacToeV2 {

	
	private MongoCollection mongoCollection;

	protected MongoCollection getMongoCollection() {
		return mongoCollection;
	}

	public Course41DevTicTacToeV2() throws UnknownHostException {
		DB db = new MongoClient().getDB("tic-tac-toe");
		this.mongoCollection = new Jongo(db).getCollection("game");
	}
	
	public boolean saveMove(TicTacToeBean bean) {
		try {
			getMongoCollection().save(bean);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 	删除整个MongoDB集合
	 * 	每次创建新实例时，都需重新开始，将数据库中存储的所有数据都删除。
	 */
	public boolean drop() {
		try {
			getMongoCollection().drop();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
