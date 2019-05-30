package view.components;

import javax.swing.JMenuItem;

import controller.RegisterListener;

@SuppressWarnings("serial")
public class RegisterMenuItem extends JMenuItem {

	public RegisterMenuItem(BaseFrame mainFrame) {
		super("Register Player");
		addActionListener(new RegisterListener(mainFrame));

	}

}
