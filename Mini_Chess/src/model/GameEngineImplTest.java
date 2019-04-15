package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameEngineImplTest {

	BasePlayer player;
	GameEngineImpl gameEngine;

	@Before
	public void setUp() throws Exception {

		player = new BasePlayer("100", 10, "", 100);
		gameEngine = new GameEngineImpl();

	}

	@Test
	public void testGetID() {
		assertEquals("30", player.getID());
	}

	@Test
	public void testgetAllPlayer() {
		gameEngine.addPlayer(player);
		assertEquals(1, gameEngine.getAllPlayers().size());

	}

	@Test
	public void testRemovePlayer() {
		gameEngine.removePlayer(player);
		assertEquals(false, gameEngine.removePlayer(player));
	}

	@Test
	public void testAddPlayer() {
		gameEngine.addPlayer(player);
		assertEquals(true, gameEngine.getAllPlayers().containsKey(player.getID()));
	}

}

// package model;

// import static org.junit.Assert.*;

// import org.junit.Before;
// import org.junit.Test;

// public class GameEngineImplTest extends GameEngineImpl {

// BasePlayer p;
// GameEngineImpl gameEngine;

// @Before
// public void setUp() throws Exception {

// p = new BasePlayer("30","password1".hashCode(), "ChessGuy", 100);
// gameEngine = new GameEngineImpl();

// }

// @Test
// public void testGetID() {
// assertEquals("30", p.getID());
// }

// @Test
// public void testgetAllPlayer() {
// //gameEngine.addPlayer(p);
// //assertEquals(1, gameEngine.getAllPlayers().size());

// }

// @Test
// public void testAddPlayer() {
// //gameEngine.addPlayer(p);
// //assertEquals(true, gameEngine.getAllPlayers().containsKey(p.getID()));
// }

// }