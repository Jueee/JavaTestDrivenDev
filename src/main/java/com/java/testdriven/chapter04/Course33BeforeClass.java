package com.java.testdriven.chapter04;

/**
 * 	注解 @BeforeClass 和 @AfterClass
 * 
 * 	
 * 	注解 @BeforeClass 和注解 @AfterClass 在JUnit和TestNG中的作用相同：
 * 	被注解的方法将分别在当前类中的所有测试运行之前和之后运行。
 * 
 * 	唯一的差别是，TestNG不要求这些方法是静态的。
 * 
 * 	原因是这两个框架运行测试方法的方式不同：
 * 	JUnit运行每个测试时都使用不同的测试类实例，因此要让这些方法可重用，必须将它们定义为静态的；
 * 	而TestNG在同一个测试类实例中运行所有测试，因此不需要将这些方法定义为静态的。
 *	
 *	@author hzweiyongqiang
 */
public class Course33BeforeClass {

}
