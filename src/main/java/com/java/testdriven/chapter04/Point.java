package com.java.testdriven.chapter04;

/**
 * 	Point 类存储了坐标 x 和 y 
 *	
 *	@author hzweiyongqiang
 */
public class Point {

    private int x;
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    private int y;
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
