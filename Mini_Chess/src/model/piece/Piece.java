package model.piece;

import model.GameBoardImpl;

public interface Piece {

	public abstract boolean checkMovement(GameBoardImpl gameBoard);

	public abstract String getColor();


}
