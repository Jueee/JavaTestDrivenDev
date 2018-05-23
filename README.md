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
- 七、[BDD——与整个团队协作](src/main/java/com/java/testdriven/chapter07)
    1.	[不同规范](src/main/java/com/java/testdriven/chapter07/Course10Specifications.java)  
    	1.1	[文档](src/main/java/com/java/testdriven/chapter07/Course11Documentation.java)  
    	1.2	[供程序员使用的文档](src/main/java/com/java/testdriven/chapter07/Course12DocForCoders.java)  
    	1.3	[供非程序员使用的文档](src/main/java/com/java/testdriven/chapter07/Course13DocForNonCoders.java)  
    2.	[行为驱动开发](src/main/java/com/java/testdriven/chapter07/Course20BehaviorDriven.java)   
		2.1	[叙述](src/main/java/com/java/testdriven/chapter07/Course21Narrative.java)  
		2.2	[场景](src/main/java/com/java/testdriven/chapter07/Course22Scenarios.java)
    3.	[书店应用程序的 BDD 故事](src/main/java/com/java/testdriven/chapter07/Course3BooksStore.java)  
    4.	[JBehave](src/main/java/com/java/testdriven/chapter07/Course40JBehave.java)   
		4.1	[JBehave 运行器](src/main/java/com/java/testdriven/chapter07/Course41JBehaveRunner.java)  
		4.2	[待定步骤](src/main/java/com/java/testdriven/chapter07/Course42PendingSteps.java)  
		4.3	[Selenium 和 Selenide](src/main/java/com/java/testdriven/chapter07/Course43SeleniumSelenide.java)  
		4.4	[JBehave 步骤](src/main/java/com/java/testdriven/chapter07/Course44JBehaveSteps.java)  
		4.5	[最后的验证](src/main/java/com/java/testdriven/chapter07/Course45FinalValidation.java)  
- 八、[重构遗留代码——使其重焕青春](src/main/java/com/java/testdriven/chapter08)
    1.	[遗留代码](src/main/java/com/java/testdriven/chapter08/Course10LegacyCode.java)  
     	1.1	[识别遗留代码的其他方式](src/main/java/com/java/testdriven/chapter08/Course11OtherWays.java)  
     	1.2	[依赖不是注入的](src/main/java/com/java/testdriven/chapter08/Course12LackInjection.java)   
     	1.3	[遗留代码修改算法](src/main/java/com/java/testdriven/chapter08/Course13ChangeAlgorithm.java)   
     	1.4	[应用遗留代码修改算法](src/main/java/com/java/testdriven/chapter08/Course14ApplyChangeAlgorithm.java) 
    2.	[编码套路](src/main/java/com/java/testdriven/chapter08/Course20KataExercise.java)   
     	2.1	[遗留代码处理套路](src/main/java/com/java/testdriven/chapter08/Course21LegacyKata.java)  
     	2.2	[描述](src/main/java/com/java/testdriven/chapter08/Course22Description.java)   
     	2.3	[技术说明](src/main/java/com/java/testdriven/chapter08/Course23TechnicalComments.java)   
     	2.4	[添加新功能](src/main/java/com/java/testdriven/chapter08/Course24AddNewFeature.java)  
     	2.5	[黑盒测试还是尖峰冲击测试](src/main/java/com/java/testdriven/chapter08/Course25SpikeTesting.java)  
     	2.6	[初步调查](src/main/java/com/java/testdriven/chapter08/Course26Preliminary.java)  
     	2.7	[应用遗留代码修改算法](src/main/java/com/java/testdriven/chapter08/Course27ApplyAlgorithm.java)  
     	2.8	[提取并重写调用](src/main/java/com/java/testdriven/chapter08/Course28Extract.java)  
     	2.9	[消除状态的“基本类型偏执”坏味](src/main/java/com/java/testdriven/chapter08/Course29RemoveObsession.java)
    3.	[原始代码](src/main/java/com/java/testdriven/chapter08/alexandria)&nbsp;&nbsp;&nbsp;[修改结果](src/main/java/com/java/testdriven/chapter05/newalexandria)&nbsp;&nbsp;&nbsp;[测试用例](src/test/java/com/java/testdriven/chapter05/newalexandria)
- 九、[功能开关——将未完成的功能部署到生产环境](src/main/java/com/java/testdriven/chapter09)  
    1.	[持续集成、持续交付和持续部署](src/main/java/com/java/testdriven/chapter09/Course1Continuous.java)  
    2.	[功能开关](src/main/java/com/java/testdriven/chapter09/Course2FeatureToggles.java)   
    3.	[功能开关示例](src/main/java/com/java/testdriven/chapter09/Course30Example.java)&nbsp;&nbsp;&nbsp;[测试用例](src/test/java/com/java/testdriven/chapter09/Course30ExampleTest.java)   
		3.1	[实现 fibonacci 服务](src/main/java/com/java/testdriven/chapter09/Course31Fibonacci.java)  
		3.2	[使用模版引擎](src/main/java/com/java/testdriven/chapter09/Course32TemplateEngine.java)