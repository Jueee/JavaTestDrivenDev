#### 第 4 章：单元测试——专注于当下而非过往 ####
  
学习单元测试到底是什么、它与功能测试和集成测试有何不同以及它在测试驱动开发中扮演的角色。   

本章的主要目标是我们编写了大量辅助类，并尽量忽略其内部工作原理。  
很多情况下，我们编写规范时都没有验证最终结果是否正确，而检查待实现的方法是否调用了辅助类的正确方法。  

本章旨在让你学会如何专注于当前要开发的单元，并忽略或隔离已完成的单元。

##### 本章目录及程序实现 #####
1.	[单元测试](Course10UnitTesting.java)  
	1.1	[何为单元测试](Course11WhatUnitTesting.java)  
	1.2	[为何要进行单元测试](Course12WhyUnitTesting.java)  
	1.3	[代码重构](Course13CodeRefactor.java)  
	1.4	[为何不只使用单元测试](Course14NotExclusively.java)  
2.	[TDD 中的单元测试](Course2UnitTestingWithTDD.java)   
3.	[TestNG](Course30TestNG.java)  
	3.1	[注解 @Test](Course31Test.java)  
	3.2	[注解 @BeforeSuite、 @BeforeTest、 @BeforeGroups、 @AfterGroups、 @AfterTest和 @AfterSuite](Course32BeforeSuite.java)  
	3.3	[注解 @BeforeClass 和 @AfterClass](Course33BeforeClass.java)  
	3.4	[注解 @BeforeMethod 和 @AfterMethod](Course34BeforeMethod.java)  
	3.5	[注解参数 @Test(enable = false)](Course35Enable.java)  
	3.6	[注解参数 @Test(expectedExceptions = SomeClass.class)](Course36ExpectedExceptions.java)   
	3.7	[TestNG 和 JUnit 差别小结](Course37vsJUnit.java)   
4.	[“遥控军舰”的需求](Course4Ship.java)   
5.	[开发“遥控军舰”](Course5DevShipAll.java)&nbsp;&nbsp;&nbsp;[实现](Ship.java)   
	5.1	创建项目    
	5.2	辅助类   
	5.3	需求1  
	5.4	需求2  
	5.5	需求3  
	5.6	需求4  
	5.7	需求4  
	5.8	需求4  
    
##### 小结 #####
-	介绍如何每次专注于一个单元。进行单元测试时，应专注于当前的单元。 
-	学习使用测试框架TestNG。
-	开发“遥控军舰”应用程序，以充分展示TDD在单元测试中的威力。
