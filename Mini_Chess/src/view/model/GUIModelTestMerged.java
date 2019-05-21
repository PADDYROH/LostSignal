package view.model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.GameBoardImpl;
import model.GameEngine;
import model.GameEngineImpl;
import view.CLIManager;
import view.GUIManager;
import view.UserInterfaceManager;
import view.components.Tile;

class GUIModelTestMerged {

	GameEngine gE;
	GUIManager gUIM;
	@BeforeEach
	void setUp() throws Exception {
		gE = new GameEngineImpl();
		gUIM = new GUIManager(gE);
		gE.addUIManager(gUIM);
		
		gE.login("1", "123");
		gE.login("2", "123");
		
		gE.movePiece("r1w", 1, 5);
		gE.movePiece("r1", 0, 1);
		
		gE.movePiece("K2w", 2, 3);
		gE.movePiece("r1", 0, 0);
		gE.movePiece("b2w", 2, 3);
		gE.movePiece("r1", 0, 1);
		
		gE.movePiece("K1w", 3, 3);
		gE.movePiece("r1", 0, 0);
		gE.movePiece("r2w", 5, 3);
		gE.movePiece("r1", 0, 1);
		gE.movePiece("r2w", 3, 3);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void testSelectRook() {
//		gUIM.selectPiece(
//	}
//	
//	@Test
//	void testSelectKnight() {
//		
//	}
//	
//	@Test
//	void testSelectBishop() {
//		
//	}
	
	@Test
	void testSelectRookKnight() {
		gUIM.selectPiece("K2w");
		Tile[][] tiles = gUIM.getTiles();
		assertEquals(tiles[0][0].getBackground(), Color.GREEN);
	}
	
	@Test
	void testSelectRookBishop() {
		
	}
	
	@Test
	void testSelectBishopRook() {
		
	}
	
	@Test
	void testSelectWrongPiece() {
		
	}

}
