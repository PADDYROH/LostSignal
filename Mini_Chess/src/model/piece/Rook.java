package model.piece;

import model.GameBoardImpl;

public class Rook extends Piece {

	public Rook(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);

	}

	@Override
	public boolean pieceMovement(GameBoardImpl gameBoard, int x, int y) {

		if (posX + 1 == x && posY == y || posY + 1 == y && posX == x) {
			return true;
		}

		if (posX - 1 == x && posY == y || posY - 1 == y && posX == x) {
			return true;
		}

		if (posX + 2 == x && posY == y) {

			if (gameBoard.getChessBoard()[posX + 1][y] != null) {

				return false;
			}

			return true;
		}

		if (posY + 2 == y && posX == x) {

			if (gameBoard.getChessBoard()[x][posY + 1] != null) {

				return false;
			}
			return true;
		}

		if (posX - 2 == x && posY == y) {

			if (gameBoard.getChessBoard()[posX - 1][y] != null) {

				return false;
			}

			return true;
		}

		if (posY - 2 == y && posX == x) {

			if (gameBoard.getChessBoard()[x][posY - 1] != null) {

				return false;
			}
			return true;
		}

		return false;
	}

}
