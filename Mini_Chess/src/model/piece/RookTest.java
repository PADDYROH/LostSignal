package model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.GameBoardImpl;

public class RookTest {

	Rook rook;
	GameBoardImpl gb;

	@Before
	public void setUp() throws Exception {

		rook = new Rook("white", 0, 0);

	}

	// CHECK MOVEMENT FOR ROOK IS FALSE - INVALID MOVEMENT 
	@Test
	public void checkmovemnentBishopReturnsFalse() {
		assertEquals(true, rook.checkMovement(gb, 0, 0));
	}
	
	// CHECK MOVEMENT FOR ROOK IS TRUE - VALID MOVEMENT 
	@Test
	public void checkmovemnentBishopReturnsTrue() {
		assertEquals(false, rook.checkMovement(gb, 0, 1));
	}

}
