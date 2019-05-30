package model.piece;

import model.GameBoard;

public class Rook extends Piece {

	public Rook(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);

	}

	/*
	 * this is a bishop movement logic, NOTE: rooks can move by two or one on either
	 * axis
	 */
	@Override
	public boolean pieceMovement(GameBoard gameBoard, int x, int y) {

		if (posX + MOVE_BY_ONE == x && posY == y || posY + MOVE_BY_ONE == y && posX == x) {
			return true;
		}

		if (posX - MOVE_BY_ONE == x && posY == y || posY - MOVE_BY_ONE == y && posX == x) {
			return true;
		}

		if (posX + MOVE_BY_TWO == x && posY == y) {

			if (gameBoard.getChessBoard()[posX + MOVE_BY_ONE][y] != null) {

				return false;
			}

			return true;
		}

		if (posY + MOVE_BY_TWO == y && posX == x) {

			if (gameBoard.getChessBoard()[x][posY + MOVE_BY_ONE] != null) {

				return false;
			}
			return true;
		}

		if (posX - MOVE_BY_TWO == x && posY == y) {

			if (gameBoard.getChessBoard()[posX - MOVE_BY_ONE][y] != null) {

				return false;
			}

			return true;
		}

		if (posY - MOVE_BY_TWO == y && posX == x) {

			if (gameBoard.getChessBoard()[x][posY - MOVE_BY_ONE] != null) {

				return false;
			}
			return true;
		}

		return false;
	}

}
