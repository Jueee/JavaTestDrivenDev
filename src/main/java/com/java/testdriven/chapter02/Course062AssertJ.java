package com.java.testdriven.chapter02;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * 	AssertJ
 *	
 *	AssertJ 的工作原理与Hamcrest类似，一个重要的差别是AssertJ断言是可以串接的。
 *	AssertJ 断言的可读性更强，也更容易理解。
 *
 *	@author hzweiyongqiang
 */
public class Course062AssertJ {

	Course050UnitTesting friendships;
	
	@Before
	public void before() {
		friendships = new Course050UnitTesting();
		friendships.makeFriends("Joe", "Audrey");
		friendships.makeFriends("Joe", "Peter");
		friendships.makeFriends("Joe", "Michael");
		friendships.makeFriends("Joe", "Britney");
		friendships.makeFriends("Joe", "Paul");
	}
	
	/**
	 * 	JUnit 断言
	 */
	@Test
	public void joeHas5FriendsByJUnit() {
		assertEquals(5, friendships.getFriendsList("Joe").size());
		
		List<String> friendsOfJoe = Arrays.asList("Audrey", "Peter", "Michael", "Britney", "Paul");
		assertTrue(friendships.getFriendsList("Joe").containsAll(friendsOfJoe));
	}
	
	/**
	 * 	AssertJ中，可将这两个断言串接成一个：
	 */
	@Test
	public void joeHas5FriendsByAssertJ() {
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Audrey", "Peter", "Michael", "Britney", "Paul");
	}


	/**
	 * 	AssertJ 断言
	 */
	@Test
	public void test1() {
		assertThat(friendships.getFriendsList("Alex").isEmpty());
	}
	@Test
	public void test2() {
		assertThat(friendships.areFriends("Joe", "Audrey")).isTrue();
		assertThat(friendships.areFriends("Audrey", "Joe")).isTrue();
		
		assertThat(friendships.areFriends("Joe", "Paul")).isTrue();
        assertThat(friendships.areFriends("Audrey", "Ralph")).isFalse();
	}
}
