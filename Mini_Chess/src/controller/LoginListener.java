package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.utilities.LoginGetter;
import model.GameEngine;
import model.Player;
import view.components.BaseFrame;

public class LoginListener implements ActionListener {
	private BaseFrame mainFrame;
	private GameEngine mainEngine;
	
	public LoginListener(BaseFrame mainFrame) {
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
		this.mainEngine = mainFrame.getGUIModel().getMainEngine();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(mainEngine.getWhitePlayer() == null || mainEngine.getBlackPlayer() == null) {
			LoginGetter lG = new LoginGetter();
			String[] details = lG.getLogin();
			if(details != null) {
				int numPlayersOriginal = 0;
				if(mainEngine.getWhitePlayer() != null) {
					numPlayersOriginal++;
				}
				if(mainEngine.getBlackPlayer() != null) {
					numPlayersOriginal++;
				}
				mainEngine.login(details[0], details[1]);
				int numPlayersNow = 0;
				if(mainEngine.getWhitePlayer() != null) {
					numPlayersNow++;
				}
				if(mainEngine.getBlackPlayer() != null) {
					numPlayersNow++;
				}
				if(numPlayersOriginal == numPlayersNow) {
					JOptionPane.showMessageDialog(null, "Login Failed");
				}
			} else {
				// JOptionPane.showMessageDialog(mainFrame, "Registration Failed");
			}
		}
		
	}

}
