package model.piece;

import model.GameBoardImpl;

public class Rook extends AbstractPiece {

	public Rook(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);
	}

	@Override
	public boolean checkMovement( GameBoardImpl gameBoard) {
		return false;

	}


}
