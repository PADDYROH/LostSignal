package controller.utilities;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Player;
import view.components.BaseFrame;
import view.model.GUIModel;

public class LoginGetter {
	private JTextField idField;
	private JPasswordField passwordField;
	private JPanel panel;
	private BaseFrame mainFrame;
	
	public LoginGetter(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		idField = new JTextField();
		passwordField = new JPasswordField();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	}
	
	public String[] getLogin() {
		String[] details = new String[2];
		
		JLabel userNameLabel = new JLabel("User ID: ");
		userNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		// set fonts?
		panel.add(userNameLabel);
		panel.add(idField);
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		passwordField.setEchoChar('*');
		// fonts
		panel.add(passwordLabel);
		panel.add(passwordField);
		GUIModel.updateFonts(panel);
		int result = JOptionPane.showConfirmDialog(mainFrame, panel, "Login Player", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, new ImageIcon());
		if(result == JOptionPane.OK_OPTION) {
			details[0] = idField.getText();
			details[1] = String.valueOf(passwordField.getPassword());
		} else {
			details = null;
		}
		
		return details;
	}

}
