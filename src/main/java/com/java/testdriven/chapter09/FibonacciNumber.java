package com.java.testdriven.chapter09;

/**
 * 	用于存储计算结果的包装器
 *	
 *	@author hzweiyongqiang
 */
public class FibonacciNumber {

	private final int number, value;
	
	public FibonacciNumber(int number,int value) {
		this.number = number;
		this.value = value;
	}

	public int getNumber() {
		return number;
	}

	public int getValue() {
		return value;
	}
	
}
