package view;

import model.GameBoard;
import model.GameBoardImpl;
import model.GameEngine;
import model.Player;

public class CLIManager implements UserInterfaceManager {
	GameEngine mainEngine;

	public CLIManager(GameEngine mainEngine) {
		this.mainEngine = mainEngine;
	}

	@Override
	public void updateBoard(boolean successfulMove) {
		GameBoard chessBoard = mainEngine.getGameBoard();
		for (int column = 0; column < chessBoard.getChessBoard().length; column++) {

			System.out.println("");
			System.out.println("_____________________________________________");

			for (int row = 0; row < chessBoard.getChessBoard().length; row++) {

				if (chessBoard.getChessBoard()[row][column] != null) {
					if (chessBoard.getChessBoard()[row][column].length() < 3) {
						System.out.print("| " + chessBoard.getChessBoard()[row][column] + "    ");
					} else {
						System.out.print("| " + chessBoard.getChessBoard()[row][column] + "   ");
					}
				} else {
					System.out.print("| " + "   " + "   ");
				}
			}
		}
		System.out.println("\n");
		if(!successfulMove) {
			System.out.println("Invalid move. Try again " + mainEngine.getCurrentPlayer().getID() + ":" + mainEngine.getCurrentPlayer().getName());
		}
	}

	@Override
	public void updateCurrentPlayers() {
		Player temp = mainEngine.getWhitePlayer();
		if (temp != null) {
			System.out.printf("_____White_Player_____%n" + "ID:     %s%n" + "Name:   %s%n" + "Points: %s%n",
					temp.getID(), temp.getName(), mainEngine.getWhitePlayerPoints());
		}
		temp = mainEngine.getBlackPlayer();
		if (temp != null) {
			System.out.printf("_____Black_Player_____%n" + "ID:     %s%n" + "Name:   %s%n" + "Points: %d%n",
					temp.getID(), temp.getName(), mainEngine.getBlackPlayerPoints());
			System.out.println();
		}
	}

	@Override
	public void endGame() {
		if (mainEngine.getBlackPlayerPoints() > mainEngine.getWhitePlayerPoints()) {
			System.out.printf("The winner is: %s:%s with %d points!", mainEngine.getBlackPlayer().getID(),
					mainEngine.getBlackPlayer().getName(), mainEngine.getBlackPlayerPoints());
		} else if (mainEngine.getBlackPlayerPoints() < mainEngine.getWhitePlayerPoints()) {
			System.out.printf("The winner is: %s:%s with %d points!", mainEngine.getWhitePlayer().getID(),
					mainEngine.getWhitePlayer().getName(), mainEngine.getWhitePlayerPoints());
		} else {
			System.out.printf("It's a draw! Both players have %d points!", mainEngine.getBlackPlayerPoints());
		}
		System.out.println();
	}
}
