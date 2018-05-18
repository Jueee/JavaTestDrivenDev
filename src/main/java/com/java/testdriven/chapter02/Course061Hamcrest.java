package com.java.testdriven.chapter02;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
/**
 * 	Hamcrest
 *	
 *	Hamcrest 添加了大量被称为“匹配器”的方法，其中每个匹配器都设计用于执行特定的比较操作。
 *	Hamcrest 的可扩展性很好，让你能够创建自定义匹配器。
 *	另外，JUnit 发布版包含 Hamcrest 的核心，提供了对 Hamcrest 的原生支持，这让你能够直接使用 Hamcrest。
 *
 *	不同于JUnit，Hamcrest几乎总是直接使用对象
 */
/**
 * 
Hamcrest的表达力强些。它提供的断言多得多，让我们能够避免一些样板式代码，同时让代码更容易理解、更具表达力。

核心：
    anything - 总是匹配,如果你不关心测试下的对象是什么是有用的
    describedAs - 添加一个定制的失败表述装饰器
    is - 改进可读性装饰器 - 见下 “Sugar”
逻辑：
    allOf - 如果所有匹配器都匹配才匹配,像Java里的&&
    anyOf - 如果任何匹配器匹配就匹配,像Java里的||
    not - 如果包装的匹配器不匹配器时匹配,反之亦然
对象：
    equalTo - 测试对象相等使用Object.equals方法
    hasToString - 测试Object.toString方法
    instanceOf, isCompatibleType - 测试类型
    notNullValue, nullValue - 测试null
    sameInstance - 测试对象实例
Beans：
    hasProperty - 测试JavaBeans属性
集合：
    array - 测试一个数组元素test an array’s elements against an array of matchers
    hasEntry, hasKey, hasValue - 测试一个Map包含一个实体,键或者值
    hasItem, hasItems - 测试一个集合包含一个元素
    hasItemInArray - 测试一个数组包含一个元素
数字：
    closeTo - 测试浮点值接近给定的值
    greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo - 测试次序
文本：
    equalToIgnoringCase - 测试字符串相等忽略大小写
    equalToIgnoringWhiteSpace - 测试字符串忽略空白
    containsString, endsWith, startsWith - 测试字符串匹配
 */
/**
 *	@author hzweiyongqiang
 */
public class Course061Hamcrest {
	
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
	
	@Test
	public void alexDoesNotHavaFriends() {
		assertThat(friendships.getFriendsList("Alex"), empty());
	}
	
	@Test
	public void joeHas5Friends() {
		assertThat(friendships.getFriendsList("Joe") , hasSize(5));
	}
	
	@Test
	public void joeIsFriendWithEveryOne() {
		assertThat(friendships.getFriendsList("Joe"), containsInAnyOrder("Audrey", "Peter", "Michael", "Britney", "Paul"));
	}
}
