package model.piece;

import model.GameBoard;

public class Knight extends Piece {

	public Knight(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);
	}

	/*
	 * this is a bishop movement logic // NOTE: can only move two up and one across
	 * or vice-versa , also has less checks because it can jump over pieces
	 */
	@Override
	public boolean pieceMovement(GameBoard gameBoard, int x, int y) {

		if (posX - MOVE_BY_ONE == x && posY + MOVE_BY_TWO == y || posX + MOVE_BY_ONE == x && posY + MOVE_BY_TWO == y) {
			return true;
		}

		if (posX - MOVE_BY_TWO == x && posY + MOVE_BY_ONE == y || posX + MOVE_BY_TWO == x && posY + MOVE_BY_ONE == y) {
			return true;
		}

		if (posX - MOVE_BY_TWO == x && posY - MOVE_BY_ONE == y || posX + MOVE_BY_TWO == x && posY - MOVE_BY_ONE == y) {
			return true;
		}

		if (posX - MOVE_BY_ONE == x && posY - MOVE_BY_TWO == y || posX + MOVE_BY_ONE == x && posY - MOVE_BY_TWO == y) {
			return true;
		}

		return false;
	}

}
