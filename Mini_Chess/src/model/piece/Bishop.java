package model.piece;

import model.GameBoardImpl;

public class Bishop extends AbstractPiece {

	private String COLOR;
	private int posX;
	private int posY;

	public Bishop(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);

		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public boolean checkMovement(GameBoardImpl gameBoard, int x, int y) {

		// check if piece is same color
		if (sameTeam(gameBoard, x, y)) {
			return false;
		}

		// keeps x and y with in bounds
		if (!inBoardLimits(x, y)) {
			return false;
		}

		// check if move is valid
		if (validMove(gameBoard, x, y)) {

			posX = x;
			posY = y;
			return true;
		}

		return false;
	}

	public boolean validMove(GameBoardImpl gameBoard, int x, int y) {

		if (posX + 1 == x && posY + 1 == y || posX - 1 == x && posY - 1 == y) {
			return true;
		}

		if (posX - 1 == x && posY + 1 == y || posX + 1 == x && posY - 1 == y) {
			return true;
		}

		if (posX + 2 == x && posY + 2 == y) {

			if (gameBoard.getChessBoard()[posX + 1][posY + 1] != null) {
				return false;
			}
			return true;
		}

		if (posX + 2 == x && posY - 2 == y) {

			if (gameBoard.getChessBoard()[posX + 1][posY - 1] != null) {
				return false;
			}
			return true;
		}

		if (posX - 2 == x && posY - 2 == y) {
			if (gameBoard.getChessBoard()[posX - 1][posY - 1] != null) {
				return false;
			}
			return true;
		}

		if (posX - 2 == x && posY + 2 == y) {
			if (gameBoard.getChessBoard()[posX - 1][posY + 1] != null) {
				return false;
			}
			return true;
		}

		return false;

	}

}
