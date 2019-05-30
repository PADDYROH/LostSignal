package view.components;

import javax.swing.JMenuItem;

import controller.LogoutListener;

@SuppressWarnings("serial")
public class LogoutMenuItem extends JMenuItem {

	public LogoutMenuItem(BaseFrame mainFrame, boolean isWhite) {
		super(String.format("Logout %s Player", isWhite ? "White" : "Black"));
		addActionListener(new LogoutListener(mainFrame, isWhite));
	}
}
