package view.components;

import javax.swing.JMenuItem;

import controller.RegisterListener;



public class RegisterMenuItem extends JMenuItem {

	public RegisterMenuItem(BaseFrame mainFrame) {
		super("Register Player");
		addActionListener(new RegisterListener(mainFrame));
		// font? setFont(FontTools.MENU_OPTION);
	}

}
