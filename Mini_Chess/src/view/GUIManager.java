package view;

import model.GameEngine;
import view.components.BaseFrame;
import view.components.Tile;
import view.model.GUIModel;

public class GUIManager implements UserInterfaceManager {

	//private GameEngine mainEngine;
	private GUIModel gUIModel;
	private BaseFrame mainFrame;

	public GUIManager(GameEngine mainEngine) {
		//this.mainEngine = mainEngine;
		gUIModel = new GUIModel(mainEngine);
		mainFrame = new BaseFrame(this, gUIModel);
		//add frame to VM
		gUIModel.setMainFrame(mainFrame);
	}
	
	@Override
	public void updateBoard(boolean successfulMove) {
		// TODO Auto-generated method stub
		// make take boolean so knows whether to update status bar
		gUIModel.updateBoard();
		gUIModel.updateCurrentPlayers();

	}

	@Override
	public void updateCurrentPlayers() {
		// TODO Auto-generated method stub
		gUIModel.updateCurrentPlayers();

	}

	@Override
	public void endGame() {
		// TODO Auto-generated method stub
		gUIModel.endGame();

	}

	public void selectPiece(String string) {
		// TODO Auto-generated method stub
		
	}

}
