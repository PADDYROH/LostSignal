package view.components;

import javax.swing.JMenuItem;

import controller.HelpListener;
import view.model.GUIModel;

public class BaseHelpMenuItem extends JMenuItem {

	public BaseHelpMenuItem(BaseFrame mainFrame) {
		// TODO Auto-generated constructor stub
		super("Help");
		addActionListener(new HelpListener(mainFrame));
		setFont(GUIModel.normalFont);
	}

}
