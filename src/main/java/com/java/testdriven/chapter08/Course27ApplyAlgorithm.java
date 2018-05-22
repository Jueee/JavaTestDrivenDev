package com.java.testdriven.chapter08;

/**
 * 	应用遗留代码修改算法
 * 
 * 	
 * 	应用的整个后端是独立工作的，它使用的是内存持久化。
 * 	即便数据被保存到数据库，也可使用同样的算法，但需要编写一些额外的代码，用于在测试之间清理和填充数据库。
 *	
 *	我们将使用DbUnit，有关这个测试框架的更详细信息，请参阅http://dbunit.sourceforge.net/。
 *
 *	@author hzweiyongqiang
 */
public class Course27ApplyAlgorithm {

	/**
	 * 	一、编写端到端测试用例：
	 * 
	 * 	为确保行为在重构期间不变，我们决定首先编写端到端测试。
	 * 	对于其他包含前端的应用程序，可使用更高级的工具（如Selenium/Selenide）完成这项工作。
	 * 
	 * 	由于前端不需要重构，因此可使用较低级的工具。
	 * 	我们选择编写HTTP请求进行端到端测试。
	 * 
	 * 	这些请求应是自动的、可测试的，因此应遵循所有自动测试规则。
	 * 	鉴于要在编写这些测试的同时探索应用程序的实际行为，我们决定使用工具Postman编写一个尖峰冲击。
	 * 	也可使用工具curl （http://curl.haxx.se/）编写尖峰冲击。
	 * 	（Postman工具可在如下网址找到：https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en，其官网为https://www.getpostman.com/）
	 * 	
	 * 	我们发现使用Postman测试是更合算的投资，因为使用完毕将丢弃这些测试。这些测试以极快的速度提供有关API的反馈和结果。
	 */
	
	/**
	 * 	我们发现 BooksEndpoint 类包含Web服务端点的定义，从这里着手确定有哪些功能是不错的选择。
	 * 	发现的功能如下。
		(1) 添加新书。
		(2) 列出所有图书。
		(3) 根据ID、作者、书名和状态搜索图书。
		(4) 为出租图书做准备。
		(5) 出租图书。
		(6) 将图书下架。
		(7) 将图书重新上架。
	 *	
	 *	我们手动启动服务器，并开始编写请求。
	 *
	 *	为进行测试，我们使用了一个名为RestAssured的库（https://github.com/rest-assured/rest-assured），它让我们能够更轻松地测试REST和JSON。
	 *
	 *	测试类见：com.java.testdriven.chapter08.alexandria.BooksEndpointTest
	 */
	
	/**
	 * 	有了确保不会导致退化的测试套件后，下面查看待办事项清单：
	  1、将依赖注入BooksEndpoint；
	  2、将单个状态改为多个状态；
	  3、消除状态的“基本类型偏执”坏味（可选）。
	 */
}
