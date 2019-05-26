package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.piece.Bishop;
import model.piece.Knight;

public class GameBoardImplMoveTest {

	GameBoard mainBoard;

	@Before
	public void setUp() throws Exception {
		mainBoard = new GameBoardImpl();
		mainBoard.movePiece("r1w", 1, 5);

		mainBoard.movePiece("K2w", 2, 3);
		mainBoard.movePiece("b2w", 2, 3);

		mainBoard.movePiece("K1w", 3, 3);
		mainBoard.movePiece("r2w", 5, 3);
		mainBoard.movePiece("r2w", 3, 3);
	}
	/*
	 * @After public void tearDown() throws Exception { }
	 * 
	 * @Test public void testMoveRookBishop() {
	 * assertTrue(mainBoard.movePiece("b1w", 0, 4, false));
	 * assertTrue(mainBoard.getPiece(0, 4) instanceof Bishop);
	 * assertNull(mainBoard.getPiece(1, 5)); }
	 * 
	 * @Test public void testMoveRookKnight() {
	 * assertTrue(mainBoard.movePiece("K1w", 2, 5, false));
	 * assertTrue(mainBoard.getPiece(2, 5) instanceof Knight);
	 * assertNull(mainBoard.getPiece(3, 3)); }
	 * 
	 * @Test public void testMoveKnightBishop() {
	 * assertTrue(mainBoard.movePiece("K2w", 3, 5, false));
	 * assertTrue(mainBoard.getPiece(0, 3) instanceof Knight);
	 * assertNull(mainBoard.getPiece(3, 5)); }
	 */

}
