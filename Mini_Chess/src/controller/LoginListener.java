package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.utilities.LoginGetter;
import model.GameEngine;
import view.components.BaseFrame;
import view.model.GUIModel;

public class LoginListener implements ActionListener {
	private BaseFrame mainFrame;
	private GameEngine mainEngine;

	// keep engine for convenience
	public LoginListener(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.mainEngine = mainFrame.getGUIModel().getMainEngine();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// only allow login if not already 2 players logged in
		if (mainEngine.getWhitePlayer() == null || mainEngine.getBlackPlayer() == null) {
			// get login
			LoginGetter lG = new LoginGetter(mainFrame);
			String[] details = lG.getLogin();
			if (details != null) {
				// check if a player was actually logged in
				int numPlayersOriginal = 0;
				if (mainEngine.getWhitePlayer() != null) {
					numPlayersOriginal++;
				}
				if (mainEngine.getBlackPlayer() != null) {
					numPlayersOriginal++;
				}
				mainEngine.login(details[0], details[1]);
				int numPlayersNow = 0;
				if (mainEngine.getWhitePlayer() != null) {
					numPlayersNow++;
				}
				if (mainEngine.getBlackPlayer() != null) {
					numPlayersNow++;
				}
				// if number of players did not increase, must be invalid login
				if (numPlayersOriginal == numPlayersNow) {
					JLabel temp = new JLabel("Login failed. Invalid credentials or player already logged in.");
					temp.setFont(GUIModel.normalFont);
					JOptionPane.showMessageDialog(mainFrame, temp);
				}
			} else {

			}
		} else {
			// otherwise warn there already be 2 players logged in
			JLabel temp = new JLabel("Already 2 players logged in!");
			temp.setFont(GUIModel.normalFont);
			JOptionPane.showMessageDialog(mainFrame, temp);
		}

	}

}
