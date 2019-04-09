package model.piece;

public abstract class AbstractPiece implements Piece {

	private String COLOR;
	private int move1Spaces;
	private int move2Spaces;
	private int posX;
	private int posY;


	public AbstractPiece( String COLOR, int posX, int posY) {

		this.posX = posX;
		this.posY = posY;
		this.COLOR = COLOR;


	}


	public String getColor() {
		return this.COLOR;
	}

	@Override
	public String toString() {

		return (String.format(" COLOR=%s, posX=%s, posY=%s ", COLOR, posX,
				posY));

	}


	public String getCOLOR() {
		return COLOR;
	}


	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}


	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}

}
