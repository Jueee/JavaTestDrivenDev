package com.java.testdriven.chapter08;

/**
 * 	初步调查
 *	
 *
 *	知道需要添加的新功能后，开始调查项目Alexandria：
	  1、15个文件；
	  2、基于maven（ pom.xml ）；
	  3、没有测试。
 *	
 *	
 *	一、是个Web项目（文件 web.xml 表明了这一点），使用的是Spring（ applicationContext.xml 表明了这一点）。
 *	二、查看文件 web.xml 中：
 *		1、将加载 applicationContext.xml 中的上下文；	
 *		2、将在一个servlet中执行应用程序文件 com.java.testdriven.chapter08.alexandria.MyApplication 。
 *	三、查看文件 MyApplication.java：
 *		1、它配置必要的类，以便执行端点 BooksEndpoint 
 *	四、查看文件 BooksEndpoint.java：
 *		1、遗留代码的特征之一：两个依赖（ books 和 users ）都是在端点内创建的，而不是注入的。
 *	五、我们可记录重构期间要使用的元素，以便后面编写将依赖注入 BooksEndpoint 的代码。
 *
 *
 *	@author hzweiyongqiang
 */
public class Course26Preliminary {

}
