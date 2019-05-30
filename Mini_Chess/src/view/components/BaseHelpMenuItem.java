package view.components;

import javax.swing.JMenuItem;

import controller.HelpListener;
import view.model.GUIModel;

@SuppressWarnings("serial")
public class BaseHelpMenuItem extends JMenuItem {

	public BaseHelpMenuItem(BaseFrame mainFrame) {
		// add item and set font
		super("Help");
		addActionListener(new HelpListener(mainFrame));
		setFont(GUIModel.normalFont);
	}

}
