package com.java.testdriven.chapter08;

/**
 * 	依赖不是注入的
 * 
 * 	
 * 	这是遗留代码库最常见的一种坏味：
 * 	对于不需要在隔离情况下进行测试的类，在需要时直接实例化协作者，导致使用协作者的类同时负责创建。
 *	
 *	@author hzweiyongqiang
 */
public class Course12LackInjection {

	/**
	 * 	示例：
	 * 	无法对这个 BirthdayGreeting 服务进行单元测试。
	 * 	它依赖的 EmailMessageSender 是在构造函数中创建的，如果不修改代码库，就无法替换这个依赖
	 * 	（除非使用反射注入对象或在new运算符中替换对象）。
	 *	@author hzweiyongqiang
	 */
	public class BirthdayGreetingService{
		private final MessageSender messageSender;
		
		public BirthdayGreetingService() {
			messageSender = new EmailMessageSender();
		}
		
		public void greet(final Employee employee) {
			messageSender.send(employee.getAddress(),"Greetings on your birthday");
		}
	}
	
	
	
	
	public interface MessageSender{
		public void send(String address,String msg);
	}
	
	public class EmailMessageSender implements MessageSender{
		@Override
		public void send(String address, String message) {
			System.out.println("Sent email to '" + address + "' with the body '" + message + "'");
		}
	}
	
	public class Employee{
		private String address;

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		
		public Employee(Email email) {
			this.address = email.getAddress();
		}
	}
	
	public class Email{
		private String address;
		
		public Email(String address) {
			this.address = address;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
	}
}
