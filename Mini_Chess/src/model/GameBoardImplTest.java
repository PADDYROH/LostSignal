package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.piece.Bishop;
import model.piece.Knight;
import model.piece.Piece;
import model.piece.Rook;

public class GameBoardImplTest {

	GameBoardImpl gb;

	@Before
	public void setUp() throws Exception {

		gb = new GameBoardImpl();

	}

	// check gameBoard has correct number of pieces
	@Test
	public void testGameBoard() {
		assertEquals(12, gb.getPieces().size());
	}

	// test piece can't move to its own pos
	@Test
	public void moveToSamePosition() {
		assertEquals(false, gb.movePiece("r1", 0, 0));

	}

	// Attempt to move a rook by two cells
	@Test
	public void moveRook2() {

		gb.movePiece("r1w", 0, 3);

		assertEquals("r1w", gb.getChessBoard()[0][3]);

	}

	// Attempt to move a rook by one cell
	@Test
	public void moveRook1() {

		gb.movePiece("r1w", 0, 4);

		assertEquals("r1w", gb.getChessBoard()[0][4]);

	}

	// Attempt to move a rook piece in any direction other than horizontally or
	// vertically fails
	@Test
	public void checkForIllegalDirectionRook() {

		assertEquals(false, gb.movePiece("r1w", 1, 4));
	}

	/*
	 * Attempt to move a bishop piece diagonally up to one cell, succeeds when there
	 * are no pieces.
	 */
	@Test
	public void moveBishopBy1() {
		gb.movePiece("b1", 1, 0);
		assertEquals("b1", gb.getChessBoard()[1][0]);
	}

	/*
	 * Attempt to move a bishop piece diagonally up to two cells, succeeds when
	 * there are no pieces.
	 */
	@Test
	public void moveBishopBy2() {
		gb.movePiece("b2", 2, 2);
		assertEquals("b2", gb.getChessBoard()[2][2]);
	}

	// Attempt to move a bishop piece in any direction other than diagonally fails
	@Test
	public void checkForIllegalDirectionBishop() {

		assertEquals(false, gb.movePiece("b2", 0, 0));
	}

	// Attempt to move a knight piece along L shape (2 + 1) succeeds
	@Test
	public void moveKnightBy2by1() {
		gb.movePiece("K1", 1, 2);
		assertEquals("K1", gb.getChessBoard()[1][2]);
	}

	// Attempt to move a knight piece to any other cell fails
	@Test
	public void checkForIllegalDirectionKnight() {

		assertEquals(false, gb.movePiece("K1", 0, 0));
	}

	// Attempt to move a knight piece over another piece succeeds @Test
	@Test
	public void knightJumpOverPiece() {
		gb.movePiece("r1", 0, 1);
		gb.movePiece("r1", 2, 1);
		gb.movePiece("K1", 1, 2);

		assertEquals("K1", gb.getChessBoard()[1][2]);
	}

	// Attempt to move a rook piece in horizontal or vertical directions bypassing
	// other pieces fails
	@Test
	public void checkForBlockingPiecesRook() {

		gb.movePiece("r1w", 0, 3);
		gb.movePiece("r1w", 0, 2);
		gb.movePiece("r1w", 1, 2);
		gb.movePiece("b2", 2, 2);

		assertEquals(false, gb.movePiece("r1w", 3, 2));

	}

	// Attempt to move a bishop piece in diagonal directions bypassing
	// other pieces fails
	@Test
	public void checkForBlockingPiecesBishop() {

		gb.movePiece("r2", 5, 2);
		gb.movePiece("r2", 3, 2);
		gb.movePiece("b1", 2, 1);

		assertEquals(false, gb.movePiece("b1", 4, 3));

	}

	// Attempt to get the piece in a position that has no piece returns null
	@Test
	public void checkNullPiece() {
		assertEquals(gb.getPiece(3, 3), null);
	}

	@Test
	public void checkMoveOffBoard() {
		gb.movePiece("r2", 6, 0);

		assertEquals(gb.getPiece(5, 0), gb.getPieces().get("r2"));
	}

	@Test
	public void checkMoveToOccupiedPosition() {
		gb.movePiece("r2", 4, 0);
		assertEquals(gb.getPiece(5, 0), gb.getPieces().get("r2"));
	}

	@Test
	public void checkInitialBoard() {
		if (!(gb.getPiece(0, 0) instanceof Piece)) {
			fail("Board failed to initialize.");
		}
		if (!(gb.getPiece(5, 0) instanceof Piece)) {
			fail("Board failed to initialize.");
		}
		if (gb.getPiece(3, 3) != null) {
			fail("Board failed to initialize.");
		}
	}

	// place a bishop on-top of a rook  - should keep a rook on the board with bishop attributes 
	@Test
	public void mergeBishopToRook() {
		gb.movePiece("r1", 0, 1);
		gb.movePiece("b1", 0, 1);

		assertEquals(true, gb.getPiece(0, 1) instanceof Rook);

	}
	// place a rook on-top of a bishop  - should keep a bishop on the board with rook attributes 

	@Test
	public void mergeRookToBishop() {
		gb.movePiece("b1", 0, 1);
		gb.movePiece("r1", 0, 1);

		assertEquals(true, gb.getPiece(0, 1) instanceof Bishop);
	}

	@Test
	public void mergeKinghtToRook() {
		gb.movePiece("k1", 1, 2);
		gb.movePiece("r1", 0, 2);
		gb.movePiece("r1", 1, 2);

		assertEquals(true, gb.getPiece(1, 2) instanceof Knight);

	}

	@Test
	public void mergeRookToKnight() {

		gb.movePiece("r1", 0, 2);
		gb.movePiece("r1", 1, 2);
		gb.movePiece("k1", 1, 2);

		assertEquals(true, gb.getPiece(1, 2) instanceof Rook);

	}

	// place a Rook on-top of a Rook
	@Test
	public void mergeRookToRook() {
		gb.movePiece("r1", 0, 1);
		gb.movePiece("r1", 2, 1);
		gb.movePiece("r2", 5, 1);

		assertEquals(false, gb.movePiece("r2", 5, 2));

	}

	@Test
	public void mergeBishopToKnight() {
		gb.movePiece("b1", 0, 1);
		gb.movePiece("k1", 0, 1);
		assertEquals(true, gb.getPiece(1, 2) instanceof Bishop);
	}

	@Test
	public void mergeKnightToBishop() {
		gb.movePiece("k1", 0, 1);
		gb.movePiece("b1", 0, 1);
		assertEquals(true, gb.getPiece(1, 2) instanceof Knight);
	}

	@Test
	public void KnightToKnight() {
		gb.movePiece("k1", 0, 1);
		gb.movePiece("k2", 2, 2);

		assertEquals(false, gb.movePiece("k2", 0, 1));

	}

}
