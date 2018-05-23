package com.java.testdriven.chapter09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 	一、【应用程序的主类】
 * 	二、【属性文件】
 * 	使用YAML格式，因为它简洁且很容易理解。
 * 	src/main/resources/application.yml
 * 	注：yml配置中使用Tab来缩进不符合yml的语法规则
 * 	三、【功能配置文件】
 * 	Spring提供了一种自动加载YAML格式属性文件的方式。
 * 	com.java.testdriven.chapter09.FibonacciFeatureConfig
 * 	四、【 fibonacci 服务类】
 * 	当前其计算代码总是返回 -1 ，这旨在模拟一项未完成的功能
 * 	com.java.testdriven.chapter09.Course31Fibonacci
 * 	五、【存储计算结果的包装器】
 * 	com.java.testdriven.chapter09.FibonacciNumber
 * 	六、【负责处理 fibonacci 服务查询】
 * 	com.java.testdriven.chapter09.FibonacciRestController
 */
@SpringBootApplication
public class Course30Example {
	
	public static void main(String[] args) {
		SpringApplication.run(Course30Example.class,args);
	}
}

/**
 * 	运行报错：
 * 	Exception in thread "main" while scanning for the next token
 * 	found character 	 '\t(TAB)' that cannot start any token. (Do not use \t(TAB) for indentation)
 * 	解决：
 * 	yml配置中不能使用Tab来缩进！
 */

/**
 * 	运行报错：
 * 	Error creating bean with name 'mappingJackson2HttpMessageConverter' defined in class path resource 
 * 	解决：
 * 	spring-web jar 包冲突！
 */

/**
 * 	运行报错：
 * 	Exception in thread "main" java.lang.IllegalAccessError: tried to access method org.springframework.core.io.support.SpringFactoriesLoader.loadFactoryNames(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/List; from class org.springframework.boot.SpringApplication

 * 	解决：
 * 	spring-web、spring-core  jar 包冲突！
 */

/**
 * 	运行报错：
 * 	java.lang.NoClassDefFoundError: org/springframework/beans/factory/config/YamlProcessor
 * 	解决：
 * 	spring-beans  jar 包冲突！
 */

/**
 * 	运行报错：
 * 	java.lang.NoClassDefFoundError: org/springframework/context/annotation/Condition
 * 	解决：
 * 	spring-context  jar 包冲突！
 */

/**
 * 	运行报错：
 * 	Cannot find template location: classpath:/templates/ (please add some templates or check your Thymeleaf configuration)
 * 	解决：
 * 	在 src\main\resources 下新增文件夹 templates，并随意增加一些文件，如 fibonacci.html！
 */
/**
 * 	运行成功！
 * 	访问：http://127.0.0.1:8080/fibonacci?number=7
 * 
 	Whitelabel Error Page
	This application has no explicit mapping for /error, so you are seeing this as a fallback.
	
	Wed May 23 09:39:41 CST 2018
	There was an unexpected error (type=Service Unavailable, status=503).
	This feature is currently unavailable
 * 
 * 
 * 	从中可知，收到的错误对应于REST API在功能被禁用时发送的错误。如果功能被启用，返回的结果将为 -1 。
 */
