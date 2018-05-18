package com.java.testdriven.chapter02;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.java.testdriven.chapter02.Course080MockingFrameworks.FriendsCollection;
import com.java.testdriven.chapter02.Course080MockingFrameworks.FriendshipsMongo;
import com.java.testdriven.chapter02.Course080MockingFrameworks.Person;

/**
 * 	Mockito
 *	
 *	Mockito这个Java框架让你能够轻松创建测试替身。
 *
 *	Mockito是通过JUnit运行器运行的，它替我们创建所有必需的模拟对象，并将其注入包含测试的类。
 *
 *	有两种基本方法：
 *	1、手工实例化模拟对象，并通过类构造函数将它们作为类依赖项注入；
 *	2、使用一系列注解。
 *
 *	Mockito-初始化的方法有2种：
 *	1、在Junit的类上面使用@RunWith(MockitoJUnitRunner.class)注解。
 *	2、在测试方法被调用之前，使用MockitoAnnotations.initMocks(this);。例如：
    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }
    
 *	@author hzweiyongqiang
 */

// 要让一个类能够使用Mockito注解，必须使用 MockitoJUnitRunner 运行。
@RunWith(MockitoJUnitRunner.class)
public class Course081Mockito {
	
	Course080MockingFrameworks frameworks = new Course080MockingFrameworks();

	// 测试类中，需要使用 @InjectMocks 标注受测类，以告诉Mockito应将模拟对象注入哪个类。
	@InjectMocks
	FriendshipsMongo friendships = frameworks.new FriendshipsMongo();;
	
	// 需要指定要将这个类（ FriendshipsMongo ）中的哪些方法或对象替换为模拟对象：
	// 这个示例中，将模拟 FriendshipsMongo 类中的 FriendsCollection 
	@Mock
	FriendsCollection friends;
	
//	@Before
//	public void before() {
//		MockitoAnnotations.initMocks(this);
//	}
	
	@Test
	public void mockingWorksAsExpected() {
		Person joe = frameworks.new Person("Joe");
		doReturn(joe).when(friends).findByName("Joe");			// 让Mockito在 friends.findByName("joe") 被调用时返回对象 joe
		assertThat(friends.findByName("Joe")).isEqualTo(joe);	// 使用 assertThat 验证这种假设是正确的
	}
	
	@Test
	public void alexDoesNotHavaFriends() {
		assertThat(friendships.getFriendsList("Alex")).isEmpty();
	}
	
	@Test
	public void joeHas5Friends() {
		List<String> expected = Arrays.asList("Audrey", "Peter", "Michael", "Britney", "Paul");
		Person joe = spy(frameworks.new Person("Joe"));
		doReturn(joe).when(friends).findByName("Joe");
		doReturn(expected).when(joe).getFriends();
		assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Audrey", "Peter", "Michael", "Britney", "Paul");
	}
	
	@Test
	public void test1() {
		doReturn(frameworks.new Person("Joe")).when(friends).findByName(anyString());
		assertThat(friendships.getFriendsList("Joe")).isEmpty();
	}
	
	@Test
	public void test2() {
		Person joe = frameworks.new Person("Joe");
        doReturn(joe).when(friends).findByName("Joe");

        Person audrey = frameworks.new Person("Audrey");
        doReturn(audrey).when(friends).findByName("Audrey");

        doNothing().when(friends).save(any(Person.class));

        friendships.makeFriends("Joe", "Audrey");

        assertThat(friendships.areFriends("Joe", "Audrey")).isTrue();
        assertThat(friendships.areFriends("Audrey", "Joe")).isTrue();

        assertThat(friendships.getFriendsList("Joe")).hasSize(1).contains("Audrey");

        assertThat(friendships.getFriendsList("Audrey")).hasSize(1).contains("Joe");
	}

    @Test(timeout = 500)
    public void test3() {
        Person joe = frameworks.new Person("Joe");
        doReturn(joe).when(friends).findByName("Joe");

        doNothing().when(friends).save(any(Person.class));

        friendships.makeFriends("Joe", "Audrey");
        friendships.makeFriends("Joe", "Peter");
        friendships.makeFriends("Joe", "Michael");
        friendships.makeFriends("Joe", "Britney");
        friendships.makeFriends("Joe", "Paul");

        assertThat(friendships.areFriends("Joe", "Paul")).isTrue();
        assertThat(friendships.areFriends("Audrey", "Ralph")).isFalse();

        assertThat(friendships.getFriendsList("Joe")).containsOnly("Audrey", "Peter", "Michael", "Britney", "Paul");
    }
}
