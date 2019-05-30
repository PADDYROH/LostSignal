package view.components;

import javax.swing.JMenu;

import view.model.GUIModel;

@SuppressWarnings("serial")
public class BaseHelpMenu extends JMenu {
	public BaseHelpMenu(BaseFrame mainFrame) {
		super("Info");
		// add Help item and set font
		add(new BaseHelpMenuItem(mainFrame));
		setFont(GUIModel.normalFont);

	}
}
