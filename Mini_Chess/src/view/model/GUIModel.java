package view.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.GameBoardImpl;
import model.GameEngine;
import model.Player;
import model.piece.Piece;
import view.components.BaseFrame;
import view.components.LoginMenuItem;
import view.components.LogoutMenuItem;
import view.components.RegisterMenuItem;
import view.components.StartMenuItem;
import view.components.SwapMenuItem;
import view.components.Tile;
import view.utilities.PieceIconTools;

public class GUIModel {
	private GameEngine mainEngine;
	private BaseFrame mainFrame;
	private Piece selected;
	public final static Font normalFont = new Font("Century Gothic", Font.PLAIN, 20);

	public GUIModel(GameEngine mainEngine) {
		// TODO Auto-generated constructor stub
		this.mainEngine = mainEngine;
	}

	public BaseFrame getMainFrame() {
		// TODO Auto-generated method stub
		return mainFrame;
	}

	public void setMainFrame(BaseFrame newFrame) {
		mainFrame = newFrame;
		updateTiles();
		mainFrame.getMainStatusPanel().updateInfo();
		updateFonts(mainFrame);
	}
	
	public static void updateFonts(Component c) {
		c.setFont(GUIModel.normalFont);
		if(c instanceof Container) {
			for(Component child : ((Container) c).getComponents()) {
				updateFonts(child);
			}
		}
	}

	public GameEngine getMainEngine() {
		// TODO Auto-generated method stub
		return mainEngine;
	}

	public void selectTile(int xPos, int yPos) {
		selectTile(xPos, yPos, false);

	}

	public void selectTile(int xPos, int yPos, boolean isSplit) {

		// TODO Auto-generated method stub
		// System.out.println("hey boy");
		if (selected == null) {
			// System.out.println(mainEngine.getGameBoard().getChessBoard()[xPos][yPos]);

			selected = mainEngine.selectPiece(xPos, yPos);

		} else {
			// System.out.println(mainEngine.getGameBoard().getChessBoard()[selected.getPosX()][selected.getPosY()]);
			if (isSplit && mainEngine.getGameBoard().getPiece(selected.getPosX(), selected.getPosY())
					.getMergedPiece() != null) {
				mainEngine.movePiece(
						mainEngine.getGameBoard().getPiece(selected.getPosX(), selected.getPosY()).getMergedID(), xPos,
						yPos);

			} else {
				mainEngine.movePiece(mainEngine.getGameBoard().getChessBoard()[selected.getPosX()][selected.getPosY()],
						xPos, yPos);
			}

			selected = null;
		}

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
					mainFrame.getMainBoardPanel().getTiles()[c][r]
							.updateBorder(BorderFactory.createLineBorder(new Color(0, 120, 255), 5));

					for (Piece p : mainEngine.getGameBoard().getPieces().values()) {
						if (p.getColor() != null) {
							if (!p.getColor().equals(mainEngine.getGameBoard().getPiece(xPos, yPos).getColor())) {
								if (p.validMove((GameBoardImpl) mainEngine.getGameBoard(), c, r)) {
									mainFrame.getMainBoardPanel().getTiles()[c][r]
											.updateBorder(BorderFactory.createLineBorder(new Color(255, 128, 0), 5));
								}
							}
						}

						// if (!p.getColor().equals(mainEngine.getGameBoard().getPiece(xPos,
						// yPos).getColor())) {
						// if (p.getPosX() != -1 && p.getPosY() != -1) {
						// if (p.validMove((GameBoardImpl) mainEngine.getGameBoard(), xPos, yPos)) {
						// mainFrame.getMainBoardPanel().getTiles()[c][r]
						// .updateBorder(BorderFactory.createLineBorder(Color.RED, 3));
						// }
						// }
						// }
					}

				} else {
					mainFrame.getMainBoardPanel().getTiles()[c][r].updateBorder(null);
				}

			}
		}
	}

	public void updateBoard() {
		updateTiles();
		mainFrame.getMainStatusPanel().updateInfo();
		updateFonts(mainFrame);
	}

	public boolean isGameStarted() {
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
		// mainFrame.getMainMenuBar().getFileMenu().getRegisterMenuItem().setEnabled(true);
		mainFrame.getMainMenuBar().getFileMenu().getLoginMenuItem().setEnabled(true);
		mainFrame.getMainMenuBar().getFileMenu().getStartMenuItem().setEnabled(true);
		mainFrame.getMainMenuBar().getFileMenu().getLogoutWhiteMenuItem().setEnabled(true);
		mainFrame.getMainMenuBar().getFileMenu().getLogoutBlackMenuItem().setEnabled(true);
		mainFrame.getMainMenuBar().getFileMenu().getSwapMenuItem().setEnabled(true);

		if (mainEngine.getWhitePlayer() != null && mainEngine.getBlackPlayer() != null) {
			mainFrame.getMainMenuBar().getFileMenu().getLoginMenuItem().setEnabled(false);

		}
		if (mainEngine.getWhitePlayer() == null && mainEngine.getBlackPlayer() == null || isGameStarted()) {
			mainFrame.getMainMenuBar().getFileMenu().getSwapMenuItem().setEnabled(false);
		}
		if (isGameStarted() || mainEngine.getWhitePlayer() == null || mainEngine.getBlackPlayer() == null) {
			mainFrame.getMainMenuBar().getFileMenu().getStartMenuItem().setEnabled(false);
		}
		if (mainEngine.getWhitePlayer() == null) {
			mainFrame.getMainMenuBar().getFileMenu().getLogoutWhiteMenuItem().setEnabled(false);
		}
		if (mainEngine.getBlackPlayer() == null) {
			mainFrame.getMainMenuBar().getFileMenu().getLogoutBlackMenuItem().setEnabled(false);
		}
		updateFonts(mainFrame);
		mainFrame.repaint();
		mainFrame.revalidate();
	}

	public void updateTiles() {
		Tile[][] tileArray = mainFrame.getMainBoardPanel().getTiles();
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 6; c++) {
				Piece basePiece = mainEngine.getGameBoard().getPiece(c, r);
				Piece mergedPiece = null;
				if (basePiece != null) {
					mergedPiece = basePiece.getMergedPiece();
				}

				ImageIcon baseIcon = PieceIconTools.pieceToImageIcon(basePiece);
				ImageIcon mergedIcon = null;
				if (mergedPiece != null) {
					mergedIcon = PieceIconTools.pieceToImageIcon(mergedPiece, basePiece.getColor());
				}

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

	public String[][] getPlayerDetails() { 
		Player[] tempPlayers = new Player[2];
		tempPlayers[0] = mainEngine.getWhitePlayer();
		tempPlayers[1] = mainEngine.getBlackPlayer();
		String[][] details = new String[2][4];
		for (int i = 0; i < tempPlayers.length; i++) {
			Player tempPlayer = tempPlayers[i];
			if (tempPlayer != null) {
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
				details[i][3] = "Current Points: " + tempPoints;

			}
		}
		return details;
	}

	public String[] getStatusDetails() {
		String tempID = "";
		Player tempPlayer = mainEngine.getCurrentPlayer();
		if(tempPlayer != null) {
			tempID = tempPlayer.getName() + "(" + tempPlayer.getID() + ")";
		}
		String[] statusDetails = new String[3];
		statusDetails[0] = "Current Player: " + tempID;
		
		statusDetails[1] = "Turns Played: " + mainFrame.getGUIModel().getMainEngine().getNumTurns()/2;
		
		statusDetails[2] = "Max Turns: " + + mainFrame.getGUIModel().getMainEngine().getMaxTurns()/2;
		return statusDetails;
	}
}
