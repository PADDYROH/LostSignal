
package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameEngineImplTest extends GameEngineImpl {

	BasePlayer p;
	GameEngineImpl gameEngine;

	@Before
	public void setUp() throws Exception {

		p = new BasePlayer("30", 2, "ChessGuy", 100);
		gameEngine = new GameEngineImpl();

	}

	@Test
	public void testGetID() {
		assertEquals("30", p.getID());
	}

	@Test
	public void testgetAllPlayer() {
		gameEngine.addPlayer(p);
		assertEquals(1, gameEngine.getAllPlayers().size());

	}

	@Test
	public void testAddPlayer() {
		gameEngine.addPlayer(p);
		assertEquals(true, gameEngine.getAllPlayers().containsKey(p.getID()));
	}

}

// package model;

// import static org.junit.Assert.*;

// import org.junit.Before;
// import org.junit.Test;

// public class GameEngineImplTest extends GameEngineImpl {

// 	BasePlayer p;
// 	GameEngineImpl gameEngine;

// 	@Before
// 	public void setUp() throws Exception {

// 		p = new BasePlayer("30","password1".hashCode(), "ChessGuy", 100);
// 		gameEngine = new GameEngineImpl();

// 	}

// 	@Test
// 	public void testGetID() {
// 		assertEquals("30", p.getID());
// 	}

// 	@Test
// 	public void testgetAllPlayer() {
// 		//gameEngine.addPlayer(p);
// 		//assertEquals(1, gameEngine.getAllPlayers().size());

// 	}

// 	@Test
// 	public void testAddPlayer() {
// 		//gameEngine.addPlayer(p);
// 		//assertEquals(true, gameEngine.getAllPlayers().containsKey(p.getID()));
// 	}

// }

