package view.components;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class BaseMenuBar extends JMenuBar {
	private BaseFileMenu fileMenu;
	
	
	public BaseMenuBar(BaseFrame mainFrame) {
		fileMenu = new BaseFileMenu(mainFrame);
		add(fileMenu);
		add(new BaseHelpMenu(mainFrame));
		
	}
	
	public BaseFileMenu getFileMenu() {
		return fileMenu;
	}
}
