package com.java.testdriven.chapter07;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.codeborne.selenide.WebDriverRunner;

/**
 * 	JBehave 步骤
 *	
 *
 *	1、安装PhantomJS浏览器：http://phantomjs.org/download.html
 *	2、将PhantomJS WebDriver添加到 Steps 类
 *	3、编写第一个待定步骤的代码。可以直接复制 JBehave 在报告中推荐的方法
 *
 *	@author hzweiyongqiang
 */
public class Course44JBehaveSteps {
	
	private WebDriver webDriver;
	
	/**
	 * 	使用注解 @BeforeStory 指定了进行基本设置的方法
	 */
	@BeforeStory
	public void beforeStory() {
		if (webDriver == null) {
			System.setProperty("phantomjs.binary.path", "D:\\GreenSoftware\\phantomjs-2.0.0-windows\\bin\\phantomjs.exe");
			webDriver = new PhantomJSDriver();		// 如果没有指定驱动程序，我们就将其设置为 PhantomJSDriver 。
			WebDriverRunner.setWebDriver(webDriver);
			webDriver.manage().window().setSize(new Dimension(1024, 768));
		}
	}
	
	/**
	 * 	跑完要关掉 quit()
	 */
	@AfterStory
	public void afterStory() {
		webDriver.quit();
	}
	
	
	private String url = "http://localhost:9001";
	
	/**
	 * 	想象我们的应用程序包含一个打开图书页面的链接。
	 * 	为打开这个页面，需要执行两个步骤：
	 * 	1、打开网站主页
	 * 	2、单击菜单中的books链接
	 * 	我们将这个链接的ID指定为 books 。ID非常重要，使我们能够轻松找到页面中的元素。
	 */
	@Given("user is on the books screen")
	@Pending
	public void givenUserIsOnTheBooksScreen() {
		open(url);
		$("#books").click();
	}
	
//	@Then("field bookId exists")
//	@Pending
//	public void thenFieldBookIdExists() {
//		$("#books").shouldBe(visible);
//	}
	
	@Then("field $elementId exists")
	public void thenFieldExists(String elementId) {
		$("#" + elementId).shouldBe(visible);
	}
	
	@When("user clicks the button $elementId")
    public void whenUserClicksTheButton(String elementId) {
        $("#" + elementId).click();
    }
	/**
	 * 	在表单中填写一些值
	 */
	@When("user sets values to the book form")
	@Pending
	public void whenUserSetsValuesToTheBookForm() {
		$("#bookId").setValue("123");
		$("#bookTitle").setValue("BDD Assistant");
		$("#bookAuthor").setValue("Viktor Farcic");
		$("#bookDescription").setValue("Open source BDD stories editor and runner");
	}
	/**
	 * 	检查图书是否出现在可售图书列表
	 */
	@Then("book is stored")
	@Pending
	public void thenBookIsStored() {
		$("#bookId").shouldBe(present);
	}
	
	/**
	 * 	选择图书的方式
	 */
	@When("user selects a book")
	@Pending
	public void whenUserSelectsABook() {
		$("#book1").click();
	}
	/**
	 * 	验证表单中的数据是否正确
	 */
	@Then("book form contains all data")
	@Pending
	public void thenBookFormContainsAllData() {
		$("#bookId").shouldHave(value("1"));
		$("#bookTitle").shouldHave(value("TDD for Java Developers"));
		$("#bookAuthor").shouldHave(value("Viktor Farcic"));
		$("#bookDescription").shouldHave(value("Cool book!"));
	}

    @When("user sets new values to the book form")
    public void whenUserSetsNewValuesToTheBookForm() {
        $("#bookTitle").setValue("TDD for Java Developers revised");
        $("#bookAuthor").setValue("Viktor Farcic and Alex Garcia");
        $("#bookDescription").setValue("Even better book!");
        $("#saveBook").click();
    }

    @Then("book is updated")
    public void thenBookIsUpdated() {
        $("#book1").shouldHave(text("TDD for Java Developers revised"));
        $("#book1").click();
        $("#bookTitle").shouldHave(value("TDD for Java Developers revised"));
        $("#bookAuthor").shouldHave(value("Viktor Farcic and Alex Garcia"));
        $("#bookDescription").shouldHave(value("Even better book!"));
    }
	
	/**
	 * 	可通过确认图书不包含于可售图书列表验证它已被删除
	 */
	@Then("book is removed")
	@Pending
	public void thenBookIsRemoved() {
		$("#book1").shouldNotBe(visible);
	}
}
