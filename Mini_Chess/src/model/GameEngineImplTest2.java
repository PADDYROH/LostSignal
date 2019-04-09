package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.utilities.PlayerManager;

class GameEngineImplTest2 {
	//PlayerManager pm; 
	Map<String, Player> players;
	GameEngine gE;
	@BeforeEach
	void setUp() throws Exception {
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
		assertEquals(gE.getPlayer1(), null);
		assertEquals(gE.getPlayer2(), null);
	}
	
	@Test
	void testLoginInvalidPassword() {
		gE.login("001", "wrongpassword");
		assertEquals(gE.getPlayer1(), null);
		assertEquals(gE.getPlayer2(), null);
	}
	
	@Test
	void testLoginValid() {
		gE.login("001", "password1");
		System.out.println(gE.getPlayer1());
		System.out.println(gE.getPlayerManager());
		assertEquals(gE.getPlayer1(), gE.getPlayerManager().getPlayer("001"));
		assertEquals(gE.getPlayer2(), null);
	}
	
	@Test
	void testDoubleLogin() {
		gE.login("001", "password1");
		gE.login("001", "password1");
		assertEquals(gE.getPlayer1(),  gE.getPlayerManager().getPlayer("001"));
		assertEquals(gE.getPlayer2(), null);
	}
	
	@Test
	void testLogin2Players() {
		gE.login("001", "password1");
		gE.login("002", "password2");
		assertEquals(gE.getPlayer1(), gE.getPlayerManager().getPlayer("001"));
		assertEquals(gE.getPlayer2(), gE.getPlayerManager().getPlayer("002"));
	
	}
}
