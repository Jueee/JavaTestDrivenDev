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

/**
 * 	应用遗留代码修改算法
 *	
 *	
 *	为应用这种算法，通常先编写一组测试，并在重构期间确保这些测试始终能通过。
 *	这不同于正常的TDD周期，因为重构不能引入任何新功能，即不应编写任何新规范。
 *
 *	@author hzweiyongqiang
 */
public class Course14ApplyChangeAlgorithm {

	/**
	 * 	为更好地解释这种算法，假设我们被要求做如下修改：
	 * 	为更轻松问候员工，我想给他们发推特消息而不是电子邮件。
	 */
	
	/**
	 * 	(1) 确定修改点
	 * 	问候方式是在 BirthdayGreetingService 类的构造函数中决定的
	 * 	这个构造函数采用了策略模式（https://en.wikipedia.org/?title=Strategy_pattern）
	 * 	如下述代码片段所示：
	  	public class BirthdayGreetingService {
			public BirthdayGreetingService() {
				messageSender = new EmailMessageSender();
			}
		}
	 */
	
	/**
	 * 	(2) 找出测试点
	 * 	BirthdayGreetingService 类没有任何注入的协作者可为其添加额外的功能，因此只能在这个服务类外部对其进行测试。
	 * 	一种办法是修改 EmailMessageSender 类，将其实现替换为模拟或伪造实现，但这是拿这个类的实现冒险。
	 * 	另一种选择是为这项功能编写一个端到端测试：
	 */
	public class EndToEndTest{
		@Test
		public void email_en_employee() {
			Course12LackInjection test = new Course12LackInjection();
			final StringBuilder systemOutput = injectSystemOutput();
			final Employee employee = test.new Employee(test.new Email("john@example.com"));
			
			test.new BirthdayGreetingService().greet(employee);

			assertThat(systemOutput.toString(),equalTo("Sent email to 'john@example.com' with the body 'Greentings on your birthday'\n"));
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
			System.out.println(outputPrintStream);
			return stringBuilder;
		}
	}
	
	
	/**
	 * 	(3) 消除依赖
	 * 	创建旨在确保预期行为不变的测试后，下面解除 BirthdayGreetingService 和 EmailMessageSender 之间的硬编码式依赖。
	 * 	为此，我们将使用一种名为“提出并重写调用”的技术，这种技术是Michaels Feathers在其著作中首次提出的：
	 */

	public class BirthdayGreetingService{
		private final MessageSender messageSender;
		
		public BirthdayGreetingService() {
			messageSender = getMessageSender();
		}
		
		/**
		 * 	为让这个方法可重写，需要将其改为受保护或公有的：
		 *	@return
		 */
		protected MessageSender getMessageSender() {
			Course12LackInjection test = new Course12LackInjection();
			return test.new EmailMessageSender();
		}
		
		public void greet(final Employee employee) {
			messageSender.send(employee.getAddress(),"Greetings on your birthday");
		}
	}
	
	/**
	 * 	创建一个伪造对象。
	 * 	使用代码引入伪造对象是一种模式：创建一个对象，它可用于替代既有对象，且其行为是可控的。
	 * 	这样就能通过注入一些自定义的伪造对象满足我们的需求。
	 * 	有关这个模式的更详细信息，请参阅http://xunitpatterns.com/。
	 */
	/**
	 *	创建一个伪造的服务，它扩展原来的服务。
	 */
	public class FakeBirthdayGreetingService extends BirthdayGreetingService{
		@Override
		protected MessageSender getMessageSender() {
			Course12LackInjection test = new Course12LackInjection();
			return test.new EmailMessageSender();
		}
	}
	
	/**
	 * 	使用Feathers在其论文（http://www.objectmentor.com/resources/articles/WorkingEffec-tivelyWithLegacyCode.pdf）中阐述的另一个依赖解除技巧：
	 * 	参数化构造函数。
	 * 	现在不再需要 FakeBirthday ，可以将其删除。
	 */
	public class BirthdayGreetingService2{
		private final MessageSender messageSender;
		
		public BirthdayGreetingService2(final MessageSender message) {
			this.messageSender = message;
		}
		
		protected MessageSender getMessageSender() {
			return messageSender;
		}
		
		public void greet(final Employee employee) {
			messageSender.send(employee.getAddress(),"Greetings on your birthday");
		}
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
		
		new BirthdayGreetingService2(messageSender).greet(employee);
		
		verify(messageSender).send(address.getAddress(), "Greetings on your birthday");
	}
}
