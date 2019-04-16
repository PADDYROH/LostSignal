package main;

import java.util.Scanner;

import model.BasePlayer;
import model.GameEngine;
import model.Player;
import model.piece.Piece;
import model.utilities.PlayerManager;

public class TestClient {

	public void printMenu() {
		System.out.println("   Welcome to Mini Chess Game!     ");
		System.out.println("MENU (ENTER NUMBER FOR MENU CHOICE)");
		System.out.println("1.Register New Player");
		System.out.println("2.Start Game (Must have 2 registered players)");
		System.out.println("3.Exit");
	}

public void InitialiseGame(String database,GameEngine gameengine) {

Scanner scanner = new Scanner(System.in);
String input;

while(true) {

	input = null;
	printMenu();
	input = scanner.nextLine();
	
	
switch(input) {
	
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

case "2" : {

System.out.println("Player 1, Enter your ID:");
String IDP1 = scanner.nextLine();
System.out.println("Type Password:");
String PasswordP1 = scanner.nextLine();

gameengine.login(IDP1, PasswordP1);	


System.out.println("Player 1, Enter your ID:");
String IDP2 = scanner.nextLine();
System.out.println("Type Password:");
String PasswordP2 = scanner.nextLine();

gameengine.login(IDP1, PasswordP2);


while(true) {
	
	//insert method that prints board
	
	System.out.println("Player 1, Enter X Co-ordinate (Vertical) of piece you wish to move:");
	String number = scanner.nextLine();	
	int x = Integer.parseInt(number);
	
	System.out.println("Player 1, Enter Y Co-ordinate (Horizontal) of piece you wish to move:");
	number = scanner.nextLine();	
	int y = Integer.parseInt(number);

//cant find the getPiece method that exists in gameboardimpl so i can throw in x and y values to find ID
	Piece selectedPieceID = gameengine.getGameBoard().
	
}

break;
}
	
case "3" : {
	
	System.out.println("Exiting Game!");
	System.exit(0);
	break;
}

default:
	System.out.println("Not a valid Menu option, please try again!");
	
}
	
		
}
	
	
	
	
}

}
