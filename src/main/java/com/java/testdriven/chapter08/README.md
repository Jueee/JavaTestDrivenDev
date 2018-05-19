#### 第 8 章：重构遗留代码——使其重焕青春 ####
TDD不能直接应用于遗留代码，可能需要稍微调整步骤才管用。

##### 本章目录及程序实现 #####
1.	[遗留代码](Course10LegacyCode.java)  
	1.1	[识别遗留代码的其他方式](Course11OtherWays.java)  
	1.2	[依赖不是注入的](Course12LackInjection.java)   
	1.3	[遗留代码修改算法](Course13ChangeAlgorithm.java)   
	1.4	[应用遗留代码修改算法](Course14ApplyChangeAlgorithm.java) 
2.	[编码套路](Course20KataExercise.java)   
	2.1	[遗留代码处理套路](Course21LegacyKata.java)  
	2.2	[描述](Course22Description.java)   
	2.3	[技术说明](Course23TechnicalComments.java)   
	2.4	[添加新功能](Course24AddNewFeature.java)  
	2.5	[黑盒测试还是尖峰冲击测试](Course25SpikeTesting.java)  
	2.6	[初步调查](Course26Preliminary.java)  
	2.7	[应用遗留代码修改算法](Course27ApplyAlgorithm.java)  
	2.8	[提取并重写调用](Course28Extract.java)  
	2.9	[消除状态的“基本类型偏执”坏味](Course29RemoveObsession.java)  
    
##### 小结 #####
-	要处理遗留代码，首先需要创建测试，确保遗留代码的功能在处理过程中保持不变。
-	最重要的是更深入地了解代码库，以便能够安全修改。

##### 推荐阅读 #####
Michael Feathers 的著作《修改代码的艺术》。