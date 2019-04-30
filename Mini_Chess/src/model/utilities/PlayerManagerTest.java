package model.utilities;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import model.BasePlayer;
import model.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerManagerTest {
	PlayerManager pm; 
	Map<String, Player> players;
	@Before
	public void setUp() throws Exception {
		pm = new PlayerManager("players.txt");
		players = new HashMap<String, Player>();
		players.put("001", new BasePlayer("001", "password1".hashCode(), "John F. Kennedy", 0));
		players.put("002", new BasePlayer("002", "password2".hashCode(), "Jimmy Barnes", 250));
		players.put("003", new BasePlayer("003", "password3".hashCode(), "George Michael", 99999));
		for(Player p : players.values()) {
			pm.addPlayer(p);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoadSave() {
		pm.savePlayers();
		pm.removePlayer("001");
		pm.removePlayer("002");
		pm.removePlayer("003");
		pm.loadPlayers();
		
		for(Player p : pm.getAllPlayers().values()) {
			String tempID = p.getID();
			assertEquals(tempID, players.get(tempID).getID());
			assertEquals(p.getPasswordHash(), players.get(tempID).getPasswordHash());
			assertEquals(p.getName(), players.get(tempID).getName());
			assertEquals(p.getPoints(), players.get(tempID).getPoints());	
		}
		
	}
	
	@Test
	public void testRemovePlayer() {
		pm.savePlayers();
		pm.removePlayer("001");
		pm.removePlayer("002");
		pm.removePlayer("003");

		assertEquals(pm.getPlayer("001"), null);
		assertEquals(pm.getPlayer("002"), null);
		assertEquals(pm.getPlayer("003"), null);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRegisterSameID() {
		pm.addPlayer(new BasePlayer("001", "password1".hashCode(), "John F. Kennedy", 0));
		pm.addPlayer(new BasePlayer("001", "password2".hashCode(), "Tina Turner", 0));
	}
	
	@Test
	public void testAddPlayer() {
		pm.addPlayer(new BasePlayer("004", "password1".hashCode(), "Bruce Wayne", 999));
		assertEquals(pm.getPlayer("004").getName(), "Bruce Wayne");
	}

}
