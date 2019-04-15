package main;

import model.BasePlayer;
import model.GameBoardImpl;
import model.GameEngineImpl;
import model.piece.Piece;

public class Driver {

	public static void main(String[] args) {

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

	}

}
