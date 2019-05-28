package view.components;

import javax.swing.JMenuItem;

import controller.StartListener;
import controller.SwapListener;

public class SwapMenuItem extends JMenuItem {

	public SwapMenuItem(BaseFrame mainFrame) {
		// TODO Auto-generated constructor stub
		super("Swap Players");
		addActionListener(new SwapListener(mainFrame));
	}
}
