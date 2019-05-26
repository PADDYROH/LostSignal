package view.model;

import java.awt.Color;

import javax.swing.BorderFactory;

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
		// TODO Auto-generated method stub
		// System.out.println("hey boy");
		if (selected == null) {
			// System.out.println(mainEngine.getGameBoard().getChessBoard()[xPos][yPos]);
			
			selected = mainEngine.selectPiece(xPos, yPos);

		} else {
			// System.out.println(mainEngine.getGameBoard().getChessBoard()[selected.getPosX()][selected.getPosY()]);
			mainEngine.movePiece(mainEngine.getGameBoard().getChessBoard()[selected.getPosX()][selected.getPosY()],
					xPos, yPos);
			selected = null;
		}

		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 6; c++) {
				if (selected != null && mainEngine.checkMove(xPos, yPos, c, r)) {
					mainFrame.getMainBoardPanel().getTiles()[c][r]
							.updateBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
				} else {
					mainFrame.getMainBoardPanel().getTiles()[c][r].updateBorder(null);
				}

			}
		}

	}

	public void updateBoard() {
		mainFrame.getMainBoardPanel().updateTiles();

	}

	public boolean isGameStarted() {
		return (mainEngine.getMaxTurns() > 0) && (mainEngine.getWhitePlayer() != null) && (mainEngine.getBlackPlayer() != null);
	}

}
