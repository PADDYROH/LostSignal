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
	public void updateBoard() {
		GameBoard chessBoard = mainEngine.getGameBoard();
		for (int row = 0; row < chessBoard.getChessBoard().length; row++) {

			System.out.println("");
			System.out.println("_____________________________________");

			for (int column = 0; column < chessBoard.getChessBoard().length; column++) {

				if (chessBoard.getChessBoard()[row][column] != null) {
					System.out.print("| " + " " + "   ");
				} else {
					System.out.print("| " + chessBoard.getChessBoard()[row][column] + "   ");
				}
				System.out.println("|");
			}

			System.out.println(" ");
			System.out.println("_____________________________________");
		}
	}

	@Override
	public void updateCurrentPlayers() {
		Player temp = mainEngine.getWhitePlayer();
		System.out.printf("_____White_Player_____%n" + "ID:     %s%n" + "Name:   %s%n" + "Points: %s%n", temp.getID(),
				temp.getName(), mainEngine.getWhitePlayerPoints());
		temp = mainEngine.getBlackPlayer();
		System.out.printf("_____Black_Player_____%n" + "ID:     %s%n" + "Name:   %s%n" + "Points: %d%n", temp.getID(),
				temp.getName(), mainEngine.getBlackPlayerPoints());
	}

	@Override
	public void endGame() {
		// TODO Auto-generated method stub
		if (mainEngine.getBlackPlayerPoints() > mainEngine.getBlackPlayerPoints()) {
			System.out.printf("The winner is: %s:%s with %d points!", mainEngine.getBlackPlayer().getID(),
					mainEngine.getBlackPlayer().getName(), mainEngine.getBlackPlayerPoints());
		} else if (mainEngine.getWhitePlayerPoints() < mainEngine.getWhitePlayerPoints()) {
			System.out.printf("The winner is: %s:%s with %d points!", mainEngine.getWhitePlayer().getID(),
					mainEngine.getWhitePlayer().getName(), mainEngine.getWhitePlayerPoints());
		} else {
			System.out.printf("It's a draw! Both players have %d points!", mainEngine.getBlackPlayerPoints());
		}
	}
}
