# JavaTestDrivenDev
《Java 测试驱动开发》学习笔记
##### 所用书籍 #####
Farcic, Viktor, and Alex Garcia. Test-Driven Java Development. Packt Publishing Ltd, 2015. [Git](https://bitbucket.org/vfarcic)
### 本书目录及程序实现 ###
 - 一、[为何要关心测试驱动开发](src/main/java/com/java/testdriven/chapter01)
    1. [为何要使用 TDD](src/main/java/com/java/testdriven/chapter01/Course10WhyTDD.java)  
    	1.1	[理解 TDD](src/main/java/com/java/testdriven/chapter01/Course11Understanding.java)  
    	1.2	[红灯-绿灯-重构](src/main/java/com/java/testdriven/chapter01/Course12RedGreenRefactor.java)  
    	1.3	[速度是关键](src/main/java/com/java/testdriven/chapter01/Course13SpeedIsKey.java)  
    	1.4	[TDD 并非测试方法](src/main/java/com/java/testdriven/chapter01/Course14NotTesting.java) 
    2.	[测试](src/main/java/com/java/testdriven/chapter01/Course20Testing.java)  
    	2.1	[黑盒测试](src/main/java/com/java/testdriven/chapter01/Course21BlackBoxTesting.java)  
    	2.2	[白盒测试](src/main/java/com/java/testdriven/chapter01/Course22WhiteBoxTesting.java)  
    	3.3	[质量检查和质量保证的差别](src/main/java/com/java/testdriven/chapter01/Course23QCandQA.java)  
    	3.4	[更好的测试](src/main/java/com/java/testdriven/chapter01/Course24BetterTests.java)  
    3.	[模拟](src/main/java/com/java/testdriven/chapter01/Course3Mocking.java)
    4.	[可执行的文档](src/main/java/com/java/testdriven/chapter01/Course4ExecutableDocument.java)
    5.	[无需调试](src/main/java/com/java/testdriven/chapter01/Course5NoDebugging.java)  
- 二、[工具、框架和环境](src/main/java/com/java/testdriven/chapter02)
    1.	[Git](src/main/java/com/java/testdriven/chapter02/Course01Git.java)
    2.	[虚拟机](src/main/java/com/java/testdriven/chapter02/Course020VirtualMachines.java)   
    	2.1	[Vagrant](src/main/java/com/java/testdriven/chapter02/Course021Vagrant.java)  
    	2.2	[Docker](src/main/java/com/java/testdriven/chapter02/Course022Docker.java)  
    3.	[构建工具（Gradle）](src/main/java/com/java/testdriven/chapter02/Course03BuildTools.java)
    4.	[集成开发环境（IntelliJ IDEA）](src/main/java/com/java/testdriven/chapter02/Course04DevEnvironment.java)
    5.	[单元测试框架](src/main/java/com/java/testdriven/chapter02/Course050UnitTesting.java)  
    	5.1	[JUnit](src/main/java/com/java/testdriven/chapter02/Course051JUnit.java)  
    	5.2	[TestNG](src/main/java/com/java/testdriven/chapter02/Course052TestNG.java)  
    6.	Hamcrest 和 AssertJ  
    	6.1	[Hamcrest](src/main/java/com/java/testdriven/chapter02/Course061Hamcrest.java)  
    	6.2	[AssertJ](src/main/java/com/java/testdriven/chapter02/Course062AssertJ.java)  
    7.	[代码覆盖率工具（JaCoCo）](src/main/java/com/java/testdriven/chapter02/Course07JaCoCo.java)
    8.	[模拟框架](src/main/java/com/java/testdriven/chapter02/Course080MockingFrameworks.java)  
    	8.1	[Mockito](src/main/java/com/java/testdriven/chapter02/Course081Mockito.java)  
    	8.2	[EasyMock](src/main/java/com/java/testdriven/chapter02/Course082EasyMock.java)  
    	8.3	[PowerMock](src/main/java/com/java/testdriven/chapter02/Course083PowerMock.java)  
    9.	[用户界面测试](src/main/java/com/java/testdriven/chapter02/Course090UserInterfaceTesting.java)  
    	9.1	[Web 测试框架](src/main/java/com/java/testdriven/chapter02/Course091WebTesting.java)  
    	9.2	[Selenium](src/main/java/com/java/testdriven/chapter02/Course092Selenium.java)  
    	9.3	[Selenide](src/main/java/com/java/testdriven/chapter02/Course093Selenide.java)  
    10.	[行为驱动开发](src/main/java/com/java/testdriven/chapter02/Course100BehaviorDrivenDev.java)  
    	10.1	[JBehave](src/main/java/com/java/testdriven/chapter02/Course101JBehave.java)  
    	10.2	[Cucumber](src/main/java/com/java/testdriven/chapter02/Course102Cucumber.java)  
- 三、[红灯-绿灯-重构——从失败到成功再到完美](src/main/java/com/java/testdriven/chapter03)  
    1.	[使用 Gradle 和 JUnit 搭建环境](src/main/java/com/java/testdriven/chapter03/Course1SetEnvironment.java)  
    2.	[“红灯-绿灯-重构”过程](src/main/java/com/java/testdriven/chapter03/Course20Process.java)   
    	2.1	[编写一个测试](src/main/java/com/java/testdriven/chapter03/Course21WriteTest.java)  
    	2.2	[运行所有测试并确认最后一个未通过](src/main/java/com/java/testdriven/chapter03/Course22LastOneFailing.java)  
    	2.3	[编写实现代码](src/main/java/com/java/testdriven/chapter03/Course23WriteCode.java)  
    	2.4	[运行所有测试](src/main/java/com/java/testdriven/chapter03/Course24RunAllTests.java)  
    	2.5	[重构](src/main/java/com/java/testdriven/chapter03/Course25Refactor.java)  
    	2.6	[重复](src/main/java/com/java/testdriven/chapter03/Course26Repeat.java)  
    3.	[“井字游戏”的需求](src/main/java/com/java/testdriven/chapter03/Course3TicTacToe.java)
    4.	[开发“井字游戏”](src/main/java/com/java/testdriven/chapter03/Course4DevTicTacToeAll.java)&nbsp;&nbsp;&nbsp;[测试用例](src/test/java/com/java/testdriven/chapter03/Course4DevTicTacToeAllTest.java)   
    	4.1	[需求1](src/main/java/com/java/testdriven/chapter03/Course4DevTicTacToe1.java)&nbsp;&nbsp;&nbsp;[测试用例](src/test/java/com/java/testdriven/chapter03/Course4DevTicTacToe1Test.java)  
    	4.2	[需求2](src/main/java/com/java/testdriven/chapter03/Course4DevTicTacToe2.java)&nbsp;&nbsp;&nbsp;[测试用例](src/test/java/com/java/testdriven/chapter03/Course4DevTicTacToe2Test.java)  
    	4.3	[需求3](src/main/java/com/java/testdriven/chapter03/Course4DevTicTacToe3.java)&nbsp;&nbsp;&nbsp;[测试用例](src/test/java/com/java/testdriven/chapter03/Course4DevTicTacToe3Test.java)  
    	4.4	[需求4](src/main/java/com/java/testdriven/chapter03/Course4DevTicTacToe4.java)&nbsp;&nbsp;&nbsp;[测试用例](src/test/java/com/java/testdriven/chapter03/Course4DevTicTacToe4Test.java)  
    5.	[代码覆盖率](src/main/java/com/java/testdriven/chapter03/Course5CodeCoverage.java)
    6. [更多练习](src/main/java/com/java/testdriven/chapter03/Course6MoreExercises.java)  
- 四、[单元测试——专注于当下而非过往](src/main/java/com/java/testdriven/chapter04)  
     1.	[单元测试](src/main/java/com/java/testdriven/chapter04/Course10UnitTesting.java)  
     	1.1	[何为单元测试](src/main/java/com/java/testdriven/chapter04/Course11WhatUnitTesting.java)  
     	1.2	[为何要进行单元测试](src/main/java/com/java/testdriven/chapter04/Course12WhyUnitTesting.java)  
     	1.3	[代码重构](src/main/java/com/java/testdriven/chapter04/Course13CodeRefactor.java)  
     	1.4	[为何不只使用单元测试](src/main/java/com/java/testdriven/chapter04/Course14NotExclusively.java)  
     2.	[TDD 中的单元测试](src/main/java/com/java/testdriven/chapter04/Course2UnitTestingWithTDD.java)   
     3.	[TestNG](src/main/java/com/java/testdriven/chapter04/Course30TestNG.java)  
     	3.1	[注解 @Test](src/main/java/com/java/testdriven/chapter04/Course31Test.java)  
     	3.2	[注解 @BeforeSuite、 @BeforeTest、 @BeforeGroups、 @AfterGroups、 @AfterTest和 @AfterSuite](src/main/java/com/java/testdriven/chapter04/Course32BeforeSuite.java)  
     	3.3	[注解 @BeforeClass 和 @AfterClass](src/main/java/com/java/testdriven/chapter04/Course33BeforeClass.java)  
     	3.4	[注解 @BeforeMethod 和 @AfterMethod](src/main/java/com/java/testdriven/chapter04/Course34BeforeMethod.java)  
     	3.5	[注解参数 @Test(enable = false)](src/main/java/com/java/testdriven/chapter04/Course35Enable.java)  
     	3.6	[注解参数 @Test(expectedExceptions = SomeClass.class)](src/main/java/com/java/testdriven/chapter04/Course36ExpectedExceptions.java)   
     	3.7	[TestNG 和 JUnit 差别小结](src/main/java/com/java/testdriven/chapter04/Course37vsJUnit.java)   
     4.	[“遥控军舰”的需求](src/main/java/com/java/testdriven/chapter04/Course4Ship.java)   
     5.	[开发“遥控军舰”](src/main/java/com/java/testdriven/chapter04/Course5DevShipAll.java)&nbsp;&nbsp;&nbsp;[实现](src/main/java/com/java/testdriven/chapter04/Ship.java)&nbsp;&nbsp;&nbsp;[测试用例](src/test/java/com/java/testdriven/chapter04/ShipSpec.java)   
- 五、[设计——难以测试说明设计不佳](src/main/java/com/java/testdriven/chapter05)  
    1.	[为何要关心设计](src/main/java/com/java/testdriven/chapter05/Course1CareDesign.java)  
    2.	[Connect4](src/main/java/com/java/testdriven/chapter05/Course2Connect4.java)   
    3.	[完成 Connect4 实现后再测试](src/main/java/com/java/testdriven/chapter05/Course3TestTheLast.java)&nbsp;&nbsp;&nbsp;[测试用例](src/test/java/com/java/testdriven/chapter05/Course3TestTheLastTest.java)  
    4.	[使用 TDD 实现 Connect4](src/main/java/com/java/testdriven/chapter05/Course4TheTDD.java)&nbsp;&nbsp;&nbsp;[测试用例](src/test/java/com/java/testdriven/chapter05/Course4TheTDDTest.java)  
- 六、[模拟——消除外部依赖](src/main/java/com/java/testdriven/chapter06)
    1.	[模拟](src/main/java/com/java/testdriven/chapter06/Course10Mocking.java)  
    	1.1	[为何使用模拟对象](src/main/java/com/java/testdriven/chapter06/Course11WhyMocking.java)  
    	1.2	[术语](src/main/java/com/java/testdriven/chapter06/Course12Terminology.java)  
    	1.3	[模拟对象](src/main/java/com/java/testdriven/chapter06/Course13MockObjects.java)  
    2.	[Mockito](src/main/java/com/java/testdriven/chapter06/Course2Mockito.java)   
    3.	[“井字游戏”第二版的需求](src/main/java/com/java/testdriven/chapter06/Course3TicTacToeV2.java)
    4.	[开发“井字游戏”第二版](src/main/java/com/java/testdriven/chapter06/Course40DevTicTacToeV2.java)  
		4.1	[需求1](src/main/java/com/java/testdriven/chapter06/Course41DevTicTacToeV2.java)&nbsp;&nbsp;&nbsp;[测试用例](src/test/java/com/java/testdriven/chapter06/Course41DevTicTacToeV2Test.java)  
		4.2	[需求2](src/main/java/com/java/testdriven/chapter06/Course42DevTicTacToeV2.java)&nbsp;&nbsp;&nbsp;[测试用例](src/test/java/com/java/testdriven/chapter06/Course42DevTicTacToeV2Test.java)     
    5.	[集成测试](src/main/java/com/java/testdriven/chapter06/Course50IntegrationTests.java)     
		5.1	[分离测试](src/main/java/com/java/testdriven/chapter06/Course51TestsSeparation.java)      
		5.2	[集成测试](src/main/java/com/java/testdriven/chapter06/Course52IntegrationTest.java)      