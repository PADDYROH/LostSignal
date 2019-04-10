package model.piece;

import model.GameBoardImpl;

public class Bishop extends AbstractPiece {

	public Bishop(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);
	}

	@Override
	public boolean checkMovement(GameBoardImpl gameBoard, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
