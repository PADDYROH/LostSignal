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
		pm.addPlayer(new BasePlayer("001", "password1".hashCode(), "John F. Kennedy", 0));
		pm.addPlayer(new BasePlayer("002", "password2".hashCode(), "Jimmy Barnes", 250));
		pm.addPlayer(new BasePlayer("003", "password3".hashCode(), "George Michael", 99999));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoadSave() {
		pm.savePlayers();
		
		Map<String, Player> tempPlayers = pm.loadPlayers();
		for(Player p : tempPlayers.values()) {
			String tempID = p.getID();
			assertEquals(tempID, players.get(tempID).getID());
			assertEquals(p.getPasswordHash(), players.get(tempID).getPasswordHash());
			assertEquals(p.getName(), players.get(tempID).getName());
			assertEquals(p.getPoints(), players.get(tempID).getPoints());	
		}
		
	}

}
