package com.java.testdriven.chapter06;

/**
 * 	Mockito
 *	
 *
 *	Mockito是一个模拟框架，其API简单而整洁。
 *
 *	使用Mockito生成的测试直观而易于理解，它提供了三个主要的静态方法：
 *	1、 mock() ：用于创建模拟对象，还可使用 when() 和 given() 指定这些模拟对象的行为。
 *	2、 spy() ：可用于实现部分模拟。
 *	除非另有说明，否则间谍对象调用实际方法。
 *	与模拟对象一样，对于间谍对象的每个公有或受保护的方法（静态方法除外），都可设置其行为。
 *	主要差别在于， mock() 创建一个完全伪造的对象，而 spy() 使用实际对象。
 *	3、 verify() ：用于检查调用方法时提供的是否是指定参数，这是一种断言。
 *
 *	@author hzweiyongqiang
 */
public class Course2Mockito {

}
