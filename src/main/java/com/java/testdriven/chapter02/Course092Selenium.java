package com.java.testdriven.chapter02;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 	Selenium
 *	
 *	Selenium是一款出色的Web测试工具，它使用浏览器运行验证，并支持所有流行的浏览器，如Firefox、Safari和Chrome。
 *	它还支持使用无界面浏览器（headless browser）测试网页，这样可极大地提高速度，同时减少资源消耗。
 *
 *	要执行Selenium，最简单的方法是通过JUnitRunner运行。
 *	所有Selenium测试都首先初始化 WebDriver
 * 
 * 	有关Selenium的更详细信息以及WebDriver的更复杂用法，请参阅http://www.seleniumhq.org/。
 * 
 *	@author hzweiyongqiang
 */
public class Course092Selenium {

	@Test
	public void testSelenium() {
		// 加载 Chrome 驱动
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		
		// 使用 Chrome 驱动程序，WebDriver是一个接口，可使用Selenium提供的众多驱动程序之一进行实例化
		WebDriver driver = new ChromeDriver();
		
		// 使用如下指令打开一个URL
		driver.get("http://en.wikipedia.org/wiki/Main_Page");
		
		// 网页打开后，可根据名称找到搜索框并指定要搜索的内容：
		WebElement query = driver.findElement(By.name("search"));
		query.sendKeys("Test-derven development");
		
		// 指定要搜索的内容后，找到并单击Go按钮：
		WebElement goButton = driver.findElement(By.name("go"));
		goButton.click();
		
		// 进入目标网页后进行验证，这里是为了确定页面标题正确无误：
		assertThat(driver.getTitle(),startsWith("Test-derven development"));
		
		// 使用完驱动程序后，应将其关闭：
		driver.quit();
	}
}

/**
 * 	Question 1:
 * 	使用 WebDriver driver = new ChromeDriver();
 * 	报错：java.lang.IllegalStateException: 
 * 	The path to the driver executable must be set by the webdriver.chrome.driver system property; 
 * 	for more information, see https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver. 
 * 	The latest version can be downloaded from http://chromedriver.storage.googleapis.com/index.html
 * 	解决：
 * 	1、下载 chromedriver（https://sites.google.com/a/chromium.org/chromedriver/downloads）
 * 	2、设置System.setProperty("webdriver.chrome.driver", ".../chromedriver.exe");
 * 
 * 	Question 2:
 * 	报错：org.openqa.selenium.SessionNotCreatedException: 
 * 	session not created exception from unknown error: Runtime.executionContextCreated has invalid 'context': …………
 * 	Driver info: org.openqa.selenium.chrome.ChromeDriver
 * 	解决：
 * 	Update your chromedriver with lastest version.
 * 	（https://chromedriver.storage.googleapis.com/index.html）
 * 	
 */
