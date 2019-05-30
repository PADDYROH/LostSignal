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
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
		this.mainEngine = mainFrame.getGUIModel().getMainEngine();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(!mainFrame.getGUIModel().isGameStarted() && mainEngine.getBlackPlayer() != null && mainEngine.getWhitePlayer() != null) {
			MaxTurnGetter mTG1 = new MaxTurnGetter(mainFrame);
			MaxTurnGetter mTG2 = new MaxTurnGetter(mainFrame);
			int turns1 = mTG1.getTurns("Player 1");
			int turns2 = mTG2.getTurns("Player 2");
			int finalTurns = ((turns1 + turns2)/2) * 2;
			if(turns1 <= 0 || turns2 <= 0) {
				JLabel temp = new JLabel("Invalid input. Setting max turns to 10.");
				temp.setFont(GUIModel.normalFont);
				JOptionPane.showMessageDialog(mainFrame, temp);
				finalTurns = 10;
			} 
			mainEngine.setMaxTurns(finalTurns);
			mainFrame.getGUIModel().updateBoard();
		} else if (mainFrame.getGUIModel().getMainEngine().getBlackPlayer() == null || mainFrame.getGUIModel().getMainEngine().getWhitePlayer() == null){
			JLabel temp = new JLabel("2 players must be logged in first.");
			temp.setFont(GUIModel.normalFont);
			JOptionPane.showMessageDialog(mainFrame, temp);
		} else {
			JLabel temp = new JLabel("Game has already started!");
			temp.setFont(GUIModel.normalFont);
			JOptionPane.showMessageDialog(mainFrame, temp);
		}
		

	}

}
