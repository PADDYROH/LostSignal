package model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.GameBoardImpl;

public class BishopTest {


	GameBoardImpl gameBoard;

	@Before
	public void setUp() throws Exception {

		gameBoard = new GameBoardImpl();

	}

	// CHECK MOVEMENT FOR BISHOP IS FALSE - INVALID MOVEMENT
	@Test
	public void checkMovemnentBishopInvalid() {
		assertEquals(false, gameBoard.getPieces().get("b1").checkMovement(gameBoard, 0, 0));
	}
	
	
	// CHECK MOVEMENT FOR BISHOP IS TRUE - VALID MOVEMENT
	@Test
	public void checkMovemnentBishopValid() {
		assertEquals(true, gameBoard.getPieces().get("b1").checkMovement(gameBoard, 0, 1));
	}



}
