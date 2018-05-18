package com.java.testdriven.chapter06;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Test;

/**
 * 	模拟对象
 *	
 *
 *	模拟对象模拟实际对象（通常很复杂）的行为，让我们能够创建对象以替换实现代码中使用的实际对象。
 *
 *	模拟对象期望使用指定参数调用指定方法，以返回预期的结果，它预先知道应发生什么情况以及我们期望它做何反应。
 *
 *	@author hzweiyongqiang
 */
public class Course13MockObjects {
	
	class TicTacToeCollection{
		public boolean drop() {
			return false;
		}
	}
	
	/**
	 * 	创建一个返回默认值的模拟对象，然后指定它的一个方法应返回的值。
	 * 	自始至终都未使用实际对象。
	 */
	@Test
	public void demo() {
		// 将 collection 定义为一个可替换 TicTacToeCollection 的模拟对象
		// 此时这个模拟对象的所有方法都是伪造的（fake），在Mockito中意味着返回默认值。
		TicTacToeCollection collection = mock(TicTacToeCollection.class);
		
		// 确认断言方法 drop 返回 false 。
		assertThat(collection.drop()).isFalse();
		
		// 指定模拟对象 collection 应在其方法 drop 被调用时返回 true 。
		doReturn(true).when(collection).drop();
		
		// 断言方法 drop 返回 true 
		assertThat(collection.drop()).isTrue();
	}
}
