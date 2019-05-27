package view.model;

import java.awt.Color;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.GameBoardImpl;
import model.GameEngine;
import model.piece.Piece;
import view.components.BaseFrame;

public class GUIModel {
	private GameEngine mainEngine;
	private BaseFrame mainFrame;
	private Piece selected;

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
				if(selected != null) {
					Piece existingPiece = mainEngine.getGameBoard().getPiece(c, r);
					if(existingPiece != null) {
						if(existingPiece.getColor().equals(mainEngine.getGameBoard().getPiece(xPos, yPos).getColor())) {
							if(existingPiece.getMergedPiece() != null) {
								checkMerged = true;
							}
						}
					}
				}
				
				if (selected != null && mainEngine.checkMove(xPos, yPos, c, r) && !checkMerged) {
					mainFrame.getMainBoardPanel().getTiles()[c][r]
							.updateBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
					
					for (Piece p : mainEngine.getGameBoard().getPieces().values()) {
						if(p.getColor() != null) {
							if(!p.getColor().equals(mainEngine.getGameBoard().getPiece(xPos, yPos).getColor())) {
								if(p.validMove((GameBoardImpl) mainEngine.getGameBoard(), c, r)) {
									mainFrame.getMainBoardPanel().getTiles()[c][r]
											.updateBorder(BorderFactory.createLineBorder(Color.RED, 3));
								}
							}
						}
						
//						if (!p.getColor().equals(mainEngine.getGameBoard().getPiece(xPos, yPos).getColor())) {
//							if (p.getPosX() != -1 && p.getPosY() != -1) {
//								if (p.validMove((GameBoardImpl) mainEngine.getGameBoard(), xPos, yPos)) {
//									mainFrame.getMainBoardPanel().getTiles()[c][r]
//											.updateBorder(BorderFactory.createLineBorder(Color.RED, 3));
//								}
//							}
//						}
					}

				} else {
					mainFrame.getMainBoardPanel().getTiles()[c][r].updateBorder(null);
				}

			}
		}
	}

	public void updateBoard() {
		mainFrame.getMainBoardPanel().updateTiles();
		mainFrame.getMainStatusPanel().updateInfo();

	}

	public boolean isGameStarted() {
		return (mainEngine.getMaxTurns() > 0) && (mainEngine.getWhitePlayer() != null)
				&& (mainEngine.getBlackPlayer() != null);
	}

	public void updateCurrentPlayers() {
		mainFrame.getMainPlayerPanel().updatePlayerList();
		mainFrame.getMainStatusPanel().updateInfo();

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

		JOptionPane.showMessageDialog(null, winPanel, "Game Over!", JOptionPane.DEFAULT_OPTION);

	}

}
