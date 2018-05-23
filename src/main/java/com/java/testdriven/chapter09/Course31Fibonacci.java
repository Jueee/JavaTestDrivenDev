package com.java.testdriven.chapter09;

import org.springframework.stereotype.Service;

/**
 * 	实现 fibonacci 服务【 fibonacci 服务类】
 * 
 * 	斐波那契数列是一个整数数列，通过反复使用公式f(n) = f(n-1) + f(n – 2)计算得到。
 * 	这个数列开头的两个数为f(0) = 0 和f(1) = 1，而其他所有数字都是这样计算得到的：递归使用前面的公式，知道公式中的每项都为已知值0或1。
 * 	换言之，斐波那契数列为0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144…
 *	
 *	我们还想限制计算斐波那契数所需的时间，为此对输入进行限制： fibonacci 服务只计算斐波那契数列中第0~30个数字。
 *
 *	实现服务：见 Course31Fibonacci 类。
 *	测试用例：见 Course31FibonacciTest 类。
 *	
 *	@author hzweiyongqiang
 */
@Service("fibonacci")
public class Course31Fibonacci {


	public static final int LIMIT = 30;

	public int getNthNumber(int n) {
		if (isOutOfLimits(n)) {
			throw new IllegalArgumentException("Requested number must be a positive number no bigger than " + LIMIT);
		}
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int first,second = 1, result = 1;
		do {
			first = second;
			second = result;
			result = first + second;
			--n;
		} while (n > 2);
		return result;
	}
	
	private boolean isOutOfLimits(int number) {
		return number > LIMIT || number < 0;
	}
}

/**
 * 	在文件 application.yml 中启用斐波那契数列计算功能。
 * 
 * 	运行效果一、
 * 	访问：http://127.0.0.1:8080/fibonacci?number=7
 * 	输出：{"number":7,"value":13}
 * 
 * 	运行效果二、
 * 	访问：http://127.0.0.1:8080/fibonacci?number=31
 * 	显示：
 * 	Whitelabel Error Page
	This application has no explicit mapping for /error, so you are seeing this as a fallback.
	
	Wed May 23 14:42:46 CST 2018
	There was an unexpected error (type=Bad Request, status=400).
	There was an error processing your request: Requested number must be a positive number no bigger than 30
 *	
 */