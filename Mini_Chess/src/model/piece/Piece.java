package model.piece;

public interface Piece {

	public abstract boolean checkMovement();

	public abstract void upgradePiece();

	public abstract String getColor();

}
