#### 第 7 章：BDD——与整个团队协作 ####
TDD 涉及的范围比我们前面所做的大得多。
-	我们可定义需求，与客户讨论需求并就开发内容达成一致
-	我们可以将这些需求变成可执行的，以驱动和验证开发工作
-	我们可使用普通语言编写验收测试   

所有这些以及其他任务都可使用名为行为驱动开发（BDD）的 TDD 变种完成。  
   
我们将使用BDD方法开发一个书店应用程序：  
-	使用自然语言定义验收测试
-	分别创建每项功能的实现
-	通过运行BDD场景确认它们能够正常工作
-	在必要时重构代码以达到要求的质量等级  

##### 本章目录及程序实现 #####
1.	[不同规范](Course10Specifications.java)  
    1.1	[文档](Course11Documentation.java)  
    1.2	[供程序员使用的文档](Course12DocForCoders.java)  
    1.3	[供非程序员使用的文档](Course13DocForNonCoders.java)  
2.	[行为驱动开发](Course20BehaviorDriven.java)   
	2.1	[叙述](Course21Narrative.java)  
	2.2	[场景](Course22Scenarios.java)
3.	[书店应用程序的 BDD 故事](Course3BooksStore.java)  
4.	[JBehave](Course40JBehave.java)   
	4.1	[JBehave 运行器](Course41JBehaveRunner.java)  
	4.2	[待定步骤](Course42PendingSteps.java)  
	4.3	[Selenium 和 Selenide](Course43SeleniumSelenide.java)  
	4.4	[JBehave 步骤](Course44JBehaveSteps.java)  
	4.5	[最后的验证](Course45FinalValidation.java)  
    
##### 小结 #####
-	BDD 是一个 TDD 变种，遵循同样的基本原则：先编写测试（场景），再编写实现代码。
-	BDD 和 TDD 主要差别：
    1.	周期的持续时间：    
    	基于单元测试的TDD中，我们快速从红灯切换到绿灯（在几分钟乃至几秒钟内）；  
    	而BDD通常采用更高级的方法，从红灯切换到绿灯可能需要几小时乃至几天。  
    2.	受众：  
    	基于单元测试的TDD是开发人员为开发人员做的；  
    	而BDD使用的是普通语言，通常涉及所有团队成员。  

##### 推荐阅读 #####
Gojko Adzic的著作《实例化需求：团队如何交付正确的软件》。