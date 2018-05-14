package com.java.testdriven.chapter02;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.marshall.jackson.oid.Id;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * 	模拟框架
 *	
 *	模拟对象是可用于替代实际对象的仿真对象，在依赖的外部资源不可用时很有用。
 *
 *	可使用模拟对象提高开发和测试的速度，仅在进入运行阶段后才使用真正的数据库连接。
 *	你不用花时间建立数据库和准备测试数据，而是专注于编写类，等到集成阶段再考虑这些问题。
 *
 *	@author hzweiyongqiang
 */
public class Course080MockingFrameworks {

	public class Person{
		@Id
		private String name;
		
		private List<String> friends;
		
		public Person() {}
		
		public Person(String name) {
			this.name = name;
			friends = new ArrayList<String>();
		}
		
		public List<String> getFriends(){
			return friends;
		}
		
		public void addFriend(String friend) {
			if (!friends.contains(friend)) {
				friends.add(friend);
			}
		}
	}
	
	public class FriendsCollection{
		private MongoCollection friends;
		
		public FriendsCollection() {
			try {
				DB db = new MongoClient().getDB("friendships");
				friends = new Jongo(db).getCollection("friends");
			} catch (UnknownHostException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		public Person findByName(String name) {
			return friends.findOne("{_id:#}", name).as(Person.class);
		}
		
		public void save(Person p) {
			friends.save(p);
		}
	}
	
	public class FriendshipsMongo{
		private FriendsCollection friends;
		
		public FriendshipsMongo() {
			friends = new FriendsCollection();
		}
		public void makeFriends(String person1,String person2) {
			addFriends(person1, person2);
			addFriends(person2, person1);
		}
		
		public List<String> getFriendsList(String person){
			Person p = friends.findByName(person);
			if (p == null) {
				return Collections.emptyList();
			}
			return p.getFriends();
		}
		
		public boolean areFriends(String person1, String person2) {
			Person p = friends.findByName(person1);
			return p!=null && p.getFriends().contains(person2);
		}
		
		private void addFriends(String person, String friend) {
			Person p = friends.findByName(person);
			if (p == null) {
				p = new Person(person);
			}
			p.addFriend(friend);
			friends.save(p);
		}
	}
}
