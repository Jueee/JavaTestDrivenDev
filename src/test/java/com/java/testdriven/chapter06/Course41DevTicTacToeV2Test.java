package com.java.testdriven.chapter06;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.UnknownHostException;

import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.MongoException;


/***    ----------需求 1------------
 *		实现一个保存单步棋——包含轮次、X和Y坐标以及玩家（X或O）——的选项。   ***/
public class Course41DevTicTacToeV2Test {
	
	Course41DevTicTacToeV2 collection;
	TicTacToeBean bean;
	MongoCollection mongoCollection;
	
	@Before
	public void before() throws UnknownHostException {
		// 将 TicTacToeCollection 对象替换为间谍
		collection = spy(new Course41DevTicTacToeV2());
		bean = new TicTacToeBean(3, 2, 1, 'Y');
		mongoCollection = mock(MongoCollection.class);	// 创建一个模拟对象
	}

	/**
	 * 	规范将使用的数据库名称
	 */
	@Test
	public void whenInstantiatedThenMongoHasDbNameTicTacToe() {
		assertEquals("tic-tac-toe", collection.getMongoCollection().getDBCollection().getDB().getName());
	}

	/**
	 * 	指定将使用的Mongo集合的名称
	 */
	@Test
	public void whenInstantiatedThenMongoCollectionHasNameGame() {
		assertEquals("game", collection.getMongoCollection().getName());
	}
	
	/**
	 * 	确保存储进 MongoDB，且只调用了一次有效记录。
	 */
	@Test
	public void whenSaveMoveThenInvokeMongoCollectionSave() {
		doReturn(mongoCollection).when(collection).getMongoCollection();
		collection.saveMove(bean);
		verify(mongoCollection,times(1)).save(bean);	// 验证是否正确调用了 Jongo 库，且只调用了1次
	}
	
	/**
	 * 	将方法 saveMove 的返回类型改为布尔值。
	 */
	@Test
	public void whenSaveMoveThenReturnTrue() {
		doReturn(mongoCollection).when(collection).getMongoCollection();
		assertTrue(collection.saveMove(bean));
	}
	
	/**
	 * 	处理使用MongoDB时可能出错的问题。
	 */
	@Test
	public void givenExceptionWhenSaveMoveThenReturnFalse() {
		doThrow(new MongoException("Bla")).when(mongoCollection).save(any(TicTacToeBean.class));
		doReturn(mongoCollection).when(collection).getMongoCollection();
		assertFalse(collection.saveMove(bean));
	}
	
	/**
	 * 	将数据库中存储的所有数据都删除
	 */
	@Test
	public void whenDropThenInvokeMongoCollectionDrop() {
		doReturn(mongoCollection).when(collection).getMongoCollection();
		collection.drop();
		verify(mongoCollection).drop();
	}
	
	/**
	 * 	确保方法 drop 在正常情况下返回 true 
	 */
	@Test
	public void whenDropThenReturnTrue() {
		doReturn(mongoCollection).when(collection).getMongoCollection();
		assertTrue(collection.drop());
	}
	
	/**
	 * 	确保方法 drop 在发生异常时返回 false ：
	 */
	@Test
	public void givenExceptionWhenDropThenReturnFalse() {
		doThrow(new MongoException("Bla")).when(mongoCollection).drop();
		doReturn(mongoCollection).when(collection).getMongoCollection();
		assertTrue(collection.drop());
	}
	
}
