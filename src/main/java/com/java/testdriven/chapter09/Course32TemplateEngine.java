package com.java.testdriven.chapter09;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 	使用模版引擎
 *	
 *
 *	通过 application.yml -> features -> fibonacci -> restEnabled 能够开关斐波那契数计算功能。
 *	通过 application.yml -> features -> fibonacci -> webEnabled 能够开关未完成功能的Web链接，可将其隐藏。
 *
 *
 *	为演示这一点，我们将使用前面说到的框架 Thymeleaf 创建一个简单的网页：
 *
 *	一、在 FibonacciFeatureConfig 类中新增 webEnabled 属性及对应 set/get 方法。
 *
 *	二、创建两个模版。
 *	2.1、一个是主页，包含几个用于计算不同斐波那契数的链接。
 *		这些链接应仅在斐波那契数计算功能被启用时才可见，因此有一个模拟这种行为的可选块。
 *		见 src/main/resources/templates/home.html
 *	2.2、第二个模版显示计算得到的斐波那契数，还包含一个返回到主页的链接。
 *		见  src/main/resources/templates/fibonacci.html
 *
 *	三、将前面所说的一切关联起来并使其正常工作的控制器 Course32TemplateEngine。
 *	四、运行。
 *	五、访问主页：http://127.0.0.1:8080/
 *	六、使用如下代码关闭这项功能：
 *			features:
				fibonacci:
					restEnabled: true
					webEnabled: false
		此时，看不到链接，但依然能够计算斐波那契数，条件是知道相应的URL。
		如果手动输入URL http://localhost:8080/web/fibonacci?number=15，依然能够访问包含响应的相应页面。
		
 *
 *	这种做法很有用，但通常会无谓地增加代码复杂度。
 *	请别忘了重构代码，删除不再使用的旧开关，让代码更整洁、可读性更高。
 *
 *	另外，一个不错的主意是，让修改无需重启应用程序就能生效；
 *	很多存储方式都不要求重启应用程序，其中最流行的是数据库。
 *
 *	@author hzweiyongqiang
 */

@Controller		// Web控制器负责向模版页面提供自定义信息，使用的注解为 @Controller
public class Course32TemplateEngine {
	
	@Autowired
	FibonacciFeatureConfig fibonacciFeatureConfig;
	
	@Autowired
	@Qualifier("fibonacci")
	private Course31Fibonacci fibonacciService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("isWebEnabled", fibonacciFeatureConfig.isWebEnabled());
		if (fibonacciFeatureConfig.isWebEnabled()) {
			model.addAttribute("arrayOfInts", Arrays.asList(5,7,8,16));
		}
		return "home";
	}

	@RequestMapping(value = "/web/fibonacci", method = RequestMethod.GET)
	public String fibonacci(@RequestParam(value="number") Integer number, Model model) {
		if (number != null) {
			model.addAttribute("number", number);
			model.addAttribute("value", fibonacciService.getNthNumber(number));
		}
		return "fibonacci";
	}
}
