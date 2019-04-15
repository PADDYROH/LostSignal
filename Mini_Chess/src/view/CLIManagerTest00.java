package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.GameEngine;
import model.GameEngineImpl;

public class CLIManagerTest00 {
	CLIManager mainManager;
	GameEngine mainEngine;
	@Before
	public void setUp() throws Exception {
		GameEngine mainEngine = new GameEngineImpl();
		mainManager = new CLIManager(mainEngine);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		mainManager.updateBoard();
	}

}
