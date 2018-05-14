package com.java.testdriven.chapter02;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 	TestNG
 *	
 *	TestNG（http://testng.org/doc/index.html）中，测试被组织成类，这与JUnit中完全相同。
 *
 *	测试类通常包含三个阶段：
 *	（1）准备
 *	准备工作可在类层面执行，也可在方法层面执行。
 *	注解 @BeforeClass 和 @BeforeMethod 常用于准备数据库数据、创建测试所需的文件等。
 *	注解 @BeforeClass 指定，方法只在执行类中的测试方法前执行一次，非常适合用于执行大部分乃至全部测试都要求的一般性准备工作。
 *	注解 @BeforeMethod 指定，方法将在每个测试方法前运行，可使用它准备测试数据，这样就不用担心后面运行的测试修改数据状态。
 *	（2）测试
 *	不同于JUnit，TestNG使用同一个测试类实例执行所有测试方法。
 *	这意味着测试方法默认不是彼此隔离的，因此编写测试前后执行的方法时需要更加小心。
 *	TestNG中，可在类层级设置注解 @Test ，将所有公有方法都转换为测试。
 *	与使用JUnit相比，唯一明显的差别是断言变量的排列顺序。
 *	JUnit断言中，参数依次为可选的消息、期望的值和实际值；而TestNG断言中，依次为实际值、期望的值和可选的消息。
 *	（3）清理
 *	注解 @AfterClass 指定的方法在所有测试都结束后运行一次，而注解 @AfterMethod 指定的方法在每个测试结束后都执行。
 *
 *	Eclipse 安装：Help->Eclipse Marketplace->搜索TestNG
 *
 *	@author hzweiyongqiang
 */
@Test
public class Course052TestNG {

	Course050UnitTesting friendships;

	@BeforeClass
	public static void beforeClass() {
		// 这个方法仅在初始化阶段执行一次
	}
	
	@BeforeMethod
	public void before() {
		friendships = new Course050UnitTesting();
		friendships.makeFriends("Joe", "Audrey");
		friendships.makeFriends("Joe", "Peter");
		friendships.makeFriends("Joe", "Michael");
		friendships.makeFriends("Joe", "Britney");
		friendships.makeFriends("Joe", "Paul");
	}
	
	public void alexDoesNotHavaFriends() {
		Assert.assertTrue(friendships.getFriendsList("Alex").isEmpty(),"Alex does not have friends");
	}

	public void joeHas5Friends() {
		Assert.assertEquals(5, friendships.getFriendsList("Joe").size(), "Joe has 5 friends");
	}

	public void joeIsFriendWithEveryOne() {
		List<String> friendsOfJoe = Arrays.asList("Audrey", "Peter", "Michael", "Britney", "Paul");
		Assert.assertTrue(friendships.getFriendsList("Joe").containsAll(friendsOfJoe));
	}
	
	@AfterClass
	public static void afterClass() {
		// 这个方法仅在所有测试都执行完毕后执行一次
	}
	
	@AfterMethod
	public void after() {
		// 这个方法在每个测试执行完毕后都执行
	}
}
