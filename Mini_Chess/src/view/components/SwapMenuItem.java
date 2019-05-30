package view.components;

import javax.swing.JMenuItem;

import controller.SwapListener;

@SuppressWarnings("serial")
public class SwapMenuItem extends JMenuItem {

	public SwapMenuItem(BaseFrame mainFrame) {
		super("Swap Players");
		addActionListener(new SwapListener(mainFrame));
	}
}
