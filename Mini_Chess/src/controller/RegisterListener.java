package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.utilities.RegistrationGetter;
import model.GameEngine;
import model.Player;
import view.components.BaseFrame;
import view.model.GUIModel;

public class RegisterListener implements ActionListener {
	private BaseFrame mainFrame;
	private GameEngine mainEngine;

	public RegisterListener(BaseFrame mainFrame) {
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
		this.mainEngine = mainFrame.getGUIModel().getMainEngine();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		RegistrationGetter rG = new RegistrationGetter(mainFrame);
		
		Player newPlayer = rG.registerPlayer();
		if(newPlayer != null) {
			try {
				mainEngine.getPlayerManager().addPlayer(newPlayer);
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				JLabel temp = new JLabel("Registration failed, " + e1.getMessage());
				temp.setFont(GUIModel.normalFont);
				JOptionPane.showMessageDialog(mainFrame, temp);
			}
		} else {
			// JOptionPane.showMessageDialog(null, "Registration Failed");
		}

	}

}
