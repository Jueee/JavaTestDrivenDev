package com.java.testdriven.chapter02;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;

/**
 * 	Selenide
 *	
 *	Selenium很酷，让我们能够核实应用程序是否表现优异。
 *	但有些情况下，配置和使用起来有点棘手。
 *
 *	Selenide是一个基于Selenium的项目，提供了优良的测试编写语法，提高了测试的可读性。
 *	它将WebDriver和配置隐藏，同时提供了极大的定制空间。
 *
 *	Selenide默认情况下支持直接使用火狐浏览器打开。
 *
 *	有关如何在测试中使用Web驱动程序的更详细信息，请参阅http://selenide.org/。
 *
 *	@author hzweiyongqiang
 */
public class Course093Selenide {

	/**
	 * 	使用Selenide编写前面的Selenium测试
	 * 	熟悉jQuery（https://jquery.com/）的话对这里的语法可能不会感到陌生。
	 * 
	 * 	这种测试编写方式的表达力更强，不但语法更流畅，这些代码后面也自动执行了一些操作————使用 Selenium 时需要编写额外的代码行执行。
	 */
	@Test
	public void wikipediaSearchFeature() {
		// Selenide默认情况下支持直接使用火狐浏览器打开。
		// 如果需要使用 Chrome 浏览器，需要添加如下配置：
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		Configuration.browser = "chrome";
		
		//  打开维基百科页面
		open("http://en.wikipedia.org/wiki/Main_Page");
		
		//  搜索TDD
		$(By.name("search")).setValue("Test-derven development");
		
		// 单击搜索按钮
		$(By.name("go")).click();
		
		//  检查结果
		assertThat(title(),startsWith("Test-derven development"));
	}
}
