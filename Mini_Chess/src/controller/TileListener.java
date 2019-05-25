package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import view.components.Tile;

public class TileListener implements MouseListener {
		
	private Tile mainTile;
		
	public TileListener(Tile tile) {
		this.mainTile = tile;
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		mainTile.getMainBoardPanel().get
//	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(mainTile.getMainBoardPanel().getMainFrame().getGUIModel().isGameStarted()) {
			mainTile.getMainBoardPanel().getMainFrame().getGUIModel().selectTile(mainTile.getXPos(), mainTile.getYPos());
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mainTile.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		mainTile.setBorder(mainTile.getDefaultBorder());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
