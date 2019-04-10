package model.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.GameBoardImpl;

public class KnightTest {

	Knight knight;
	GameBoardImpl gb;

	@Before
	public void setUp() throws Exception {

		knight = new Knight("white", 0, 2);

	}

	// CHECK MOVEMENT FOR KNIGHT IS FALSE - INVALID MOVEMENT 
	@Test
	public void checkmovemnentBishopReturnsFalse() {
		assertEquals(false, knight.checkMovement(gb, 0, 0));
	}

	// CHECK MOVEMENT FOR ROOK IS TRUE - VALID MOVEMNT
	@Test
	public void checkmovemnentBishopReturnsTrue() {
		assertEquals(true, knight.checkMovement(gb, 1, 2));
	}
}
