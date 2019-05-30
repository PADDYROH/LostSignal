package view.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.GameBoardImpl;
import model.GameEngine;
import model.Player;
import model.piece.Piece;
import view.components.BaseFrame;
import view.components.Tile;
import view.utilities.PieceIconTools;

public class GUIModel {
	private GameEngine mainEngine;
	private BaseFrame mainFrame;
	private Piece selected;
	private final int ROWS = 6;
	private final int COLS = 6;
	public final static Font normalFont = new Font("Century Gothic", Font.PLAIN, 20);

	public GUIModel(GameEngine mainEngine) {
		this.mainEngine = mainEngine;
	}

	public BaseFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(BaseFrame newFrame) {
		mainFrame = newFrame;
		// when mainFrame is set, we can use GUIModel update methods on initial views
		updateTiles();
		mainFrame.getMainStatusPanel().updateInfo();
		updateFonts(mainFrame);
	}

	// static helper method to update the fonts of a component and its sub
	// components
	public static void updateFonts(Component c) {
		c.setFont(GUIModel.normalFont);
		if (c instanceof Container) {
			// call this method recursively on all sub components
			for (Component child : ((Container) c).getComponents()) {
				updateFonts(child);
			}
		}
	}

	public GameEngine getMainEngine() {
		return mainEngine;
	}

	// select tile, default is false
	public void selectTile(int xPos, int yPos) {
		selectTile(xPos, yPos, false);
	}

	// select tile, isSplit refers to if the user wants to split the already
	// selected piece
	public void selectTile(int xPos, int yPos, boolean isSplit) {

		// select a piece if not already selected (if engine says its a valid selection)
		// i.e. player color matches the piece color
		if (selected == null) {
			selected = mainEngine.selectPiece(xPos, yPos);
		} else {
			// if user wants to split, pass the ID of the inner piece (if exists) back to
			// GameBoard. piece will split out whichever merged piece is able to move there
			if (isSplit && mainEngine.getGameBoard().getPiece(selected.getPosX(), selected.getPosY())
					.getMergedPiece() != null) {
				mainEngine.movePiece(
						mainEngine.getGameBoard().getPiece(selected.getPosX(), selected.getPosY()).getMergedID(), xPos,
						yPos);
				// otherwise just move the 'outer' piece or single piece at position
			} else {
				mainEngine.movePiece(mainEngine.getGameBoard().getChessBoard()[selected.getPosX()][selected.getPosY()],
						xPos, yPos);
			}
			// deselect
			selected = null;
		}

		// update all tiles in the board view
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 6; c++) {
				boolean checkMerged = false;
				if (selected != null) {
					Piece existingPiece = mainEngine.getGameBoard().getPiece(c, r);
					if (existingPiece != null) {
						if (existingPiece.getColor()
								.equals(mainEngine.getGameBoard().getPiece(xPos, yPos).getColor())) {
							if (existingPiece.getMergedPiece() != null) {
								checkMerged = true;
							}
						}
					}
				}

				if (selected != null && mainEngine.checkMove(xPos, yPos, c, r) && !checkMerged) {
					// set all valid tile position borders to blue
					mainFrame.getMainBoardPanel().getTiles()[c][r]
							.updateBorder(BorderFactory.createLineBorder(new Color(0, 120, 255), 5));
					// check if any piece in the game can move to this position
					for (Piece p : mainEngine.getGameBoard().getPieces().values()) {
						if (p.getColor() != null) {
							// only check movement of pieces of the opposite colour
							if (!p.getColor().equals(mainEngine.getGameBoard().getPiece(xPos, yPos).getColor())) {
								if (p.validMove((GameBoardImpl) mainEngine.getGameBoard(), c, r)) {
									// set colour to orange
									mainFrame.getMainBoardPanel().getTiles()[c][r]
											.updateBorder(BorderFactory.createLineBorder(new Color(255, 128, 0), 5));
								}
							}
						}
					}
					// all other tiles set to no border
				} else {
					mainFrame.getMainBoardPanel().getTiles()[c][r].updateBorder(null);
				}
			}
		}
	}

	// update the board and status when some change is made to game
	public void updateBoard() {
		updateTiles();
		mainFrame.getMainStatusPanel().updateInfo();
		updateFonts(mainFrame);
	}

	// return true if game in progress
	public boolean isGameStarted() {
		// game is started if maxTurns has been set and 2 players are logged in
		return (mainEngine.getMaxTurns() > 0) && (mainEngine.getWhitePlayer() != null)
				&& (mainEngine.getBlackPlayer() != null);
	}

	public void updateCurrentPlayers() {
		mainFrame.getMainPlayerPanel().updatePlayerList();
		mainFrame.getMainStatusPanel().updateInfo();
		updateFonts(mainFrame);
	}

	public void endGame() {
		JPanel winPanel = new JPanel();
		String message = "";
		// create a message panel for users, with winner and their points
		if (mainEngine.getBlackPlayerPoints() > mainEngine.getWhitePlayerPoints()) {
			message += String.format("The winner is: %s(%s) with %d points!", mainEngine.getBlackPlayer().getName(),
					mainEngine.getBlackPlayer().getID(), mainEngine.getBlackPlayerPoints());
		} else if (mainEngine.getBlackPlayerPoints() < mainEngine.getWhitePlayerPoints()) {
			message += String.format("The winner is: %s(%s) with %d points!", mainEngine.getWhitePlayer().getName(),
					mainEngine.getWhitePlayer().getID(), mainEngine.getWhitePlayerPoints());
		} else {
			message += String.format("It's a draw! Both players have %d points!", mainEngine.getBlackPlayerPoints());
		}

		winPanel.add(new JLabel(new ImageIcon("pieceImages" + File.separator + "win.png")));
		winPanel.add(new JLabel(message));
		updateFonts(winPanel);
		JOptionPane.showMessageDialog(null, winPanel, "Game Over!", JOptionPane.DEFAULT_OPTION);
		updateFonts(mainFrame);
	}

	public void updateMenu() {
		// update file menu, items are enabled or disabled
		// enable all initially
		mainFrame.getMainMenuBar().getFileMenu().getLoginMenuItem().setEnabled(true);
		mainFrame.getMainMenuBar().getFileMenu().getStartMenuItem().setEnabled(true);
		mainFrame.getMainMenuBar().getFileMenu().getLogoutWhiteMenuItem().setEnabled(true);
		mainFrame.getMainMenuBar().getFileMenu().getLogoutBlackMenuItem().setEnabled(true);
		mainFrame.getMainMenuBar().getFileMenu().getSwapMenuItem().setEnabled(true);
		// disable login if already 2 players logged in
		if (mainEngine.getWhitePlayer() != null && mainEngine.getBlackPlayer() != null) {
			mainFrame.getMainMenuBar().getFileMenu().getLoginMenuItem().setEnabled(false);
		}
		// disable swap if no players logged in
		if (mainEngine.getWhitePlayer() == null && mainEngine.getBlackPlayer() == null || isGameStarted()) {
			mainFrame.getMainMenuBar().getFileMenu().getSwapMenuItem().setEnabled(false);
		}
		// disable start if only 0 or 1 players logged in
		if (isGameStarted() || mainEngine.getWhitePlayer() == null || mainEngine.getBlackPlayer() == null) {
			mainFrame.getMainMenuBar().getFileMenu().getStartMenuItem().setEnabled(false);
		}
		// disable logout (white) if no white player logged in
		if (mainEngine.getWhitePlayer() == null) {
			mainFrame.getMainMenuBar().getFileMenu().getLogoutWhiteMenuItem().setEnabled(false);
		}
		// disable logout (black) if no white black logged in
		if (mainEngine.getBlackPlayer() == null) {
			mainFrame.getMainMenuBar().getFileMenu().getLogoutBlackMenuItem().setEnabled(false);
		}
		updateFonts(mainFrame);
		mainFrame.repaint();
		mainFrame.revalidate();
	}

	// update all tiles with appropriate images
	public void updateTiles() {
		Tile[][] tileArray = mainFrame.getMainBoardPanel().getTiles();
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				Piece basePiece = mainEngine.getGameBoard().getPiece(c, r);
				Piece mergedPiece = null;
				if (basePiece != null) {
					mergedPiece = basePiece.getMergedPiece();
				}
				// set icon for base and inner merged piece (null if no merge)
				ImageIcon baseIcon = PieceIconTools.pieceToImageIcon(basePiece);
				ImageIcon mergedIcon = null;
				if (mergedPiece != null) {
					mergedIcon = PieceIconTools.pieceToImageIcon(mergedPiece, basePiece.getColor());
				}
				// icon is null if no piece there
				if (basePiece == null) {
					baseIcon = null;
				}
				tileArray[c][r].setImage(baseIcon, mergedIcon);

			}
		}
		updateFonts(mainFrame);
		mainFrame.getMainBoardPanel().repaint();
		mainFrame.getMainBoardPanel().revalidate();
	}

	// get the player details for the player panel updates
	public String[][] getPlayerDetails() {
		Player[] tempPlayers = new Player[2];
		tempPlayers[0] = mainEngine.getWhitePlayer();
		tempPlayers[1] = mainEngine.getBlackPlayer();
		String[][] details = new String[2][4];
		for (int i = 0; i < tempPlayers.length; i++) {
			Player tempPlayer = tempPlayers[i];
			if (tempPlayer != null) {
				// set contents of details to ID, name, total points per player
				details[i] = new String[4];
				details[i][0] = "ID: " + tempPlayer.getID();
				details[i][1] = "Name: " + tempPlayer.getName();
				details[i][2] = "Total Points: " + tempPlayer.getPoints();
				int tempPoints = 0;
				if (i == 0) {
					tempPoints = mainFrame.getGUIModel().getMainEngine().getWhitePlayerPoints();
				} else {
					tempPoints = mainFrame.getGUIModel().getMainEngine().getBlackPlayerPoints();
				}
				// add current points to details
				details[i][3] = "Current Points: " + tempPoints;

			}
		}
		return details;
	}

	// get the status details for the status panel updates
	public String[] getStatusDetails() {
		String tempID = "";
		Player tempPlayer = mainEngine.getCurrentPlayer();
		// get current player identifier (name and ID)
		if (tempPlayer != null) {
			tempID = tempPlayer.getName() + "(" + tempPlayer.getID() + ")";
		}
		String[] statusDetails = new String[3];
		// set statusDetails to contain current player, current turns and max turns 
		statusDetails[0] = "Current Player: " + tempID;

		statusDetails[1] = "Turns Played: " + mainFrame.getGUIModel().getMainEngine().getNumTurns() / 2;

		statusDetails[2] = "Max Turns: " + +mainFrame.getGUIModel().getMainEngine().getMaxTurns() / 2;
		return statusDetails;
	}
}
