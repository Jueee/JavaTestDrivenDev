package com.java.testdriven.chapter02;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.java.testdriven.chapter02.Course080MockingFrameworks.FriendsCollection;
import com.java.testdriven.chapter02.Course080MockingFrameworks.FriendshipsMongo;
import com.java.testdriven.chapter02.Course080MockingFrameworks.Person;

/**
 * 	EasyMock
 *	
 *	EasyMock是另一种模拟框架，它与Mockito很像，主要差别在于EasyMock创建的不是间谍对象，而是模拟对象，其他差别都属于语法方面。
 *
 *	EasyMock的唯一劣势是需要添加额外的指令 replay ，让前面指定的期望生效。
 *
 *	@author hzweiyongqiang
 */
@RunWith(EasyMockRunner.class)
public class Course082EasyMock {
	
	Course080MockingFrameworks frameworks = new Course080MockingFrameworks();

	// 测试类中，需要使用 @TestSubject 标注受测类，以告诉 EasyMock 应将模拟对象注入哪个类。
	@TestSubject
	FriendshipsMongo friendships = frameworks.new FriendshipsMongo();
	
	// 需要指定要将这个类（ FriendshipsMongo ）中的哪些方法或对象替换为模拟对象：
	// 这个示例中，将模拟 FriendshipsMongo 类中的 FriendsCollection 
	// type值 NICE 让模拟对象返回空（null）。
	@Mock(type = MockType.NICE)
	FriendsCollection friends;
	
	@Test
	public void mockingWorksAsExpected() {
		Person joe = frameworks.new Person("Joe");
		EasyMock.expect(friends.findByName("Joe")).andReturn(joe);	// 指定 friends.findByName 应返回对象 joe 
		EasyMock.replay(friends);									// 让这个期望生效
		assertThat(friends.findByName("Joe")).isEqualTo(joe);		// 使用 assertThat 验证这种假设是正确的
	}
	
	@Test
	public void alexDoesNotHavaFriends() {
		assertThat(friendships.getFriendsList("Alex")).isEmpty();
	}
	
	@Test
	public void joeHas5Friends() {
		List<String> expected = Arrays.asList("Audrey", "Peter", "Michael", "Britney", "Paul");
		Person joe = EasyMock.createMock(Person.class);
		
		EasyMock.expect(friends.findByName("Joe")).andReturn(joe);
		EasyMock.expect(joe.getFriends()).andReturn(expected);
		EasyMock.replay(friends);
		EasyMock.replay(joe);
		
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Audrey", "Peter", "Michael", "Britney", "Paul");
	}
}
