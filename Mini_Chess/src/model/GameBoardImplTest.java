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

	//  MOVEMENT FOR ROOK
	@Test
	public void testRookMovement() {
		assertEquals(true, gb.movePiece(gb.getChessBoard()[0][0], 1, 0));
	}
	
	//  MOVEMENT FOR KNIGHT 
	@Test
	public void testKnightMovement() {
		assertEquals(true, gb.movePiece(gb.getChessBoard()[2][0], 1, 2));
	}

	//  MOVEMENT FOR BISHOP
	@Test
	public void testBishopMovement() {
		assertEquals(true, gb.movePiece(gb.getChessBoard()[1]0], 0, 1));
	}

	// test if hash map has pieces
	@Test
	public void testGameBoard() {
		assertEquals(12, gb.getPieces().size());
	}

}
