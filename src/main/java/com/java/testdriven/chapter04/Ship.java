package com.java.testdriven.chapter04;

public class Ship {
	
	/***    ----------需求 1------------  
	 *		给定军舰的起始位置(x, y)以及它面向的方向 （N、S、E或W） ）。   ***/

	private final Location location;
	
	public Location getLocation() {
		return location;
	}
	
	public Ship(Location location) {
		this.location = location;
	}
	
	/***    ----------需求 2------------
	 *		实现让军舰前进和后退的命令（f和b）。   ***/

	/**
	 * 	前进
	 *	@return
	 */
	public boolean moveForward() {
//		return location.forward();
		return location.forward(planet.getMax(), planet.getObstacles());
	}
	/**
	 * 	后退
	 *	@return
	 */
	public boolean moveBackward() {
//		return location.backward();
		return location.backward(planet.getMax(), planet.getObstacles());
	}
	
	/***    ----------需求 3------------ 
	 *		实现让军舰左转和右转的命令（l和r）。   ***/

	/**
	 * 	左转
	 *	@return
	 */
	public void turnLeft() {
		location.turnLeft();
	}
	/**
	 * 	右转
	 *	@return
	 */
	public void turnRight() {
		location.turnRight();
	}
	
	/***    ----------需求 4------------ 
	 *		军舰可接收一个包含命令的字符串（例如， lrfb 相当于左转、右转、前进再后退）。   ***/

	/**
	 * 	
	 *	@param commands
	 *	@return	指出每个命令的状态，使用 O 表示OK，用 X 表示失败
	 */
	public String receiveCommands(String commands) {
		StringBuilder output = new StringBuilder();
		for(char command:commands.toCharArray()) {
			boolean status = true;
			switch (command) {
			case 'f':
				status = moveForward();
				break;
			case 'b':
				status = moveBackward();
				break;
			case 'l':
				turnLeft();
				break;
			case 'r':
				turnRight();
				break;
			default:
				break;
			}
            if (status) {
                output.append("O");
            } else {
                output.append("X");
            }
		}
		return output.toString();
	}
	
	/***    ----------需求 5------------ 
	 *		实现从网格的一边转到另一边。   ***/
	
	// 将 X 坐标和 Y 坐标为最大值的 Planet 对象传递给 Ship 构造函数。
	private Planet planet;
	public Planet getPlanet() {
		return planet;
	}
	public Ship(Location location,Planet planet) {
		this.location = location;
		this.planet = planet;
	}

	
	/***    ----------需求 6------------ 
	 *		每次移动前都进行障碍检测。
	 *		如果执行指定的命令将遇到障碍，军舰应放弃移动，留在原地并报告遇到的障碍。   ***/
	
}
