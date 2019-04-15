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

					System.out.print(gb.getChessBoard()[i][j].toString());

				} else {
					System.out.print("x  ");
				}

			}
			System.out.println();
		}

// 		System.out.println();
// 		System.out.println();

// 		gb.movePiece("r2", 2, 5);

// 		//BasePlayer p = new BasePlayer("30", "chessboi", 100);
// 		GameEngineImpl gameEngine = new GameEngineImpl();

		//gameEngine.addPlayer(p);

		//System.out.println(gameEngine.getAllPlayers().containsValue(p));

	}

}
