package main;

import model.BasePlayer;
import model.GameBoardImpl;
import model.GameEngineImpl;

public class Driver {

	public static void main(String[] args) {

		GameBoardImpl gb = new GameBoardImpl();

		for (int i = 0; i < gb.getChessBoard().length; i++) {
			for (int j = 0; j < gb.getChessBoard().length; j++) {
				if (gb.getChessBoard()[i][j] != null) {

					System.out.println(gb.getChessBoard()[i][j].toString());

				}

			}
		}

	}

}
