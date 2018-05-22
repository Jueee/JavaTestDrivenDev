package com.java.testdriven.chapter08;

/**
 * 	提取并重写调用
 * 
 *	
 *	@author hzweiyongqiang
 */
public class Course28Extract {
	/**
	 * 	任务一：将依赖注入BooksEndpoint
	 */
	public class Task1{
		/**
		 * 	一、参数化构造函数
		 * 	修改 BooksEndpoint 的代码，将 BooksRepository 作为构造参数传入。
		 */
		/**
		 * 	二、参数化构造函数
		 * 	修改启动器 MyApplication 的代码，将 BooksEndpoint 作为构造参数传入。
		 */
		/**
		 * 	三、
		 * 	创建一个测试，如：com.java.testdriven.chapter08.newalexandria.BooksEndpointInteractionTest 的 add_one_book() 方法
		 */
		/**
		 * 	四、
		 * 	运行测试，报错：
		 * 	Actual invocation has different arguments:
			booksRepository.add(
			    com.java.testdriven.chapter08.newalexandria.Book@1835727
			);
			-> at com.java.testdriven.chapter08.newalexandria.BooksEndpoint.addNewBook(BooksEndpoint.java:137)
		 *	
		 *	此时，在 Book 类中重写 equals 和 hashCode 方法。再次运行，报错解决。
		 */
	}
	

	/**
	 * 	任务二：将单个状态改为多个状态
	 *	给定一本图书，图书管理员想知道其完整的出借历史，以确定哪些图书更受欢迎。
	 *	@author hzweiyongqiang
	 */
	public class Task2{
		/**
		 * 	一、
		 * 	创建一个测试，如：com.java.testdriven.chapter08.newalexandria.BooksTest 的 should_search_for_any_past_state() 方法
		 */
		/**
		 * 	二、实现根据各种状态进行搜索的功能
		 * 	将 Book 类中的 int status; 升级更新为 ArrayList<Integer> status; 并修改相关方法。
		 * 	修改 Books 类的 filterByState 方法，升级为 getState 为 anyState。
		 */
	}
}
