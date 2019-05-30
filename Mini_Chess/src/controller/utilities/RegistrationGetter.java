 package controller.utilities;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.BasePlayer;
import model.Player;
import view.components.BaseFrame;
import view.model.GUIModel;

public class RegistrationGetter {
	private JTextField iDField;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JPanel panel;
	private BaseFrame mainFrame;
	
	public RegistrationGetter(BaseFrame mainFrame) {
		nameField = new JTextField();
		passwordField = new JPasswordField();
		iDField = new JTextField();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	}
	
	public Player registerPlayer() {
		JLabel iDLabel = new JLabel("User ID: ");
		iDLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		// set font
		panel.add(iDLabel);
		panel.add(iDField);
		
		JLabel usernameLabel = new JLabel("Username: ");
		usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		// set font
		panel.add(usernameLabel);
		panel.add(nameField);
		
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		passwordField.setEchoChar('*');
		// set font
		panel.add(passwordLabel);
		panel.add(passwordField);
		GUIModel.updateFonts(panel);
		// show a dialog with the created panel to the user
		int result = JOptionPane.showConfirmDialog(null, panel, "Register Player", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, new ImageIcon());
		if (result == JOptionPane.OK_OPTION) {
			if(iDField.getText().length() < 1) {
				JLabel temp = new JLabel("User ID must be entered!");
				temp.setFont(GUIModel.normalFont);
				JOptionPane.showMessageDialog(null, temp);
				return null;
			} 
			if(nameField.getText().length() < 1) {
				JLabel temp = new JLabel("Name must be entered!");
				temp.setFont(GUIModel.normalFont);
				JOptionPane.showMessageDialog(null, temp);
				return null;
			} 
			if(passwordField.getPassword().length < 1) {
				JLabel temp = new JLabel("Password must be entered!");
				temp.setFont(GUIModel.normalFont);
				JOptionPane.showMessageDialog(null, "Password must be entered!");
				return null;
			}
			return new BasePlayer(iDField.getText(), (String.valueOf(passwordField.getPassword())).hashCode(), nameField.getText(), 0);
			
		} else {
			return null;
		}
	}
}
