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

	// check if valid move for Rook
	@Test
	public void testHashMap() {
		assertEquals(true, gb.movePiece(gb.getChessBoard()[0][0], 1, 0));
	}

	// test if hash map has pieces
	@Test
	public void testGameBoard() {
		assertEquals(12, gb.getPieces().size());
	}

}
