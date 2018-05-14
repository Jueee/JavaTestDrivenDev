package com.java.testdriven.chapter02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 	JUnit
 *	
 *	JUnit（http://junit.org/）是一个用于编写和运行测试的框架，简单易学。
 *	每个测试都是一个方法，包含特定场景下将执行的部分代码。
 *	比较预期输出（行为）和实际输出（行为），以实现代码验证。
 *
 *	测试类通常包含三个阶段：
 *	（1）准备
 *	准备工作可在类层面执行，也可在方法层面执行。
 *	注解 @Before 和 @BeforeClass 常用于准备数据库数据、创建测试所需的文件等。
 *	注解 @BeforeClass 指定，方法只在执行类中的测试方法前执行一次，非常适合用于执行大部分乃至全部测试都要求的一般性准备工作。
 *	注解 @Before 指定，方法将在每个测试方法前运行，可使用它准备测试数据，这样就不用担心后面运行的测试修改数据状态。
 *	（2）测试
 *	通过注解 @Test 进行方法的测试。
 *	（3）清理
 *	注解 @AfterClass 指定的方法在所有测试都结束后运行一次，而注解 @After 指定的方法在每个测试结束后都执行。
 *
 *
 *	@author hzweiyongqiang
 */
public class Course051JUnit {

	Course050UnitTesting friendships;
	
	@BeforeClass
	public static void beforeClass() {
		// 这个方法仅在初始化阶段执行一次
	}
	
	@Before
	public void before() {
		friendships = new Course050UnitTesting();
		friendships.makeFriends("Joe", "Audrey");
		friendships.makeFriends("Joe", "Peter");
		friendships.makeFriends("Joe", "Michael");
		friendships.makeFriends("Joe", "Britney");
		friendships.makeFriends("Joe", "Paul");
	}
	
	@Test
	public void alexDoesNotHavaFriends() {
		assertTrue("Alex does not have friends", friendships.getFriendsList("Alex").isEmpty());
	}
	
	@Test
	public void joeHas5Friends() {
		assertEquals("Joe has 5 friends", 5, friendships.getFriendsList("Joe").size());
	}
	
	@Test
	public void joeIsFriendWithEveryOne() {
		List<String> friendsOfJoe = Arrays.asList("Audrey", "Peter", "Michael", "Britney", "Paul");
		assertTrue(friendships.getFriendsList("Joe").containsAll(friendsOfJoe));
	}
	
	@AfterClass
	public static void afterClass() {
		// 这个方法仅在所有测试都执行完毕后执行一次
	}
	
	@After
	public void after() {
		// 这个方法在每个测试执行完毕后都执行
	}
}
