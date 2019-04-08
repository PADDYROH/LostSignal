package model.piece;

public abstract class AbstractPiece implements Piece {

	private String color;
	private int move1Spaces;
	private int move2Spaces;
	private int posX;
	private int posY;

	public AbstractPiece(String color, int posX, int posY) {

		this.posX = posX;
		this.posY = posY;
		this.color = color;

	}

	public boolean checkMovement() {
		return false;
	}

	public String getColor() {
		return this.color;
	}

}
