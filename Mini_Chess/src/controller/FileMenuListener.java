package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import view.model.GUIModel;

public class FileMenuListener implements MenuListener {
	GUIModel gUIModel;
	public FileMenuListener(GUIModel gUIModel) {
		// TODO Auto-generated constructor stub
		this.gUIModel = gUIModel;
	}

	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuSelected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		gUIModel.updateMenu();
		
	}

}
