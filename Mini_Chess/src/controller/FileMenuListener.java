package controller;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import view.model.GUIModel;

public class FileMenuListener implements MenuListener {
	GUIModel gUIModel;

	public FileMenuListener(GUIModel gUIModel) {
		this.gUIModel = gUIModel;
	}

	@Override
	public void menuCanceled(MenuEvent arg0) {
	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
	}

	// update the menu - enabling/disabling items, when it is opened
	@Override
	public void menuSelected(MenuEvent arg0) {
		gUIModel.updateMenu();
	}

}
