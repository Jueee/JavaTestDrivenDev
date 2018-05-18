#### 第 6 章：模拟——消除外部依赖 ####
TDD 旨在提高速度。  我们要快速验证理念、概念或实现是否有效，还要快速运行所有测试。  
影响这种速度的主要瓶颈是外部依赖。  
  
为快速演示一些理念和概念，我们将扩展前面开发的“井字游戏”，并使用MongoDB存储数据。  
所有测试实际上都没有使用MongoDB，因为我们将模拟所有与MongoDB的通信。  
##### 本章目录及程序实现 #####
1.	[模拟](Course10Mocking.java)  
    1.1	[为何使用模拟对象](Course11WhyMocking.java)  
    1.2	[术语](Course12Terminology.java)  
    1.3	[模拟对象](Course13MockObjects.java)  
2.	[Mockito](Course2Mockito.java)   
3.	[“井字游戏”第二版的需求](Course3TicTacToeV2.java) 
4.	[开发“井字游戏”第二版](Course40DevTicTacToeV2.java)     
	4.1	[需求1](Course41DevTicTacToeV2.java)    
	4.2	[需求2](Course42DevTicTacToeV2.java)     
5.	[集成测试](Course50IntegrationTests.java)  
	5.1	[分离测试](Course51TestsSeparation.java)    
	5.2	[集成测试](Course52IntegrationTest.java)    
    
##### 小结 #####
-	模拟和监视技术用于隔离其他代码和第三方库，需要快速编写代码和运行测试时必不可少。
-	如果不使用模拟对象，测试通常将复杂得难以编写，且运行速度很慢，导致TDD几乎无法进行。
-	测试缓慢意味着无法在每次编写新规范后都运行所有测试，这将导致我们对测试的信任度下降，因为只运行了部分测试。
-	模拟不仅是一种很有用的外部依赖隔离方式，还可将你自己编写的代码与当前单元隔离。 

##### 推荐阅读 #####
Java模拟框架文档：
-	[Mockito](http://mockito.org/)
-	[EasyMock](http://easymock.org/)
-	[JMock](http://www.jmock.org/)
-	[PowerMock](https://code.google.com/p/powermock/)
