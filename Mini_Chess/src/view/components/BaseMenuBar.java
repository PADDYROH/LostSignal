package view.components;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class BaseMenuBar extends JMenuBar {
	private JMenu fileMenu;
	private JMenu gameMenu;
	
	public BaseMenuBar(BaseFrame mainFrame) {
		fileMenu = new BaseFileMenu(mainFrame);
		add(fileMenu);
		
	}
}
