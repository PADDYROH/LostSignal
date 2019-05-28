package view.components;

import javax.swing.JMenu;

public class BaseHelpMenu extends JMenu {
	public BaseHelpMenu(BaseFrame mainFrame) {
		super("Info");
		add(new BaseHelpMenuItem(mainFrame));
		
	}
}
