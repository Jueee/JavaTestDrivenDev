package com.java.testdriven.chapter06;

/**
 * 	分离测试
 * 
 * 	
 * 	如果遵循某种约定，就很容易在Gradle中将测试分离开来。
 * 
 * 	例如，我们可以将测试放在不同的目录和包中，或者使用不同的文件名后缀。
 * 	此处选择后一种方法：对于所有规范类，给它们命名时都加上后缀 Spec （如 TicTacToeSpec ）。
 * 	我们可以制定一条规则，规定所有集成测试都在名称中使用后缀 Integ 。
 * 	
 *	明白这一点后，下面修改文件 build.gradle 。
 *
 *	首先，我们告诉Gradle，test任务应只使用名称以 Spec 结尾的类：
 	test {
		include '*Spec.class'
	}
 *	
 *	接下来，创建一个新任务—— testInteg ：
 	task testInteg(type: Test) {
		include '*Integ.class'
	}
 *	
 *	要想运行所有集成测试，可在IDEA窗口Gradle projects 中单击任务 testInteg ，也可从命令提示符执行如下命令：
 *	gradle testInteg
 *
 *
 *	@author hzweiyongqiang
 */
public class Course51TestsSeparation {

}
