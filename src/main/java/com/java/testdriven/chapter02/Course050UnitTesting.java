package com.java.testdriven.chapter02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 	单元测试框架
 *	
 *	单元测试旨在对一小块代码进行测试。
 *
 *	测试是一个可重复的过程或方法，用于验证受测对象在指定环境下的行为是否正确，即向它提供指定的输入，并期望出现预定的输出或交互。
 *
 *	@author hzweiyongqiang
 */
public class Course050UnitTesting {
	/**
	 * 	看看如何测试一个Java类
	 */
	private final Map<String, List<String>> friendships = new HashMap<String, List<String>>();
	
	public void makeFriends(String person1,String person2) {
		addFriends(person1, person2);
		addFriends(person2, person1);
	}
	
	public List<String> getFriendsList(String person){
		if (!friendships.containsKey(person)) {
			return Collections.emptyList();
		}
		return friendships.get(person);
	}
	
	public boolean areFriends(String person1, String person2) {
		return friendships.containsKey(person1) && friendships.get(person1).contains(person2);
	}
	
	private void addFriends(String person, String friend) {
		if (!friendships.containsKey(person)) {
			friendships.put(person, new ArrayList<String>());
		}
		List<String> friends = friendships.get(person);
		if (!friends.contains(friend)) {
			friends.add(friend);
		}
	}
}
