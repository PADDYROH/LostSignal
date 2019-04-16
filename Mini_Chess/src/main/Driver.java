package main;

import model.BasePlayer;
import model.GameBoardImpl;
import model.GameEngine;
import model.GameEngineImpl;
import model.piece.Piece;
import view.CLIManager;
import view.UserInterfaceManager;

public class Driver {

	public static void main(String[] args) {


		GameEngine ge = new GameEngineImpl();
		UserInterfaceManager cLIM = new CLIManager(ge);
		ge.addUIManager(cLIM);
		ge.getPlayerManager().addPlayer(new BasePlayer("100", "password123".hashCode(), "joe dempsie", 0));
		ge.getPlayerManager().addPlayer(new BasePlayer("101", "321password".hashCode(), "homer simpson", 0));
		
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
		

  /* mateos old main:
		GameEngineImpl ge = new GameEngineImpl();

		// ge.getGameBoard()

		GameBoardImpl gb = new GameBoardImpl();

		for (int i = 0; i < gb.getChessBoard().length; i++) {
			for (int j = 0; j < gb.getChessBoard().length; j++) {
				if (gb.getChessBoard()[j][i] != null) {

					System.out.print(gb.getChessBoard()[j][i]);

				} else {
					System.out.print("x  ");
				}

			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

		gb.movePiece("r1w", 0, 3);
		gb.movePiece("r1w", 2, 3);

		for (int i = 0; i < gb.getChessBoard().length; i++) {
			for (int j = 0; j < gb.getChessBoard().length; j++) {
				if (gb.getChessBoard()[j][i] != null) {

					System.out.print(gb.getChessBoard()[j][i]);

				} else {
					System.out.print("x  ");
				}

			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
    */

	}
}
