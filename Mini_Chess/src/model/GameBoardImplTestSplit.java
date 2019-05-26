package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.piece.Bishop;
import model.piece.Knight;
import model.piece.Rook;

public class GameBoardImplTestSplit {

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

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testSplitRookKnight() {
		assertTrue(mainBoard.movePiece("r2w", 5, 3));
		assertTrue(mainBoard.getPiece(5,3) instanceof Rook);
		assertTrue(mainBoard.getPiece(3,3) instanceof Knight);
	}
	
	@Test
	public void testSplitKnightRook() {
		assertTrue(mainBoard.movePiece("K1w", 2, 5));
		assertTrue(mainBoard.getPiece(3,3) instanceof Rook);
		assertTrue(mainBoard.getPiece(2,5) instanceof Knight);
	}
	
	// another move piece method that takes a boolean parameter, whether split or move whole thing
	
	@Test
	public void testSplitKnightBishop() {
		assertTrue(mainBoard.movePiece("K2w", 3, 5));
		assertTrue(mainBoard.getPiece(3,5) instanceof Knight);
		assertTrue(mainBoard.getPiece(2,3) instanceof Bishop);
	}
	
	@Test
	public void testSplitBishopKnight() {
		assertTrue(mainBoard.movePiece("b2w", 4, 5));
		assertTrue(mainBoard.getPiece(4,5) instanceof Bishop);
		assertTrue(mainBoard.getPiece(2,3) instanceof Knight);
	}
	
	@Test
	public void testSplitRookBishop() {
		assertTrue(mainBoard.movePiece("r1w", 0, 5));
		assertTrue(mainBoard.getPiece(0,5) instanceof Rook);
		assertTrue(mainBoard.getPiece(1,5) instanceof Bishop);
	
	}
	
	@Test
	public void testSplitBishopRook() {
		assertTrue(mainBoard.movePiece("b1w", 0, 4));
		assertTrue(mainBoard.getPiece(0,4) instanceof Bishop);
		assertTrue(mainBoard.getPiece(1,5) instanceof Rook);
	}
	
	

}

/*
assertTrue(mainBoard.movePiece("r1w", 1, 5));
assertTrue(mainBoard.getPiece(1, 5) instanceof Bishop);
assertTrue(mainBoard.getPiece(1,5).getMergee())
*/