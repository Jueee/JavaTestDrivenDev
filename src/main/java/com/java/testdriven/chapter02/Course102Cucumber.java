package com.java.testdriven.chapter02;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 	Cucumber
 *	
 *	Cucumber最初是一个Ruby BDD框架，但现在支持包括Java在内的多种语言，它提供的功能与 JBehave 很像。
 *
 *	这两个框架唯一显著的差别在于Cucumber定义步骤文本的方式，它使用正则表达式匹配变量类型，而不像JBehave那样根据方法签名推断。
 *
 *	@author hzweiyongqiang
 */
public class Course102Cucumber {

	/**
	 * 	这是一个Given步骤，表示要成功执行后续操作必须满足的一个前置条件，此处指打开一个维基百科网页。
	 */
	@Given("^I go to Wikipedia homepage$")
	public void goToWikePage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		Configuration.browser = "chrome";
		//  打开维基百科页面
		open("http://en.wikipedia.org/wiki/Main_Page");
	}
	
	/**
	 * 	操作是使用注解 @When 定义的。注意，引入参数可让步骤更灵活。
	 * 	我们使用这些步骤设置一个文本框的值。
	 *	@param value
	 *	@param fieldName
	 */
	@When("^I enter the value (.*) on a field named (.*)$")
	public void enterValueOnFieldByName(String value, String fieldName) {
		//  搜索TDD
		$(By.name(fieldName)).setValue(value);
	}
	/**
	 * 	单击特定按钮
	 *	@param buttonName
	 */
	@When("^I click the button (.*)$")
	public void clickButtonByName(String buttonName) {
		// 单击搜索按钮
		$(By.name(buttonName)).click();
	}
	
	/**
	 * 	操作执行完毕后进行验证，验证是使用注解 @Then 声明的。
	 *	@param title
	 */
	@Then("^the page title contains (.*)$")
	public void pageTitleIs(String title) {
		//  检查结果
		assertThat(title(),startsWith(title));
	}
}
