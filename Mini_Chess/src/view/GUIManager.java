package view;

import model.GameEngine;
import view.components.BaseFrame;
import view.model.GUIModel;

public class GUIManager implements UserInterfaceManager {

	private GUIModel gUIModel;
	private BaseFrame mainFrame;

	public GUIManager(GameEngine mainEngine) {
		gUIModel = new GUIModel(mainEngine);
		mainFrame = new BaseFrame(this, gUIModel);
		gUIModel.setMainFrame(mainFrame);
	}
	
	@Override
	public void updateBoard(boolean successfulMove) {
		// update board and players (for points) in GUI
		gUIModel.updateBoard();
		gUIModel.updateCurrentPlayers();

	}

	@Override
	public void updateCurrentPlayers() {
		// update list of players (after logging in etc.)
		gUIModel.updateCurrentPlayers();

	}

	@Override
	public void endGame() {
		// end game update of GUI
		gUIModel.endGame();

	}

}
