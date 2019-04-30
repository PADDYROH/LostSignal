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

		
		// check if piece is same color
		if (sameTeam(gameBoard, x, y)) {
			return false;
		}

		// keeps x and y with in bounds
		if (!inBoardLimits(x, y)) {
			return false;
		}

		// checks if move is valid
		if (validMove(gameBoard, x, y)) {

			if (gameBoard.getChessBoard()[x][y] != null) {
				if (!sameTeam(gameBoard, x, y)) {

					gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).setCOLOR(null);
					gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).setPosX(-1);
					gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).setPosY(-1);

				}
			}

			posX = x;
			posY = y;
			return true;
		}

		return false;
	}

	@Override
	public boolean validMove(GameBoardImpl gameBoard, int x, int y) {

		if (posX + 1 == x && posY == y || posY + 1 == y && posX == x) {
			return true;
		}

		if (posX - 1 == x && posY == y || posY - 1 == y && posX == x) {
			return true;
		}

		if (posX + 2 == x && posY == y) {

			if (gameBoard.getChessBoard()[posX + 1][y] != null) {

				return false;
			}

			return true;
		}

		if (posY + 2 == y && posX == x) {

			if (gameBoard.getChessBoard()[x][posY + 1] != null) {

				return false;
			}
			return true;
		}

		if (posX - 2 == x && posY == y) {

			if (gameBoard.getChessBoard()[posX - 1][y] != null) {

				return false;
			}

			return true;
		}

		if (posY - 2 == y && posX == x) {

			if (gameBoard.getChessBoard()[x][posY - 1] != null) {

				return false;
			}
			return true;
		}

		return false;
	}

}
