package view.components;

import javax.swing.JMenuItem;

import controller.LoginListener;

@SuppressWarnings("serial")
public class LoginMenuItem extends JMenuItem {

	public LoginMenuItem(BaseFrame mainFrame) {
		super("Login Player");
		addActionListener(new LoginListener(mainFrame));
	}

}
