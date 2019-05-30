package view.components;

import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class BaseMenuBar extends JMenuBar {
	private BaseFileMenu fileMenu;

	public BaseMenuBar(BaseFrame mainFrame) {
		// add file and help menus to bar
		fileMenu = new BaseFileMenu(mainFrame);
		add(fileMenu);
		add(new BaseHelpMenu(mainFrame));

	}

	// used to update menu items
	public BaseFileMenu getFileMenu() {
		return fileMenu;
	}
}
