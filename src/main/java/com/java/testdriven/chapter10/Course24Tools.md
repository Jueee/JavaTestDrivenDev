### 工具 ###  
##### 代码覆盖率和持续集成（CI ）工具 #####
【好处】确保测试覆盖每个角落。  
</br>
为判断是否测试了所有代码、分支以及复杂度，代码覆盖率工具很有帮助：
1.	JaCoCo（[http://www.eclemma.org/jacoco/](http://www.eclemma.org/jacoco/)）
2.	Clover（[https://www.atlassian.com/software/clover/overview](https://www.atlassian.com/software/clover/overview)）
3.	Cobertura（[http://cobertura.github.io/cobertura/](http://cobertura.github.io/cobertura/)）

持续集成工具：
1.	Jenkins（[http://jenkins-ci.org/](http://jenkins-ci.org/)）
2.	Hudson（[http://hudson-ci.org/](http://hudson-ci.org/)）
3.	Travis（[https://travis-ci.org/](https://travis-ci.org/)）
4.	Bamboo（[https://www.atlassian.com/software/bamboo](https://www.atlassian.com/software/bamboo)）。

##### 结合使用TDD 和BDD #####
【好处】涵盖面向开发人员的单元测试和面向客户的功能测试。  
</br>
TDD可提高开发速度，帮助完成设计，并通过快速反馈赋予开发人员以信心；</br>
BDD更适合用于集成测试和功能测试，它提供了更佳的需求收集流程（通过叙述收集），还是一种更佳的沟通方式（通过场景与客户沟通）。</br>
</br>
推荐使用TDD提高代码覆盖率以及提供快速反馈，使用BDD自动化验收测试。</br>
TDD主要致力于白盒测试，BDD通常致力于黑盒测试，但它们都专注于质量保证而不是质量检查。</br>
