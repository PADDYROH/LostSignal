package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.BasePlayer;
import model.GameEngine;
import model.Player;

public class TestClient {
	GameEngine gameEngine;
	Scanner scanner = new Scanner(System.in);

	public TestClient(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}

	public void printMenu() {
		System.out.println("*************************************************");
		System.out.println("*          Welcome to Mini Chess Game!          *");
		System.out.println("* MENU (ENTER NUMBER FOR MENU CHOICE)           *");
		System.out.println("* 1.Register New Player                         *");
		System.out.println("* 2.Start Game (Must have 2 registered players) *");
		System.out.println("* 3.Exit                                        *");
		System.out.println("*************************************************");
	}

	// begin game, getting user input
	public void initialiseGame() {
		String input;
		gameEngine.getPlayerManager().loadPlayers();
		while (true) {

			input = null;
			printMenu();
			input = scanner.nextLine();

			switch (input) {
			// register players if option selected
			case "1": {
				registerPlayer();
				printMenu();
				initialiseGame();
				break;
			}
			// login players if option selected
			case "2": {

				loginPlayer1();
				loginPlayer2();
				// get maximum moves from each player
				try {
					setMaxMoves();
				} catch (InputMismatchException e) {
					System.err.println("Error: input not an integer! Default turns set to 10.");
					gameEngine.setMaxTurns(20);
					scanner.nextLine();
				}
				// begin game with first move (recursive)
				makeMove();
				break;
			}

			case "3": {
				// exit game
				System.out.println("Exiting Game!");
				System.exit(0);
				break;
			}

			default:
				// if not 1, 2 or 3, ask again
				System.out.println("Not a valid Menu option, please try again!");

			}

		}

	}

	// called to set max desired moves
	private void setMaxMoves() {
		System.out.println("Player 1: Enter desired max turns.");
		int p1Max = scanner.nextInt();
		System.out.println("Player 2: Enter desired max turns.");
		int p2Max = scanner.nextInt();
		scanner.nextLine();
		gameEngine.setMaxTurns(Math.round((p1Max + p2Max) / 2) * 2);

	}

	// get user input for player 1 login (white)
	private void loginPlayer1() {
		System.out.println("\nPlayer 1, Enter your ID:");
		String iDP1 = scanner.nextLine();
		if (iDP1.equals("exit")) {
			initialiseGame();
		}
		System.out.println("Type Password:");
		String passwordP1 = scanner.nextLine();
		gameEngine.login(iDP1, passwordP1);
		if (gameEngine.getWhitePlayer() == null) {
			loginPlayer1();
		}

	}

	// get user input for player 2 login (black)
	private void loginPlayer2() {
		System.out.println("\nPlayer 2, Enter your ID:");
		String iDP2 = scanner.nextLine();
		if (iDP2.equals("exit")) {
			initialiseGame();
		}
		System.out.println("Type Password:");
		String passwordP2 = scanner.nextLine();
		gameEngine.login(iDP2, passwordP2);
		if (gameEngine.getBlackPlayer() == null) {
			loginPlayer2();
		}
	}

	// get user input for player registration
	private boolean registerPlayer() {
		String iD;
		String name;
		String password = null;
		int score = 0;

		System.out.println("Type ID: ");
		iD = scanner.nextLine();
		if (iD.equals("exit")) {
			System.out.println("Cancelled. Returning to Main Menu!");
			initialiseGame();
		}
		System.out.println("Type Name:");
		name = scanner.nextLine();
		System.out.println("Type Password:");
		password = scanner.nextLine();
		Player playerInput = new BasePlayer(iD, password.hashCode(), name, score);
		// if invalid player, try again
		try {
			gameEngine.getPlayerManager().addPlayer(playerInput);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			registerPlayer();
		}

		System.out.println("Success. Returning to Main Menu!");
		return true;
	}

	// called to get user input and run move methods on engine
	private boolean makeMove() {
		try {
			while (gameEngine.getCurrentPlayer() != null) {
				Player tempPlayer = gameEngine.getCurrentPlayer();
				// String pieceID = "";
				System.out.println(gameEngine.getCurrentPlayer().getName()
						+ ", Enter board piece you wish to move (Eg. r1 or r1w).");
				String chosenpiece = scanner.nextLine();

				System.out.println(gameEngine.getCurrentPlayer().getName()
						+ ", Enter X Co-ordinate (Horizontal) of where you want piece to move to:");

				int x = scanner.nextInt();
				System.out.println(gameEngine.getCurrentPlayer().getName()
						+ ", Enter Y Co-ordinate (Vertical) of where you want piece to move to:");

				int y = scanner.nextInt();
				scanner.nextLine();
				gameEngine.movePiece(chosenpiece, x, y);
				if (tempPlayer == gameEngine.getCurrentPlayer()) {
					System.out.println("Invalid piece or move.");
					makeMove();
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Invalid piece ID or move. Try again.");
			makeMove();
		}
		return true;
	}

}
