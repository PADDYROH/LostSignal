package model.piece;

import model.GameBoard;

public class Bishop extends Piece {

	public Bishop(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);

	}

	/*
	 * this is a bishop movement logic NOTE: can only move in a diagonal direction
	 * either by one or two spaces
	 */
	@Override
	public boolean pieceMovement(GameBoard gameBoard, int x, int y) {

		if (posX + MOVE_BY_ONE == x && posY + MOVE_BY_ONE == y || posX - MOVE_BY_ONE == x && posY - MOVE_BY_ONE == y) {
			return true;
		}

		if (posX - MOVE_BY_ONE == x && posY + MOVE_BY_ONE == y || posX + MOVE_BY_ONE == x && posY - MOVE_BY_ONE == y) {
			return true;
		}

		if (posX + MOVE_BY_TWO == x && posY + MOVE_BY_TWO == y) {

			if (gameBoard.getChessBoard()[posX + 1][posY + 1] != null) {
				return false;
			}
			return true;
		}

		if (posX + MOVE_BY_TWO == x && posY - MOVE_BY_TWO == y) {

			if (gameBoard.getChessBoard()[posX + MOVE_BY_ONE][posY - MOVE_BY_ONE] != null) {
				return false;
			}
			return true;
		}

		if (posX - MOVE_BY_TWO == x && posY - MOVE_BY_TWO == y) {
			if (gameBoard.getChessBoard()[posX - MOVE_BY_ONE][posY - MOVE_BY_ONE] != null) {
				return false;
			}
			return true;
		}

		if (posX - MOVE_BY_TWO == x && posY + MOVE_BY_TWO == y) {
			if (gameBoard.getChessBoard()[posX - MOVE_BY_ONE][posY + MOVE_BY_ONE] != null) {
				return false;
			}
			return true;
		}

		return false;

	}

}
