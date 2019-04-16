package main;

import model.BasePlayer;
import model.GameBoardImpl;
import model.GameEngine;
import model.GameEngineImpl;
import model.Player;
import model.piece.Piece;
import view.CLIManager;
import view.UserInterfaceManager;

public class Driver {

	public static void main(String[] args) {

		TestClient test = new TestClient();
		GameEngine ge = new GameEngineImpl();
		UserInterfaceManager cLIM = new CLIManager(ge);
		ge.addUIManager(cLIM);

		
		
		ge.getPlayerManager().addPlayer(new BasePlayer("1", "1".hashCode(), "joe dempsie", 0));
		ge.getPlayerManager().addPlayer(new BasePlayer("2", "2".hashCode(), "homer simpson", 0));
		
		
		
		test.InitialiseGame("Database.txt",ge, cLIM);
		
		/*
		ge.login("100", "password123");
		ge.login("101", "321password");
		ge.setMaxTurns(3);
		cLIM.updateBoard(true);
		ge.movePiece("r2w", 5, 3);
		ge.movePiece("r2", 5, 2);
		// this wont do anything which is correct ge.movePiece("r1w", 4, 4);
		ge.movePiece("r2w", 5, 2);
		// null pointer exception mateo! ge.movePiece("r1", 0, 4);
		//ge.movePiece(pieceID, xCo, yCo)
		
*/


	}
}
