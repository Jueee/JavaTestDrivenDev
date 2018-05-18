package com.java.testdriven.chapter06;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeBeanTest {

	private TicTacToeBean bean;
	private final int turn = 17;
	private final int x = 2;
	private final int y = 3;
	private final char player = 'X';

	@Before
	public void before() {
		bean = new TicTacToeBean(turn, x, y, player);
	}

	@Test
	public void whenInstantiatedThenIdIsStored() {
		assertEquals(turn, bean.getTurn());
	}

	@Test
	public void whenInstantiatedThenXIsStored() {
		assertEquals(x, bean.getX());
	}

	@Test
	public void whenInstantiatedThenYIsStored() {
		assertEquals(y, bean.getY());
	}

	@Test
	public void whenInstantiatedThenPlayerIsStored() {
		assertEquals(player, bean.getPlayer());
	}

}
