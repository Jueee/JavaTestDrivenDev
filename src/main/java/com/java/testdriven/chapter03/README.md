#### 第 3 章：红灯-绿灯-重构——从失败到成功再到完美 ####
“红灯-绿灯-重构”流程是TDD的基石，这个过程就像玩乒乓球，以极快的速度在测试和实现代码之间切换。  
期间将失败，然后成功，最后改进。  
  
本章将演示如何使用TDD的支柱——“红灯-绿灯-重构”过程开发一个“井字游戏”。  
  
我们将编写测试并确定其失败；然后编写实现测试的代码，运行所有测试并确定其通过；最后，重构并完善代码。

##### 本章目录及程序实现 #####
1.	[使用 Gradle 和 JUnit 搭建环境](Course1SetEnvironment.java)
2.	[“红灯-绿灯-重构”过程](Course20Process.java)   
	2.1	[编写一个测试](Course21WriteTest.java)  
	2.2	[运行所有测试并确认最后一个未通过](Course22LastOneFailing.java)  
	2.3	[编写实现代码](Course23WriteCode.java)  
	2.4	[运行所有测试](Course24RunAllTests.java)  
	2.5	[重构](Course25Refactor.java)  
	2.6	[重复](Course26Repeat.java)  
3.	[“井字游戏”的需求](Course3TicTacToe.java)
4.	[开发“井字游戏”](Course4DevTicTacToeAll.java)  
	4.1	[需求1](Course4DevTicTacToe1.java)  
	4.2	[需求2](Course4DevTicTacToe2.java)  
	4.3	[需求3](Course4DevTicTacToe3.java)  
	4.4	[需求4](Course4DevTicTacToe4.java)  
5.	[代码覆盖率](Course5CodeCoverage.java)
6.	[更多练习](Course6MoreExercises.java)  
    
##### 小结 #####
-	本章并非要深入探讨复杂的东西（后面会介绍这些内容），而是要让你养成反复使用“红灯-绿灯-重构”流程的习惯。
-	学习了如下内容：
    1.	开发软件的最简单方式是将其分成小块；
    2.	设计方案脱胎于测试，而不是预先采用复杂的方法进行制定；
    3.	先编写测试并确定未通过后，再着手编写实现代码；
    4.	确定最后一个测试未通过后，就能肯定它是有效的（你一不小心就会犯错，编写总是能够通过的测试），要实现的功能还不存在；
    5.	测试未通过后，编写其实现代码；
    6.	编写实现时，力图使其尽可能简单，只要能让测试通过就行，而不试图提供完美的解决方案；
    7.	不断重复这个过程，直到认为需要对代码进行重构为止；
    8.	重构时不能引入任何新功能（即不改变应用程序的行为），而只是对代码进行改进，使其更容易理解和维护。
