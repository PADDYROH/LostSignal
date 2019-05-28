package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.components.BaseFrame;

public class HelpListener implements ActionListener {
	private JPanel helpPanel = new JPanel();
	private BaseFrame mainFrame;
	public HelpListener(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		helpPanel = new JPanel();
		helpPanel.setLayout(new BoxLayout(helpPanel, BoxLayout.Y_AXIS));
		helpPanel.add(new JLabel("Before Starting:"));
		helpPanel.add(new JLabel(" "));
		helpPanel.add(new JLabel("Register a player through File > Register Player."));
		helpPanel.add(new JLabel("         No 2 players may have the same ID."));
		helpPanel.add(new JLabel("Login 2 players through File > Login."));
		helpPanel.add(new JLabel("            The same player may not be logged in twice."));
		helpPanel.add(new JLabel("_____________________________________________"));
		helpPanel.add(new JLabel("Gameplay:"));
		helpPanel.add(new JLabel(" "));
		helpPanel.add(new JLabel("Begin game with File > Start Game."));
		helpPanel.add(new JLabel("            Each player must enter an integer value of maximum number of turns."));
		helpPanel.add(new JLabel("Move a piece by clicking on it and then selecting another square."));
		helpPanel.add(new JLabel(" "));
		helpPanel.add(new JLabel("When a piece has been selected, the following borders on board squares appear:"));
		JLabel validMove = new JLabel("Valid move.");
		validMove.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 255), 3));
		helpPanel.add(validMove);
		JLabel badMove = new JLabel("Valid move, but is likely to lose you a piece in the next player's turn.");
		badMove.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 255), 3));
		helpPanel.add(badMove);
		helpPanel.add(new JLabel(" "));
		helpPanel.add(new JLabel("Merge a piece by moving a piece onto another piece of the same colour."));
		helpPanel.add(new JLabel("Split a piece by selecting a piece as normal, and right clicking on another square."));
		helpPanel.add(new JLabel("            The splitting is determined by which of the 2 merged pieces can move to the selected location."));
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		JOptionPane.showConfirmDialog(mainFrame, helpPanel, "Help Panel", JOptionPane.PLAIN_MESSAGE);
	}

}
