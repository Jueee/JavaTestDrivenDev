package com.java.testdriven.chapter04;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

// 使用TestNG时，在类级指定注解 @Test 后，无需再指定应将哪些方法视为测试。
// 在这里，所有的公有方法都被视为TestNG测试。
@Test
public class ShipSpec {
	
	/***    ----------需求 1------------    ***/
	
	private Ship ship;
	
	private Location location;
	
	private Planet planet;
	
	/**
	 * 	将部分代码移到了用 @BeforeMethod 注解的方法中，以免编写后面的规范时重复这些代码。
	 */
	@BeforeMethod
	public void beforeTest() {
		location = new Location(new Point(21, 13), Direction.NORTH);
		Point max = new Point(50, 50);
		List<Point> obstacles = new ArrayList<Point>();
        obstacles.add(new Point(44, 44));
        obstacles.add(new Point(45, 46));
		planet = new Planet(max,obstacles);
		ship = new Ship(location,planet);
	}

	/**
	 * 	传递给构造函数 Ship 的 Location 对象是否被存储；能否通过获取函数 getLocation 访问它。
	 */
	public void whenInstantiatedThenLocationIsSet() {
		assertEquals(ship.getLocation(), location);
	}
	
	/***    ----------需求 2------------    ***/
	
	/**
	 * 	前进功能
	 * 	由于Location已包含方法 forward ，因此只需确认正确调用了这个方法。
	 * 	为此，我们创建一个新的 Location 对象—— expected ，调用其方法 forward ，再将这个对象同调用方法 moveForward 后的军舰位置进行比较。
	 */
	public void whenMoveForwardThenForward() {
		Location expected = location.copy();
		expected.forward();
		ship.moveForward();
		assertEquals(ship.getLocation(), expected);
	}
	/**
	 * 	后退功能
	 */
	public void whenMoveBackwardThenBackward() {
		Location expected = location.copy();
		expected.backward();
		ship.moveBackward();
		assertEquals(ship.getLocation(), expected);
	}
	
	/***    ----------需求 3------------    ***/

	/**
	 * 	左转功能
	 */
	public void whenTurnLeftThenLeft() {
		Location expected = location.copy();
		expected.turnLeft();
		ship.turnLeft();
		assertEquals(ship.getLocation(), expected);
	}
	/**
	 * 	右转功能
	 */
	public void whenTurnRightThenRight() {
		Location expected = location.copy();
		expected.turnRight();
		ship.turnRight();
		assertEquals(ship.getLocation(), expected);
	}
	
	/***    ----------需求 4------------    ***/
	
	/**
	 * 	包含字符 f （前进）的命令参数：
	 */
	public void whenReceiveCommandsFThenForward() {
		Location expected = location.copy();
		expected.forward();
		ship.receiveCommands("f");
		assertEquals(ship.getLocation(), expected);
	}
	/**
	 * 	发送命令字符串的选项
	 */
	public void whenReceiveCommandsThenAllAreExecuted() {
		Location expected = location.copy();
		expected.turnRight();
		expected.forward();
		expected.turnLeft();
		expected.backward();
		ship.receiveCommands("rflb");
		assertEquals(ship.getLocation(), expected);
	}

	
	/***    ----------需求 5------------    ***/
	
	/**
	 * 	将星球的大小定义为50×50，并使用这种大小实例化 Planet 类，再将生成的对象传递给 Ship 构造函数。
	 */
	public void whenInstantiatedThenPlanetIsStored() {
		assertEquals(ship.getPlanet(), planet);
	}
	
	/**
	 * 	检查军舰跨越网格右边缘后的行为。
	 */
	public void overpassEastBoundary() {
		location.setDirection(Direction.EAST);
		location.getPoint().setX(planet.getMax().getX());
		ship.receiveCommands("f");
		assertEquals(location.getX(), 1);
	}
	

	/***    ----------需求 6------------    ***/
	
	/**
	 * 	如果执行指定的命令将遇到障碍，军舰应放弃移动，留在原地并报告遇到的障碍。
	 */
    public void whenReceiveCommandsThenOForOkAndXForObstacle() {
        List<Point> obstacles = new ArrayList<Point>();
        obstacles.add(new Point(location.getX() + 1, location.getY()));
        ship.getPlanet().setObstacles(obstacles);
        String status = ship.receiveCommands("rflb");
        assertEquals(status, "OXOO");
    }
}
