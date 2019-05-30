package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;

import view.components.Tile;

public class TileListener implements MouseListener {

	private Tile mainTile;

	public TileListener(Tile tile) {
		this.mainTile = tile;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (mainTile.getMainBoardPanel().getMainFrame().getGUIModel().isGameStarted()) {
			// tell GUIModel to select tile, if game has started
			// logic depends on if right click - splitting
			mainTile.getMainBoardPanel().getMainFrame().getGUIModel().selectTile(mainTile.getXPos(), mainTile.getYPos(),
					SwingUtilities.isRightMouseButton(e));
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// highlight tile purple if user mouses over it
		if (mainTile.getMainBoardPanel().getMainFrame().getGUIModel().isGameStarted()) {
			mainTile.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 255), 5));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mainTile.setBorder(mainTile.getDefaultBorder());

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
