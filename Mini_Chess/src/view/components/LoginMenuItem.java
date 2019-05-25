package view.components;

import javax.swing.JMenuItem;

import controller.LoginListener;
import controller.RegisterListener;

public class LoginMenuItem extends JMenuItem{

	public LoginMenuItem(BaseFrame mainFrame) {
		// TODO Auto-generated constructor stub
		super("Login Player");
		addActionListener(new LoginListener(mainFrame));
	}

}
