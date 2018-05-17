package com.java.testdriven.chapter04;

/**
 * 	注解 @BeforeSuite、 @BeforeTest、 @BeforeGroups、 @AfterGroups、 @AfterTest和 @AfterSuite
 *	
 *
 *	这6个注解都没有对应的JUnit注解。
 *
 *	TestNG可使用XML配置将测试编组为套件。
 *	使用 @BeforeSuite 和 @AfterSuite 注解的方法分别在指定套件中的所有测试运行之前和之后运行。
 *
 *	使用 @BeforeTest 和 @AfterTest 注解的方法分别在测试类中的每个测试运行之前和之后运行。
 *
 *	TestNG测试还可组织为编组，而注解 @BeforeGroups 和 @AfterGroups 让你能够在指定编组中的所有测试运行之前和之后运行某些方法。	
 *
 *	@author hzweiyongqiang
 */
public class Course32BeforeSuite {

}
