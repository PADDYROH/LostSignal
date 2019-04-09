package model.piece;

import model.GameBoardImpl;

public interface Piece {

	public abstract boolean checkMovement(GameBoardImpl gameBoard, int x, int y);

	public abstract String getColor();

	public abstract String getCOLOR();

	public void setCOLOR(String cOLOR);

	public int getPosX();

	public void setPosX(int posX);

	public int getPosY();

	public void setPosY(int posY);

}
