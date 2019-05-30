package main;

import model.GameEngine;
import model.GameEngineImpl;
import view.CLIManager;
import view.GUIManager;
import view.UserInterfaceManager;

public class Driver {

	public static void main(String[] args) {
		// create a game engine and views
		GameEngine gE = new GameEngineImpl();
		UserInterfaceManager cLIM = new CLIManager(gE);
		UserInterfaceManager gUIM = new GUIManager(gE);
		// add views
		gE.addUIManager(cLIM);
		gE.addUIManager(gUIM);		

	}
}

