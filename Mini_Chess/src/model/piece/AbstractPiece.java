package model.piece;

import model.GameBoardImpl;

public abstract class AbstractPiece implements Piece {

	private String COLOR;
	private int move1Spaces;
	private int move2Spaces;
	private int posX;
	private int posY;

	public AbstractPiece(String COLOR, int posX, int posY) {

		this.posX = posX;
		this.posY = posY;
		this.COLOR = COLOR;

	}

	public String getColor() {
		return this.COLOR;
	}

	@Override
	public String toString() {

		return (String.format(" Color=%s, posX=%s, posY=%s ", COLOR, posX, posY));

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

	public boolean inBoardLimits(int x, int y) {
		if (x > 5 || x < 0 || y > 5 || y < 0) {
			return false;
		}

		return true;

	}

	public boolean sameTeam(GameBoardImpl gameBoard, int x, int y) {

		if (!inBoardLimits(x, y)) {
			return false;
		}

		// check to see if position has a piece
		if (gameBoard.getChessBoard()[x][y] != null) {

			// check color of piece moving to corresponding piece
			if (gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).getColor() == this.COLOR) {

				return true;

			}
		}
		return false;

	}

}
