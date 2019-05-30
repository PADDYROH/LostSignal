package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.utilities.MaxTurnGetter;
import model.GameEngine;
import view.components.BaseFrame;
import view.model.GUIModel;

public class StartListener implements ActionListener {

	private BaseFrame mainFrame;
	private GameEngine mainEngine;

	public StartListener(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.mainEngine = mainFrame.getGUIModel().getMainEngine();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// make sure there are 2 players logged in and the game has not started
		if (!mainFrame.getGUIModel().isGameStarted() && mainEngine.getBlackPlayer() != null
				&& mainEngine.getWhitePlayer() != null) {
			// get desired turns from players
			MaxTurnGetter mTG1 = new MaxTurnGetter(mainFrame);
			MaxTurnGetter mTG2 = new MaxTurnGetter(mainFrame);
			int turns1 = mTG1.getTurns("Player 1");
			int turns2 = mTG2.getTurns("Player 2");
			int finalTurns = ((turns1 + turns2) / 2) * 2;
			if (turns1 <= 0 || turns2 <= 0) {
				// if turns 0 or negative, warn user
				JLabel temp = new JLabel("Invalid input. Setting max turns to 10.");
				temp.setFont(GUIModel.normalFont);
				JOptionPane.showMessageDialog(mainFrame, temp);
				finalTurns = 10;
			}
			mainEngine.setMaxTurns(finalTurns);
			mainFrame.getGUIModel().updateBoard();
		} else if (mainFrame.getGUIModel().getMainEngine().getBlackPlayer() == null
				|| mainFrame.getGUIModel().getMainEngine().getWhitePlayer() == null) {
			// warn user if only 0 or 1 players logged in
			JLabel temp = new JLabel("2 players must be logged in first.");
			temp.setFont(GUIModel.normalFont);
			JOptionPane.showMessageDialog(mainFrame, temp);
		} else {
			// warn user if game in progress
			JLabel temp = new JLabel("Game has already started!");
			temp.setFont(GUIModel.normalFont);
			JOptionPane.showMessageDialog(mainFrame, temp);
		}

	}

}
