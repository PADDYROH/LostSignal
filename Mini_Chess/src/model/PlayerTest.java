package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PlayerTest{
	
	BasePlayer player;

	@Before
	public void setUp() throws Exception {
		// given
		player = new BasePlayer("100", "password123".hashCode(), "johnny the goose", 100);
		// public BasePlayer(String playerID, int playerPasswordHash, String playerName,int playerPoints) {
	}
	
	@Test
	public void testgetID() {
		assertEquals("100", player.getID());
	}

	@Test
	public void testgetGetName() {
		// when
		player.setName("joe");
		// then
		assertEquals("joe", player.getName());
	}
	
	@Test
	public void testSetGetName() {
		// when
		player.setName("joe");
		// then
		assertEquals("joe", player.getName());
	}

	@Test
	public void testCheckPasswordHash() {
		assertEquals("password123".hashCode(), player.getPasswordHash());
	}

	@Test
	public void testGetPoints() {
		// when
		player.setPoints(100);
		// then
		assertEquals(100, player.getPoints());
	}

	@Test
	public void testSetPoint() {
		// when
		player.setPoints(500);
		// then
		assertEquals(500, player.getPoints());
	}

	

}
