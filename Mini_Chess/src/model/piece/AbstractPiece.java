package model.piece;

public abstract class AbstractPiece implements Piece {

	private String COLOR;
	private int move1Spaces;
	private int move2Spaces;
	private int posX;
	private int posY;
	private String pieceID;

	public AbstractPiece(String pieceID, String COLOR, int posX, int posY) {

		this.posX = posX;
		this.posY = posY;
		this.COLOR = COLOR;
		this.pieceID = pieceID;

	}

	public boolean checkMovement() {
		return false;
	}

	public String getColor() {
		return this.COLOR;
	}

	public String getPieceId() {

		return this.pieceID;
	}

	@Override
	public String toString() {

		return (String.format("pieceID: id=%s, COLOR=%s, posX=%s, posY=%s ", pieceID, COLOR, posX,
				posY));

	}

}
