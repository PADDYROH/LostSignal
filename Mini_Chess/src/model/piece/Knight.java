package model.piece;

import model.GameBoardImpl;

public class Knight extends Piece {

	public Knight(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);

	}

	@Override
	public boolean pieceMovement(GameBoardImpl gameBoard, int x, int y) {

		if (posX - 1 == x && posY + 2 == y || posX + 1 == x && posY + 2 == y) {
			return true;
		}

		if (posX - 2 == x && posY + 1 == y || posX + 2 == x && posY + 1 == y) {
			return true;
		}

		if (posX - 2 == x && posY - 1 == y || posX + 2 == x && posY - 1 == y) {
			return true;
		}

		if (posX - 1 == x && posY - 2 == y || posX + 1 == x && posY - 2 == y) {
			return true;
		}

		return false;
	}

}
