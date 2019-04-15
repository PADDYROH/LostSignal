package model.piece;

import model.GameBoardImpl;

public class Knight extends AbstractPiece {

	private int posX;
	private int posY;

	public Knight(String COLOR, int posX, int posY) {
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

		if (validMove(gameBoard, x, y)) {
			
			if (!sameTeam(gameBoard, x, y)) {
				System.out.println("dead boi");
			}

			posX = x;
			posY = y;
			return true;
		}

		return false;
	}

	@Override
	public boolean validMove(GameBoardImpl gameBoard, int x, int y) {

		if (posX - 1 == x && posY + 2 == y || posX + 1 == x && posY + 2 == y) {
			return true;
		}

		if (posX - 2 == x && posY + 1 == y || posX + 2 == x && posY + 1 == y) {
			return true;
		}

		if (posX - 2 == x && posY - 1 == y || posX + 2 == x && posY - 1 == y) {
			return true;
		}

		if (posX - 1 == x && posY - 2 == y || posX + 1 == x && posY - 2 == y) {
			return true;
		}

		return false;
	}

}
