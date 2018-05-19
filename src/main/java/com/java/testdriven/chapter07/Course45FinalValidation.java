package com.java.testdriven.chapter07;

/**
 * 	最后的验证
 *	
 *
 *
 *	假设有另一人负责编写代码以实现场景指定的需求，它每次挑选一个场景，开发代码并运行场景以确认其实现是正确的。
 *	所有场景都实现后，运行整个故事进行最后的验证。
 *
 *	
 *	@author hzweiyongqiang
 */
public class Course45FinalValidation {
	
	/**
	 * 	我们将这个应用程序打包为一个 Docker 文件，并创建运行该应用程序的Vagrant虚拟机。
	 */
	/**
	 * 	请签出分支https://bitbucket.org/vfarcic/tdd-java-ch07-books-store/branch/03-validation并运行 Vagrant ：
	 * 
	 * 	$ vagrant up
	 * 
	 * 	Vagrant虚拟机安装完毕后，可在浏览器中输入http://localhost:9001运行这个应用程序：
	 */
	/**
	 * 	现在再次运行我们的场景：
	 * 	$ gradle clean test
	 * 	这次没有失败，所有场景都成功运行。
	 */
	/**
	 * 	所有场景都通过后，满足验收标准，可将应用程序部署到生产环境。
	 */
}
