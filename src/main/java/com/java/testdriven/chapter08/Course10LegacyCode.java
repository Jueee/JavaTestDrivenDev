package com.java.testdriven.chapter08;

/**
 * 	遗留代码
 * 
 * 
 * 	“遗留代码就是不带测试的代码。为什么这样定义呢？因为它是客观的：要么带测试，要么不带测试。”	——Michael Feathers
 * 
 * 	【代码坏味】
 * 	坏味是代码中违背了基本设计元素并给设计质量带来负面影响的结构。
 * 	代码坏味通常不同于bug，它们从技术上说是正确的，不会导致程序无法正常运行。
 * 	而是昭示着设计存在缺陷，这些缺陷可能影响开发速度或增加未来出现bug或故障的风险。
 * 
 * 	遗留代码存在的一种常见坏味是无法测试。
 *	
 *	@author hzweiyongqiang
 */
public class Course10LegacyCode {

	/**
	 * 	“井字游戏”检查落子位置是否有效：
	 *	JaCoCo报告指出，测试覆盖了除最后一行（结束方法的大括号）外的所有代码。
	 *	@author hzweiyongqiang
	 */
	public class TicTacToe0{
		
		public void validatePosition(int x, int y) {
			if (x < 1 || x > 3) {
				throw new RuntimeException("X is outside board");
			}
			if (y < 1 || y > 3) {
				throw new RuntimeException("X is outside board");
			}
		}
	}
	
	/**
	 * 	重构代码片段
	 *	【注意】对于 RuntimeException 块中的消息，我们并未检查其正确性，虽然代码覆盖率报告指出“覆盖了所有分支”。
	 *	@author hzweiyongqiang
	 */
	public class TicTacToe1{
		public void validatePosition(int x, int y) {
			if (isOutSideTheBoard(x)) {
				throw new RuntimeException("X is outside board");
			}
			if (isOutSideTheBoard(y)) {
				throw new RuntimeException("X is outside board");
			}
		}
	
		private boolean isOutSideTheBoard(int position) {
			return position < 1 || position > 3;
		}
	}
	
	/**
	 * 	重构代码片段
	 *	也许，只要知道哪个代码行出现了什么样的异常就够了。
	 *	有鉴于此，我们决定删除这条未被测试的异常消息
	 *	@author hzweiyongqiang
	 */
	public class TicTacToe2{
		public void validatePosition(int x, int y) {
			if (isOutSideTheBoard(x)) {
				throw new RuntimeException("");
			}
			if (isOutSideTheBoard(y)) {
				throw new RuntimeException("");
			}
		}
	
		private boolean isOutSideTheBoard(int position) {
			return position < 1 || position > 3;
		}
	}
}
