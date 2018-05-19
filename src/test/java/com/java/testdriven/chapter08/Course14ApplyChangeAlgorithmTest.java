package com.java.testdriven.chapter08;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.java.testdriven.chapter08.Course12LackInjection.Email;
import com.java.testdriven.chapter08.Course12LackInjection.Employee;
import com.java.testdriven.chapter08.Course12LackInjection.MessageSender;
import com.java.testdriven.chapter08.Course14ApplyChangeAlgorithm.BirthdayGreetingService2;

/**
 * 	端到端测试
 *	
 *	@author hzweiyongqiang
 */
public class Course14ApplyChangeAlgorithmTest {
	
	/**
	 * 	 针对 Course12LackInjection 的原始测试
	 */
	@Test
	public void email_en_employee() {
		Course12LackInjection test = new Course12LackInjection();
		final StringBuilder systemOutput = injectSystemOutput();
		final Employee employee = test.new Employee(test.new Email("john@example.com"));
		
		test.new BirthdayGreetingService().greet(employee);

		assertThat(systemOutput.toString(),equalTo("Sent email to 'john@example.com' with the body 'Greetings on your birthday'\r\n"));
	}
	
	/**
	 * 	这些代码来自 GMaur's LegacyUtils（https://github.com/GMaur/legacyutils）
	 * 	这个库旨在帮助你捕捉系统输出（ System.out ）。
	 *	@return
	 */
	private StringBuilder injectSystemOutput() {
		final StringBuilder stringBuilder = new StringBuilder();
		final PrintStream outputPrintStream = new PrintStream(
				new OutputStream() {
					@Override
					public void write(int b) throws IOException {
						stringBuilder.append((char)b);
					}
				});
		System.setOut(outputPrintStream);
		return stringBuilder;
	}
	

	
	/**
	 * 	 针对 Course14ApplyChangeAlgorithm 的 (3) 消除依赖 步骤的测试
	 */
	@Test
	public void email_en_employee1() {
		Course12LackInjection test = new Course12LackInjection();
		final StringBuilder systemOutput = injectSystemOutput();
		final Employee employee = test.new Employee(test.new Email("john@example.com"));
		
		Course14ApplyChangeAlgorithm test1 = new Course14ApplyChangeAlgorithm();	// 修改行
		test1.new BirthdayGreetingService().greet(employee);						// 修改行

		assertThat(systemOutput.toString(),equalTo("Sent email to 'john@example.com' with the body 'Greetings on your birthday'\r\n"));
	}
	

	/**
	 * 	 针对 Course14ApplyChangeAlgorithm 的 (3) 消除依赖 步骤的测试- 测试伪造对象类 FakeBirthdayGreetingService
	 */
	@Test
	public void email_en_employee2() {
		Course12LackInjection test = new Course12LackInjection();
		final StringBuilder systemOutput = injectSystemOutput();
		final Employee employee = test.new Employee(test.new Email("john@example.com"));
		
		Course14ApplyChangeAlgorithm test1 = new Course14ApplyChangeAlgorithm();
		test1.new FakeBirthdayGreetingService().greet(employee);	// 修改行

		assertThat(systemOutput.toString(),equalTo("Sent email to 'john@example.com' with the body 'Greetings on your birthday'\r\n"));
	}
	

	/**
	 * 	 针对 Course14ApplyChangeAlgorithm 的 (3) 消除依赖 步骤的测试- 参数化构造函数 BirthdayGreetingService2
	 */
	@Test
	public void email_en_employee3() {
		Course12LackInjection test = new Course12LackInjection();
		final StringBuilder systemOutput = injectSystemOutput();
		final Employee employee = test.new Employee(test.new Email("john@example.com"));
		
		Course14ApplyChangeAlgorithm test1 = new Course14ApplyChangeAlgorithm();
		test1.new BirthdayGreetingService2(test.new EmailMessageSender()).greet(employee);	// 修改行

		assertThat(systemOutput.toString(),equalTo("Sent email to 'john@example.com' with the body 'Greetings on your birthday'\r\n"));
	}
	
	

	/**
	 * 	(4) 编写测试
	 * 	保留前面的端到端测试，同时创建一个交互测试验证 BirthdayGreetingService 和 MessageSender 之间的集成情况：
	 */
	@Test
	public void the_service_should_ask_the_messageSender() {
		Course12LackInjection test = new Course12LackInjection();
		final Email address = test.new Email("john@example.com");
		final Employee employee = test.new Employee(address);
		final MessageSender messageSender = mock(MessageSender.class);
		
		Course14ApplyChangeAlgorithm test1 = new Course14ApplyChangeAlgorithm();
		test1.new BirthdayGreetingService2(messageSender).greet(employee);
		
		verify(messageSender).send(address.getAddress(), "Greetings on your birthday");
	}
}
