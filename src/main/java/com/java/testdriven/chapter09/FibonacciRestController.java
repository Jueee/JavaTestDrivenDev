package com.java.testdriven.chapter09;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 	负责处理 fibonacci 服务查询
 *	
 *	@author hzweiyongqiang
 */
@RestController		// REST API负责生成用JSON对象表示的响应，使用的注解为 @RestController。
public class FibonacciRestController {

	@Autowired
	FibonacciFeatureConfig fibonacciFeatureConfig;
	
	@Autowired
	@Qualifier("fibonacci")
	private Course31Fibonacci fibonacciService;
	
	/**
	 * 	负责核实应当启用还是禁用 fibonacci 服务
	 * 	如果该禁用，就引发 UnsupportedOperationException 异常。
	 *	@param number
	 *	@return
	 */
	@RequestMapping(value = "/fibonacci", method = RequestMethod.GET)
	public FibonacciNumber fibonacci(@RequestParam(value="number",defaultValue="0") int number) {
		if (fibonacciFeatureConfig.isRestEnabled()) {
			int fibonacciValue = fibonacciService.getNthNumber(number);
			return new FibonacciNumber(number, fibonacciValue);
		} else {
			throw new UnsupportedOperationException();
		}
	}
	
	/**
	 * 	错误处理函数-处理异常 UnsupportedOperationException
	 *	@param response
	 *	@throws IOException
	 */
	@ExceptionHandler(UnsupportedOperationException.class)
	public void unsupportedException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.SERVICE_UNAVAILABLE.value(),"This feature is currently unavailable");
	}
	
	/**
	 * 	错误处理函数-处理通用异常
	 *	@param response
	 *	@param e
	 *	@throws IOException
	 */
	@ExceptionHandler(Exception.class)
	public void handleGenericException(HttpServletResponse response, Exception e) throws IOException {
		String msg = "There was an error processing your request: " + e.getMessage();
		response.sendError(HttpStatus.BAD_REQUEST.value(),msg);
	}
}
