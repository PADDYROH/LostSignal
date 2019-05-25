package model.piece;

import model.GameBoardImpl;

public class Bishop extends AbstractPiece {

	private String COLOR;

	public Bishop(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);
	}

	public boolean validMove(GameBoardImpl gameBoard, int x, int y) {

		if (posX + 1 == x && posY + 1 == y || posX - 1 == x && posY - 1 == y) {
			return true;
		}

		if (posX - 1 == x && posY + 1 == y || posX + 1 == x && posY - 1 == y) {
			return true;
		}

		if (posX + 2 == x && posY + 2 == y) {

			if (gameBoard.getChessBoard()[posX + 1][posY + 1] != null) {
				return false;
			}
			return true;
		}

		if (posX + 2 == x && posY - 2 == y) {

			if (gameBoard.getChessBoard()[posX + 1][posY - 1] != null) {
				return false;
			}
			return true;
		}

		if (posX - 2 == x && posY - 2 == y) {
			if (gameBoard.getChessBoard()[posX - 1][posY - 1] != null) {
				return false;
			}
			return true;
		}

		if (posX - 2 == x && posY + 2 == y) {
			if (gameBoard.getChessBoard()[posX - 1][posY + 1] != null) {
				return false;
			}
			return true;
		}

		return false;

	}

}
