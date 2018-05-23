package com.java.testdriven.chapter09;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 	【功能配置文件】
 * 	Spring提供了一种自动加载YAML格式属性文件的方式
 *	
 *	@author hzweiyongqiang
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "features.fibonacci")
public class FibonacciFeatureConfig {

	private boolean restEnabled;

	public boolean isRestEnabled() {
		return restEnabled;
	}

	public void setRestEnabled(boolean restEnabled) {
		this.restEnabled = restEnabled;
	}
	
}
