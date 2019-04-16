package main;

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

	

}
// =======
// package main;

// import java.util.Scanner;

// import model.BasePlayer;
// import model.GameEngine;
// import model.Player;
// import model.piece.Piece;
// import model.utilities.PlayerManager;

// public class TestClient {
// 	GameEngine gameEngine;
// 	Scanner scanner = new Scanner(System.in);


// // 	public TestClient(GameEngine gameEngine) {
// // 		this.gameEngine = gameEngine;
// // 	}

// 	public void printMenu() {
// 		System.out.println("   Welcome to Mini Chess Game!     ");
// 		System.out.println("MENU (ENTER NUMBER FOR MENU CHOICE)");
// 		System.out.println("1.Register New Player");
// 		System.out.println("2.Start Game (Must have 2 registered players)");
// 		System.out.println("3.Exit");
// 	}

// public void InitialiseGame(String database,GameEngine gameengine) {

// Scanner scanner = new Scanner(System.in);
// String input;

// while(true) {

// 	input = null;
// 	printMenu();
// 	input = scanner.nextLine();
	
	
// switch(input) {
	
// case "1" : {
	
// 	String ID;
// 	String Name;
// 	String Password = null;
// 	int Score = 0;
	
// 	System.out.println("Type ID: ");
// 	ID = scanner.nextLine();
// 	System.out.println("Type Name:");
// 	Name = scanner.nextLine();
// 	System.out.println("Type Password:");
// 	Password = scanner.nextLine();
	
// 	Player playerInput = new BasePlayer(ID,Password.hashCode(),Name,Score);
	
	
// 	gameengine.getPlayerManager().addPlayer(playerInput);
	
// 	System.out.println("Returning to Main Menu!");
	
// 	break;
// }

// case "2" : {

// System.out.println("Player 1, Enter your ID:");
// String IDP1 = scanner.nextLine();
// System.out.println("Type Password:");
// String PasswordP1 = scanner.nextLine();

// gameengine.login(IDP1, PasswordP1);	


// 	public void printMenu() {
// 		System.out.println("   Welcome to Mini Chess Game!     ");
// 		System.out.println("MENU (ENTER NUMBER FOR MENU CHOICE)");
// 		System.out.println("1.Register New Player");
// 		System.out.println("2.Start Game (Must have 2 registered players)");
// 		System.out.println("3.Exit");
// 	}

// 	public void initialiseGame() {

// 		String input;

// 		while (true) {

// 			input = null;
// 			printMenu();
// 			input = scanner.nextLine();

// 			switch (input) {

// 			case "1": {
// 				registerPlayer();
// 				printMenu();
// 				initialiseGame();
// 				break;
// 			}

// 			case "2": {

// 				loginPlayer1();

// 				loginPlayer2();

// 				while (gameEngine.getCurrentPlayer() != null) {

// 					// insert method that prints board

// //					System.out.println("Player 1, Enter X Co-ordinate (Vertical) of piece you wish to move:");
// //					String number = scanner.nextLine();
// //					int x = Integer.parseInt(number);
// //
// //					System.out.println("Player 1, Enter Y Co-ordinate (Horizontal) of piece you wish to move:");
// //					number = scanner.nextLine();
// //					int y = Integer.parseInt(number);
// 					String pieceID = "";
					

// 					// cant find the getPiece method that exists in gameboardimpl so i can throw in
// 					// x and y values to find ID
// 					// Piece selectedPieceID = gameengine.getGameBoard().

// 				}

// 				break;
// 			}

// 			case "3": {

// 				System.out.println("Exiting Game!");
// 				System.exit(0);
// 				break;
// 			}

// 			default:
// 				System.out.println("Not a valid Menu option, please try again!");

// 			}

// 		}

// 	}

// 	private void loginPlayer1() {
// 		System.out.println("Player 1, Enter your ID:");
// 		String iDP1 = scanner.nextLine();
// 		System.out.println("Type Password:");
// 		String passwordP1 = scanner.nextLine();
// 		while (gameEngine.getWhitePlayer() == null) {
// 			gameEngine.login(iDP1, passwordP1);
// 		}

// 	}

// 	private void loginPlayer2() {
// 		System.out.println("Player 2, Enter your ID:");
// 		String iDP2 = scanner.nextLine();
// 		System.out.println("Type Password:");
// 		String passwordP2 = scanner.nextLine();
// 		while (gameEngine.getWhitePlayer() == null) {
// 			gameEngine.login(iDP2, passwordP2);
// 		}

// 	}

// 	private boolean registerPlayer() {
// 		String iD;
// 		String name;
// 		String password = null;
// 		int score = 0;

// 		System.out.println("Type ID: ");
// 		iD = scanner.nextLine();
// 		if (iD.equals("exit")) {
// 			System.out.println("Cancelled. Returning to Main Menu!");
// 		}
// 		System.out.println("Type Name:");
// 		name = scanner.nextLine();
// 		System.out.println("Type Password:");
// 		password = scanner.nextLine();
// 		Player playerInput = new BasePlayer(iD, password.hashCode(), name, score);


//  		try {
//  			gameEngine.getPlayerManager().addPlayer(playerInput);
//  		} catch (IllegalArgumentException e) {
//  			System.err.println(e.getMessage());
//  			registerPlayer();
//  		}

//  		System.out.println("Success. Returning to Main Menu!");
//  		return true;
//  	}



// }
// >>>>>>> master
