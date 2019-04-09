package model.piece;

import model.GameBoardImpl;

public class Knight extends AbstractPiece {

	public Knight(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);
	}

	@Override
	public boolean checkMovement(GameBoardImpl gameBoard) {
		// TODO Auto-generated method stub
		return false;
	}

}
