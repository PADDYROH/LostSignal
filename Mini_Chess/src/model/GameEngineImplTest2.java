package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GameEngineImplTest2 {
	
	Map<String, Player> players;
	GameEngine gE;
	@BeforeEach
	void setUp() throws Exception {
		PrintWriter writer = new PrintWriter(new File("players.txt"));
		writer.print("");
		writer.close();
		gE = new GameEngineImpl();
		players = new HashMap<String, Player>();
		players.put("001", new BasePlayer("001", "password1".hashCode(), "John F. Kennedy", 0));
		players.put("002", new BasePlayer("002", "password2".hashCode(), "Jimmy Barnes", 250));
		players.put("003", new BasePlayer("003", "password3".hashCode(), "George Michael", 99999));
		for(Player p : players.values()) {
			gE.getPlayerManager().addPlayer(p);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLoginInvalidID() {
		gE.login("005", "password1");
		assertEquals(gE.getWhitePlayer(), null);
		assertEquals(gE.getBlackPlayer(), null);
	}
	
	@Test
	void testLoginInvalidPassword() {
		gE.login("001", "wrongpassword");
		assertEquals(gE.getWhitePlayer(), null);
		assertEquals(gE.getBlackPlayer(), null);
	}
	
	@Test
	void testLoginValid() {
		gE.login("001", "password1");
		System.out.println(gE.getWhitePlayer());
		System.out.println(gE.getPlayerManager());
		assertEquals(gE.getWhitePlayer(), gE.getPlayerManager().getPlayer("001"));
		assertEquals(gE.getBlackPlayer(), null);
	}
	
	@Test
	void testDoubleLogin() { 
		gE.login("001", "password1");
		gE.login("001", "password1");
		assertEquals(gE.getWhitePlayer(),  gE.getPlayerManager().getPlayer("001"));
		assertEquals(gE.getBlackPlayer(), null);
	}
	
	@Test
	void testLogin2Players() {
		gE.login("001", "password1");
		gE.login("002", "password2");
		assertEquals(gE.getWhitePlayer(), gE.getPlayerManager().getPlayer("001"));
		assertEquals(gE.getBlackPlayer(), gE.getPlayerManager().getPlayer("002"));
	
	}
	
	@Test
	void testPointIncrease() {
		gE.login("001", "password1");
		gE.login("002", "password2");

		gE.setMaxTurns(10);
		gE.movePiece("r2w", 5, 3);
		gE.movePiece("r2", 5, 2);
		gE.movePiece("r2w", 5, 2);
		
		assertEquals(gE.getWhitePlayerPoints(), 5);
	}
	
	@Test
	void testPlayerSwitch() {
		gE.login("001", "password1");
		gE.login("002", "password2");

		gE.setMaxTurns(10);
		assertEquals(gE.getCurrentPlayer().getID(), "001");
		gE.movePiece("r2w", 5, 3);
		assertEquals(gE.getCurrentPlayer().getID(), "002");
		gE.movePiece("r2", 5, 2);
	
	}
	
	@Test
	void testMoveWrongPiece() {
		gE.login("001", "password1");
		gE.login("002", "password2");

		gE.setMaxTurns(10);
		gE.movePiece("r2", 5, 2);
		assertEquals(gE.getCurrentPlayer().getID(), "001");
		assertEquals(gE.getGameBoard().getPiece(5, 2), null);
	}
}
