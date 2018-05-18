package com.java.testdriven.chapter05;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class Course3TestTheLastTest {

	Course3TestTheLast test;
	
	@BeforeMethod
	public void before() {
		test = new Course3TestTheLast();
	}
	
	public void putDiscTest() {
		int[] gameplay = new int[] {1, 2, 2, 3, 4, 3, 3, 4, 4, 5, 4};
        for (int column : gameplay) {
        	test.putDisc(column);
        }
	}
	
	@Test(enabled = false)
	public void putDiscRandom() {
		Random random = new Random();
		for (int i = 0; i < 200; i++) {
			test.putDisc(random.nextInt(7)+1);
		}
	}

}
