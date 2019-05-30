package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {

	// when Exit is clicked on, exit the program
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}

}
