package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PlayerTest{
	
	BasePlayer player;

	@Before
	public void setUp() throws Exception {
		// given
		player = new BasePlayer("100", 10, "", 100);
		// public BasePlayer(String playerID, int playerPasswordHash, String playerName,int playerPoints) {
	}

	@Test
	public void testsetName() {
		// when
		player.setName("joe");
		// then
		assertEquals("joe", player.getName());
	}

	public void testgetName() {
		// when
		player.setName("joe");
		// then
		assertEquals("joe", player.getName());
	}

	@Test
	public void testgetPoint() {
		// when
		player.setPoints(100);
		// then
		assertEquals(100, player.getPoints());
	}

	@Test
	public void testSetPoint() {
		// when
		player.setPoints(100);
		// then
		assertEquals(100, player.getPoints());
	}

	@Test
	public void testSetPasswordHash() {
		// when
		player.setPasswordHash(100);
		// then
		assertEquals(100, player.getPasswordHash());
	}

	@Test
	public void testGetPasswordHash() {
		// when
		player.setPasswordHash(100);
		// then
		assertEquals(100, player.getPasswordHash());
	}

	@Test
	public void testsetID() {
		// when
		player.setID("100");
		// then
		assertEquals(100, player.getID());
	}

	@Test
	public void testgetID() {
		// when
		player.setID("100");
		// then
		assertEquals(100, player.getID());
	}

}
