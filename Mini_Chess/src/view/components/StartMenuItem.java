package view.components;

import javax.swing.JMenuItem;

import controller.StartListener;

@SuppressWarnings("serial")
public class StartMenuItem extends JMenuItem {

	public StartMenuItem(BaseFrame mainFrame) {
		super("Start Game");
		addActionListener(new StartListener(mainFrame));

	}

}
