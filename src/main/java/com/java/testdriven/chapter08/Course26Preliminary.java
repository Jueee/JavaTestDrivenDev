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
 *	调查结果：
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
 *	运行服务：
 *	一、使用如下命令，在本地执行这个遗留软件：mvn clean jetty:run
 *		这将启动一个处理请求的本地jetty服务器。
 *		这样做的最大好处是，部署是自动完成的，无需将一切打包并手动将其部署到应用程序服务器（如JBoss AS、GlassFish、Geronimo或TomEE）。
 *		这可极大提高修改并查看效果的速度，从而缩短反馈时间。
 *		在本章后面，我们将在Java代码中以编程方式启动这个服务器。
 *	二、若是 Eclipse 内部 maven build，可在 Goals 中设置 jetty:run 或 org.mortbay.jetty:maven-jetty-plugin:run。
 *	三、访问：http://127.0.0.1:8080/JavaTestDrivenDev/books
 *		显示：{"empty":true,"requestTime":"11:28:16.724","result":[]}
 *
 *	@author hzweiyongqiang
 */
public class Course26Preliminary {
	/**
	 * 	引入新功能：
		最重要的功能更改是，将当前使用的单个状态，替换为状态集合。
	 */
	// 单个状态
	public class Book {
		private String title;
		private String author;
		private int status; // 这是一个属性
		private int id;
	}
	// 状态集合
	public class Book2 {
		private String title;
		private String author;
		private int[] statuses; // 这是一个属性集合
		private int id;
	}
	
	/**
	 * 	这看起来管用（将对字段的访问改为对数组的访问后），但也提出了另一个功能需求。
	 * 	软件Alexandria必须能够存储图书并将其借给能够归还的用户。用户还能在这个系统中根据作者、书名、状态和ID搜索图书。
	 * 
	 * 	产品所有者（PO）确认现在根据状态搜索图书的方式变了：现在还允许搜索以前的状态。
	 * 	这导致需要做的修改越来越多。每当觉得该将遗留代码删除时，我们就开始应用遗留代码修改算法。
	 */
	/**
	 * 	我们还发现了坏味“依恋情结”和“基本类型偏执”：使用int变量存储状态（基本类型偏执），并修改另一个对象的状态（依恋情结）。
	 * 
	 * 	我们将这个可重构的地方加入待办事项清单。
	 * 	1、将依赖注入BooksEndpoint；
	 * 	2、将单个状态改为多个状态；
	 * 	3、消除状态的“基本类型偏执”坏味（可选）。
	 */
}
