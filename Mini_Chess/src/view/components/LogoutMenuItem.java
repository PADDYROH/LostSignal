package view.components;

import javax.swing.JMenuItem;

import controller.LogoutListener;

public class LogoutMenuItem extends JMenuItem {

	public LogoutMenuItem(BaseFrame mainFrame, boolean isWhite) {
		// TODO Auto-generated constructor stub
		super(String.format("Logout %s Player", isWhite ? "White" : "Black"));
		addActionListener(new LogoutListener(mainFrame, isWhite));
	}
}
