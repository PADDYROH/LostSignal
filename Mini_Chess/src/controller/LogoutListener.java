package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.GameEngine;
import view.components.BaseFrame;
import view.model.GUIModel;

public class LogoutListener implements ActionListener{
	private BaseFrame mainFrame;
	private GameEngine mainEngine;
	private boolean isWhite;
	
	public LogoutListener(BaseFrame mainFrame, boolean isWhite) {
		this.mainFrame = mainFrame;
		this.mainEngine = mainFrame.getGUIModel().getMainEngine();
		this.isWhite = isWhite;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(mainFrame.getGUIModel().isGameStarted()) {
			JLabel temp = new JLabel("Logging out will end the game. Are you sure?");
			temp.setFont(GUIModel.normalFont);
			int confirmed = JOptionPane.showConfirmDialog(null, temp);
			if(confirmed == JOptionPane.YES_OPTION) {
				mainEngine.endGame();
			}
		} else {
			if(isWhite) {
				mainEngine.logoutWhitePlayer();
			} else {
				mainEngine.logoutBlackPlayer();
			}
		}
		
	}

}
