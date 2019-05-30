package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.GameEngine;
import view.components.BaseFrame;
import view.model.GUIModel;

public class SwapListener implements ActionListener{
	private BaseFrame mainFrame;
	private GameEngine mainEngine;
	
	public SwapListener(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.mainEngine = mainFrame.getGUIModel().getMainEngine();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// swap players, warn user and do not swap if game in progress
		if(mainFrame.getGUIModel().isGameStarted()) {
			JLabel temp = new JLabel("Game has already started!");
			temp.setFont(GUIModel.normalFont);
			JOptionPane.showMessageDialog(mainFrame, temp);
		} else {
			mainEngine.swapPlayers();
		}
		
	}

}
