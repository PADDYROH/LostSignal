/*package main;

import java.util.Scanner;

import model.BasePlayer;
import model.GameEngine;
import model.Player;
import model.piece.Piece;
import model.utilities.PlayerManager;
import view.UserInterfaceManager;

public class TestClient {

//Prints Menu to Screen
	
public void printMenu() {
	System.out.println("   Welcome to Mini Chess Game!     ");
	System.out.println("MENU (ENTER NUMBER FOR MENU CHOICE)");
	System.out.println("1.Register New Player");
	System.out.println("2.Start Game (Must have 2 registered players)");
	System.out.println("3.Exit");
}

//Function that will provide structure to the program including menu loops and sub functions created in other classes
public void InitialiseGame(String database,GameEngine gameengine, UserInterfaceManager cLIM) {

Scanner scanner = new Scanner(System.in);
String input;
gameengine.addUIManager(cLIM);

while(true) {

//Prints menu to screen and detects users menu choice
	input = null;
	printMenu();
	input = scanner.nextLine();
	
	
switch(input) {
//Registering a New Player
case "1" : {
	
	String ID;
	String Name;
	String Password = null;
	int Score = 0;
	
	System.out.println("Type ID: ");
	ID = scanner.nextLine();
	System.out.println("Type Name:");
	Name = scanner.nextLine();
	System.out.println("Type Password:");
	Password = scanner.nextLine();
	
	Player playerInput = new BasePlayer(ID,Password.hashCode(),Name,Score);
	
	
	gameengine.getPlayerManager().addPlayer(playerInput);
	
	System.out.println("Returning to Main Menu!");
	
	break;
}
//Starting Game
case "2" : {
	
//First requires login from both parties before game can commence
System.out.println("Player 1, Enter your ID:");
String IDP1 = scanner.nextLine();
System.out.println("Type Password:");
String PasswordP1 = scanner.nextLine();

gameengine.login(IDP1, PasswordP1);	


System.out.println("Player 2, Enter your ID:");
String IDP2 = scanner.nextLine();
System.out.println("Type Password:");
String PasswordP2 = scanner.nextLine();

gameengine.login(IDP2, PasswordP2);

gameengine.setMaxTurns(5);

//Login from both parties is now complete and Max amount of turns has been set
//First player who logged in will be registered to white pieces on game board

System.out.println(gameengine.getWhitePlayer().getName() + ", you will go first! " );

//Loop for continuation of play back and forth between players
while(true) {

	cLIM.updateBoard(true);
	
	//Requests desired selected piece and destination
	System.out.println(gameengine.getCurrentPlayer().getName()+ ", Enter board piece you wish to move (Eg. r1 or r1w).");
	String chosenpiece = scanner.nextLine();
	
	System.out.println(gameengine.getCurrentPlayer().getName()+ ", Enter X Co-ordinate (Horizontal) of where you want piece to move to:");
	String number = scanner.nextLine();	
	int x = Integer.parseInt(number);
	
	System.out.println(gameengine.getCurrentPlayer().getName()+ ", Enter Y Co-ordinate (Vertical) of where you want piece to move to:");
	number = scanner.nextLine();	
	int y = Integer.parseInt(number);

//following function calculates if parameters are appropriate and if so, will continue. Otherwise will re-request.
	gameengine.movePiece(chosenpiece, x, y);

}

}
	
case "3" : {
//Exit System
	System.out.println("Exiting Game!");
	System.exit(0);
	break;
}
//Invalid Menu Option 
default:
	System.out.println("Not a valid Menu option, please try again!");
	
}
	
		
}
	
	
	
	
}

	

}*/
// =======
package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.BasePlayer;
import model.GameEngine;
import model.Player;
import model.piece.Piece;
import model.utilities.PlayerManager;

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

	public void initialiseGame() {
		String input;
		gameEngine.getPlayerManager().loadPlayers();
		while (true) {

			input = null;
			printMenu();
			input = scanner.nextLine();

			switch (input) {

			case "1": {
				registerPlayer();
				printMenu();
				initialiseGame();
				break;
			}

			case "2": {

				loginPlayer1();
				loginPlayer2();
				
				try {
					setMaxMoves();
				} catch (InputMismatchException e) {
					System.err.println("Error: input not an integer! Default turns set to 10.");
					gameEngine.setMaxTurns(20);
					scanner.nextLine();
				}
				//scanner.nextLine();
				makeMove();
				break;
			}

			case "3": {

				System.out.println("Exiting Game!");
				System.exit(0);
				break;
			}

			default:
				System.out.println("Not a valid Menu option, please try again!");

			}

		}

	}

	private void setMaxMoves() {
		System.out.println("Player 1: Enter desired max turns.");
		int p1Max = scanner.nextInt();
		System.out.println("Player 2: Enter desired max turns.");
		int p2Max = scanner.nextInt();
		scanner.nextLine();
		gameEngine.setMaxTurns(Math.round((p1Max + p2Max)/2) * 2);
		
	}

	private void loginPlayer1() {
		System.out.println("\nPlayer 1, Enter your ID:");
		String iDP1 = scanner.nextLine();
		if(iDP1.equals("exit")) {
			initialiseGame();
		}
		System.out.println("Type Password:");
		String passwordP1 = scanner.nextLine();
		gameEngine.login(iDP1, passwordP1);
		if (gameEngine.getWhitePlayer() == null) {
			loginPlayer1();
		}

	}

	private void loginPlayer2() {
		System.out.println("\nPlayer 2, Enter your ID:");
		String iDP2 = scanner.nextLine();
		if(iDP2.equals("exit")) {
			initialiseGame();
		}
		System.out.println("Type Password:");
		String passwordP2 = scanner.nextLine();
		gameEngine.login(iDP2, passwordP2);
		if (gameEngine.getBlackPlayer() == null) {
			loginPlayer2();
		}
	}

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

		try {
			gameEngine.getPlayerManager().addPlayer(playerInput);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			registerPlayer();
		}

		System.out.println("Success. Returning to Main Menu!");
		return true;
	}

	private boolean makeMove() {
		try {
			while (gameEngine.getCurrentPlayer() != null) {
				Player tempPlayer = gameEngine.getCurrentPlayer();
				//String pieceID = "";
				System.out.println(gameEngine.getCurrentPlayer().getName()
						+ ", Enter board piece you wish to move (Eg. r1 or r1w).");
				String chosenpiece = scanner.nextLine();

				System.out.println(gameEngine.getCurrentPlayer().getName()
						+ ", Enter X Co-ordinate (Horizontal) of where you want piece to move to:");
				// String number = scanner.nextI();
				// int x = Integer.parseInt(number);
				int x = scanner.nextInt();
				System.out.println(gameEngine.getCurrentPlayer().getName()
						+ ", Enter Y Co-ordinate (Vertical) of where you want piece to move to:");
				// number = scanner.nextLine();
				// int y = Integer.parseInt(number);
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
