package com.java.testdriven.chapter07;

/**
 * 	待定步骤
 *	
 *
 *	1、由于源代码变化不频繁（我们通常只修改文本格式的故事），因此运行 test 任务前，必须运行 clean 任务将缓存删除。
 *	
 *	2、JBehave创建了一个不错的报告，并将其放在目录 target/jbehave/view/reports.html 中。
 *	   2.1	报告的第一页列出了我们定义的故事（这里只有故事Administration）
 *     2.2	还有两个预定义的故事 ——BeforeStories 和 AfterStories 。 
 *			这两个故事的用途与 JUnit 中用 @BeforeClass 和 @AfterClass 注解的方法类似：在故事之前和之后运行，可用于设置和拆除数据、服务器等。
 *	   2.3	报告的第一页表明，我们有5个场景，它们都处于待定（Pending）状态。
 *			JBehave通过这种方式告诉我们，场景既未成功也未失败，而是使用过的步骤缺失代码。
 *	   2.4	每行的最后一列都包含一个链接，让我们能够查看相应故事的详情。
 *	   2.5	在相应故事的详情，所有步骤都被标记为“待定”，JBehave甚至提出了建议，指出需要为每个待定步骤创建一个方法。
 *	
 *	@author hzweiyongqiang
 */
public class Course42PendingSteps {
/**
Story Reports
Stories	Scenarios	GivenStory Scenarios	Steps		
Name			Excluded	Total	Successful	Pending	Failed	Excluded	Total	Successful	Pending	Failed	Excluded	Total	Successful	Pending	Failed	Not Performed	Ignorable	Duration (hh:mm:ss.SSS)	View
Administration	0	5	5	5	0	0	0	0	0	0	0	21	0	21	0	0	0	00:00:00.000	stats |html
AfterStories	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	00:00:00.000	stats |html
BeforeStories	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	00:00:00.000	stats |html
WikipediaSearch	0	1	1	1	0	0	0	0	0	0	0	4	0	4	0	0	0	00:00:00.000	stats |html
4				0	6	6	6	0	0	0	0	0	0	0	25	0	25	0	0	0	00:00:00.000	Totals

 */
}
