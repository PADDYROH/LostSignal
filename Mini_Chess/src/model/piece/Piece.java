package model.piece;

import model.GameBoardImpl;

public interface Piece {

	public boolean checkMovement(GameBoardImpl gameBoard, int x, int y);

	public boolean validMove(GameBoardImpl gameBoard, int x, int y);

	public abstract String getColor();

	public abstract String getCOLOR();

	public void setCOLOR(String cOLOR);

	public int getPosX();

	public void setPosX(int posX);

	public int getPosY();

	public void setPosY(int posY);

	boolean pieceMovement(GameBoardImpl gameBoard, int x, int y);

	public Object getMergedPiece();

	public void setMergedPiece(Piece p);

	public String getMergedID();

}
