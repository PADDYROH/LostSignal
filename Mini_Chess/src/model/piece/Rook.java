package model.piece;

import model.GameBoardImpl;

public class Rook extends AbstractPiece {

	private String COLOR;
	private int posX;
	private int posY;

	public Rook(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);

		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public boolean checkMovement(GameBoardImpl gameBoard, int x, int y) {

		if (gameBoard.getChessBoard()[x][y] != null) {
			return false;
		}
		if (posX - x == -1 || posX - x == -2 && posY == y) {
			posX = x;
			return true;
		}

		if (posY - y == -1 || posY - y == -2 && posX == x) {
			posY = y;
			return true;
		}

		return false;
	}

}
