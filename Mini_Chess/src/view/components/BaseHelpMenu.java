package view.components;

import javax.swing.JMenu;

import view.model.GUIModel;

public class BaseHelpMenu extends JMenu {
	public BaseHelpMenu(BaseFrame mainFrame) {
		super("Info");
		add(new BaseHelpMenuItem(mainFrame));
		setFont(GUIModel.normalFont);
		
	}
}
