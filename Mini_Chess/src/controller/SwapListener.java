package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.GameEngine;
import view.components.BaseFrame;

public class SwapListener implements ActionListener{
	private BaseFrame mainFrame;
	private GameEngine mainEngine;
	
	public SwapListener(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.mainEngine = mainFrame.getGUIModel().getMainEngine();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(mainFrame.getGUIModel().isGameStarted()) {
			JOptionPane.showMessageDialog(mainFrame, "Game has already started!");
		} else {
			mainEngine.swapPlayers();
		}
		
	}

}
