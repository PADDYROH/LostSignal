package main;

import model.BasePlayer;
import model.GameBoardImpl;
import model.GameEngineImpl;

public class Driver {

	public static void main(String[] args) {

		GameBoardImpl gb = new GameBoardImpl();

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

		gb.movePiece("r1", 0, 2);
		gb.movePiece("r1", 0, 2);
		gb.movePiece("b1w", 2, 4);
		gb.movePiece("r2", 5, 2);

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
