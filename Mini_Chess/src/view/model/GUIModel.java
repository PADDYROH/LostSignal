package view.model;

import model.GameEngine;
import view.components.BaseFrame;

public class GUIModel {
	private GameEngine mainEngine;
	private BaseFrame mainFrame;
	public GUIModel(GameEngine mainEngine) {
		// TODO Auto-generated constructor stub
		this.mainEngine = mainEngine;
	}

	public BaseFrame getMainFrame() {
		// TODO Auto-generated method stub
		return mainFrame;
	}
	
	public void setMainFrame(BaseFrame newFrame) {
		mainFrame = newFrame;
	}

	public GameEngine getMainEngine() {
		// TODO Auto-generated method stub
		return mainEngine;
	}

}
