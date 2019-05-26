package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.GameEngine;
import view.components.BaseFrame;

public class LogoutListener implements ActionListener{
	private BaseFrame mainFrame;
	private GameEngine mainEngine;
	
	public LogoutListener(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.mainEngine = mainFrame.getGUIModel().getMainEngine();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int confirmed = JOptionPane.showConfirmDialog(null, "Logging out will end the game. Are you sure?");
		if(confirmed == JOptionPane.YES_OPTION) {
			mainEngine.endGame();
		}
	}

}
