package model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.GameBoardImpl;

public class BishopTest {

	Bishop bishop;
	GameBoardImpl gb;

	@Before
	public void setUp() throws Exception {

		bishop = new Bishop("white", 1, 0);

	}

	// CHECK MOVEMENT FOR BISHOP IS FALSE - INVALID MOVEMENT 
	@Test
	public void checkmovemnentBishopReturnsFalse() {
		assertEquals(false, bishop.checkMovement(gb, 0, 0));
	}
	
	// CHECK MOVEMENT FOR BISHOP IS TRUE - VALID MOVEMENT 
	@Test
	public void checkmovemnentBishopReturnsTrue() {
		assertEquals(true, bishop.checkMovement(gb, 0, 1));
	}


}
