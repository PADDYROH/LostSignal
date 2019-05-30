package view;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.GameBoardImpl;
import model.GameEngine;
import model.GameEngineImpl;

public class CLIManagerTest00 {
	CLIManager mainManager;
	GameEngine mainEngine;
	GameBoardImpl GameBoard;
	Object NewBoard;
	
	@Before
	public void setUp() throws Exception {
		GameEngine mainEngine = new GameEngineImpl();
		mainManager = new CLIManager(mainEngine);
	}
	
	@Test
	public void saveGameboard() throws Exception {
		GameBoard.movePiece("r1", 0, 1);
		//Object oldGameBoard;
		//GameBoard.saveGameBoard(oldGameBoard);
		//assertEquals(true,oldGameBoard.getPiece(0, 1));
	}
	
	@Before
	public void revert() throws Exception {
		GameEngine mainEngine = new GameEngineImpl();
		mainManager = new CLIManager(mainEngine);
		GameBoard.movePiece("r1", 0, 1);
	}

	@Test
	public void revertBGameBoard() throws Exception {
		GameBoard.movePiece("r1", 0, 1);
		GameBoard.movePiece("r1", 0, 2);
		//GameBoard.revert;
		//assertEquals(true, numTurns = 2);
		assertEquals(true,GameBoard.getPiece(0, 1));
	}
	
	@Test
	public void updateRevertGameboard() throws Exception {
		GameBoard.movePiece("r1", 0, 1);
		//GameBoard.updateGameBoard;
		//assertEquals(true,GameBoard.updateGameBoard.getPiece(0, 1));
	}

	@Test
	public void revertWGameBoard() throws Exception {
		GameBoard.movePiece("r1w", 0, 1);
		GameBoard.movePiece("r1w", 0, 2);
		//GameBoard.revert;
		assertEquals(true,GameBoard.getPiece(0, 1));
	}
//	@Test
	//public void test() {
		//mainManager.updateBoard(true);
	//}

}