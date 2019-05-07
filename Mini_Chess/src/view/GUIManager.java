package view;

import model.GameEngine;
import view.components.BaseFrame;
import view.model.GUIModel;

public class GUIManager implements UserInterfaceManager {

	private GameEngine mainEngine;
	private GUIModel gUIModel;
	private BaseFrame mainFrame;

	public GUIManager(GameEngine mainEngine) {
		this.mainEngine = mainEngine;
		gUIModel = new GUIModel();
		mainFrame = new BaseFrame(this, gUIModel);
		//add frame to VM
	}
	
	@Override
	public void updateBoard(boolean successfulMove) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCurrentPlayers() {
		// TODO Auto-generated method stub

	}

	@Override
	public void endGame() {
		// TODO Auto-generated method stub

	}

}
