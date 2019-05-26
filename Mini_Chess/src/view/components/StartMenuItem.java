package view.components;

import javax.swing.JMenuItem;

import controller.StartListener;

public class StartMenuItem extends JMenuItem{

	public StartMenuItem(BaseFrame mainFrame) {
		// TODO Auto-generated constructor stub
		super("Start Game");
		addActionListener(new StartListener(mainFrame));
		
	}

}
