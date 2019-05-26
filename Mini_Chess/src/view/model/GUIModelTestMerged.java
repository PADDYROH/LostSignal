package view.model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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

	// @Test
	// void testSelectRook() {
	// gUIM.selectPiece(
	// }
	//
	// @Test
	// void testSelectKnight() {
	//
	// }
	//
	// @Test
	// void testSelectBishop() {
	//
	// }

	@Test
	void testSelectRookKnight() {
		gUIM.selectPiece("r1w");
		Tile[][] tiles = gUIM.getTiles();
		List<Tile> greenList = new ArrayList<Tile>();
		
		greenList.add(tiles[3][3]);
		greenList.add(tiles[3][2]);
		greenList.add(tiles[3][1]);
		greenList.add(tiles[3][4]);
		greenList.add(tiles[2][1]);
		greenList.add(tiles[2][3]);
		greenList.add(tiles[1][2]);
		greenList.add(tiles[1][3]);
		greenList.add(tiles[1][4]);
		greenList.add(tiles[4][1]);
		greenList.add(tiles[4][3]);
		greenList.add(tiles[5][2]);
		greenList.add(tiles[5][3]);
		greenList.add(tiles[5][4]);
		
		for(int r = 0; r < tiles.length; r++) {
			for(int c = 0; c < tiles[r].length; c++) {
				if(greenList.contains(tiles[r][c])) {
					assertEquals(tiles[r][c].getBackground(), Color.GREEN);
				} else if (r == 2 && c == 3) {
					assertEquals(tiles[r][c].getBackground(), Color.GRAY);
				} else {
					assertEquals(tiles[r][c].getBackground(), Color.RED);
				}
			}
		}		


	}

	@Test
	void testSelectRookBishop() {
		gUIM.selectPiece("");
	}

	@Test
	void testSelectBishopRook() {

	}

	@Test
	void testSelectWrongPiece() {

	}

}
