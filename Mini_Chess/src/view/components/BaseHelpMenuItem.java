package view.components;

import javax.swing.JMenuItem;

import controller.HelpListener;

public class BaseHelpMenuItem extends JMenuItem {

	public BaseHelpMenuItem(BaseFrame mainFrame) {
		// TODO Auto-generated constructor stub
		super("Help");
		addActionListener(new HelpListener(mainFrame));
	}

}
