package model.piece;

import model.GameBoardImpl;

public class Knight extends Piece {

	public Knight(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);
	}

	@Override
	public boolean pieceMovement(GameBoardImpl gameBoard, int x, int y) {

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
