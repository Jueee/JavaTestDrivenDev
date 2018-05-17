#### 第 5 章：设计——难以测试说明设计不佳 ####
  
质量卓越的应用程序都设计良好，而良好的设计意味着可伸缩性、安全性、可维护性和众多其他优良品质。  

本章以传统方法和TDD方法开发同一款应用程序，以此探索TDD如何引导开发人员走向通往良好设计和最佳实践的道路。  

##### 本章目录及程序实现 #####
1.	[为何要关心设计](Course1CareDesign.java)  
2.	[Connect4](Course2Connect4.java)   
3.	[完成 Connect4 实现后再测试](Course3TestTheLast.java)  
	3.1	[注解 @Test](Course31Test.java)  
	3.2	[注解 @BeforeSuite、 @BeforeTest、 @BeforeGroups、 @AfterGroups、 @AfterTest和 @AfterSuite](Course32BeforeSuite.java)  
	3.3	[注解 @BeforeClass 和 @AfterClass](Course33BeforeClass.java)  
	3.4	[注解 @BeforeMethod 和 @AfterMethod](Course34BeforeMethod.java)  
	3.5	[注解参数 @Test(enable = false)](Course35Enable.java)  
	3.6	[注解参数 @Test(expectedExceptions = SomeClass.class)](Course36ExpectedExceptions.java)   
	3.7	[TestNG 和 JUnit 差别小结](Course37vsJUnit.java)   
4.	[“遥控军舰”的需求](Course4Ship.java)   
5.	[开发“遥控军舰”](Course5DevShipAll.java)&nbsp;&nbsp;&nbsp;[实现](Ship.java)   
    
##### 小结 #####
-	介绍如何每次专注于一个单元。进行单元测试时，应专注于当前的单元。 
-	学习使用测试框架TestNG。
-	开发“遥控军舰”应用程序，以充分展示TDD在单元测试中的威力。
