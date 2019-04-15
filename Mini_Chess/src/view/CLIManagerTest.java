package view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.GameEngine;
import model.GameEngineImpl;

class CLIManagerTest {
	GameEngine gE;
	
	@Before
	void setUp() {
		gE = new GameEngineImpl();
		gE.setPlayer1(new BasePlayer("s3602361",1234,Ryan",4));
		gE.setPlayer2(new BasePlayer());
	}
	
	@Test
	void testDisplayPlayers() {
		fail("Not yet implemented");
		assertEquals(gE.getPlayer1().getName(), "Joe");
	}
	
	@Test
	void testMove() {
		
	}
}
