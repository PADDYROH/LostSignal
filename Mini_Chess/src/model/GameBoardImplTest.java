package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameBoardImplTest {

	GameBoardImpl gb;

	@Before
	public void setUp() throws Exception {

		gb = new GameBoardImpl();

	}

	@Test
	public void testHashMap() {
		assertEquals(12, gb.getPieces().size());
	}

	@Test
	public void testGameBoard() {
		assertEquals(12, gb.getPieces().size());
	}

}
