package view;

import model.GameBoardImpl;

public class CLIManager implements UserInterfaceManager {
	GameBoardImpl chessboard = new GameBoardImpl();
	{

		for (int row = 0; row < chessboard.getChessBoard().length; row++) {

			System.out.println("");
			System.out.println("_____________________________________");

			for (int column = 0; column < chessboard.getChessBoard().length; column++) {

				if (chessboard.getChessBoard()[row][column] != null) {
					System.out.print("| " + " " + "   ");
				} else {
					System.out.print("| " + chessboard.getChessBoard()[row][column] + "   ");
				}
				System.out.println("|");
			}

			System.out.println(" ");
			System.out.println("_____________________________________");
		}
	}
}
