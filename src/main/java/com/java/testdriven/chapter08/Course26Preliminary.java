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
 *	六、使用如下命令，在本地执行这个遗留软件：mvn clean jetty:run
 *		这将启动一个处理请求的本地jetty服务器。
 *		这样做的最大好处是，部署是自动完成的，无需将一切打包并手动将其部署到应用程序服务器（如JBoss AS、GlassFish、Geronimo或TomEE）。
 *		这可极大提高修改并查看效果的速度，从而缩短反馈时间。
 *		在本章后面，我们将在Java代码中以编程方式启动这个服务器。
 *
 *	@author hzweiyongqiang
 */
public class Course26Preliminary {

}
