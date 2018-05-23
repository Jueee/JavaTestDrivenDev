package com.java.testdriven.chapter09;

import org.springframework.stereotype.Service;

/**
 * 	【 fibonacci 服务类】
 * 	当前其计算代码总是返回 -1 ，这旨在模拟一项未完成的功能
 *	
 *	@author hzweiyongqiang
 */
@Service("fibonacci")
public class FibonacciService {

	public int getNthNumber(int n) {
		return -1;
	}
}
