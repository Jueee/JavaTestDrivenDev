### 命名约定 ###
命名约定有助于更好地组织测试，从而让开发人员更容易测试。  
</br>
无论什么命名约定，都聊胜于无。  
最重要的是，团队的每个成员都知道要遵循哪些命名约定，并能熟练使用。  
选择流行的命名约定的优点在于，新加入团队的成员能快速掌握，因为既有的知识可提供帮助。  
</br></br></br> 
##### 将实现代码和测试代码分开 #####  
【好处】可避免不小心将测试和产品二进制文件一起打包；很多构建工具都要求测试位于特定源代码目录。  </br>
常见的做法是至少创建两个源代码目录，将实现代码放在目录 src/main/java 中，并将测试代码放在目录 src/test/java 中。
##### 将测试类和实现放在一个包中 #####    
【好处】知道测试和代码位于同一个包中有助于更快找到代码。    </br>
测试和代码虽然位于同一个包，但位于不同的源代码目录。  
##### 以类似于受测类的方式给测试类命名 #####  
【好处】知道测试和受测类的名称类似后，有助于快速找到受测类。  </br>
一种常见的做法是，也这样给测试命名，即为实现类加上后缀 Test 。
##### 给测试方法指定描述性名称 #####  
【好处】有助于明白测试的目标。  </br>
使用对测试进行描述的方法名时，有助于掌握测试失败的原因，以及在什么情况下通过添加测试可提高代码覆盖率。  
必须明确指出测试前设置了哪些条件、测试将执行哪些操作以及期望的结果。
</br>
给测试方法命名的方式有很多，我们选择的方式是采用BDD场景中使用的 Given/When/Then。  

    语法： Given 部分描述前置条件， When 部分描述操作，而 Then 部分描述期望的结果。
如果测试没有前置条件（这通常是在用 @Before 和 @BeforeClass 注解的方法中设置的），可省略Given 部分。
</br>
不要完全依赖注释以提供有关测试目标的信息。  
因为从IDE执行测试时，注释不会出现，它们也不会出现在CI或构建工具生成的报告中。
