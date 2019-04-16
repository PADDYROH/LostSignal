package model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.GameBoardImpl;

public class KnightTest {


	GameBoardImpl gameBoard;

	@Before
	public void setUp() throws Exception {

		gameBoard = new GameBoardImpl();

	}

	// CHECK MOVEMENT FOR ROOK IS FALSE - INVALID MOVEMENT
	@Test
	public void checkMovemnentRookInvalid() {
		assertEquals(false, gameBoard.getPieces().get("K1").checkMovement(gameBoard, 0, 0));
	}
	
	
	// CHECK MOVEMENT FOR ROOK IS TRUE - VALID MOVEMENT
	@Test
	public void checkMovemnentRookValid() {
		assertEquals(true, gameBoard.getPieces().get("K1").checkMovement(gameBoard, 0, 1));
	}
}
