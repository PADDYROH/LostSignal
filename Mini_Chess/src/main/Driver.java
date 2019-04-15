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

		gb.movePiece("r1", 0, 2);
		gb.movePiece("r1", 0, 4);
		gb.movePiece("r1", 0, 5);
		gb.movePiece("r1", 1, 5);
		gb.movePiece("r1", 2, 5);
		gb.movePiece("r1", 3, 5);
		gb.movePiece("r1", 4, 5);
		gb.movePiece("r2w", 4, 5);

		int count = 0;
		for (Piece value : gb.getPieces().values()) {
			if (value.getColor() == "black") {
				count++;
			}
		}

		System.out.println(count);

		for (int i = 0; i < gb.getChessBoard().length; i++) {
			for (int j = 0; j < gb.getChessBoard().length; j++) {
				if (gb.getChessBoard()[j][i] != null) {

					System.out.print(gb.getChessBoard()[j][i].toString());

				} else {
					System.out.print("x  ");
				}

			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

		// gb.movePiece("r2", 2, 5);

	}

}
