package com.java.testdriven.chapter08;

/**
 * 	消除状态的“基本类型偏执”坏味
 *	
 *
 *	“基本类型偏执”坏味指的是使用基本数据类型表示域概念。
 *	例如，使用字符串表示消息，使用整数表示金额，使用结构体/字典/散列表示对象。
 *
 *	@author hzweiyongqiang
 */
public class Course29RemoveObsession {

	/**
	 * 	一、States 是一个包含常量的 java 类，将其转换为枚举。
	 */
	/**
	 * 	二、对于 Book 类中的字段 status （现在为 ArrayList<States> ，使用 @XmlTransient 进行标记，因为它不会序列化为JSON。
	 */
}
