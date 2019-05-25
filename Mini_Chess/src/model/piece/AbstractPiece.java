package model.piece;

import model.GameBoardImpl;

public abstract class AbstractPiece implements Piece {

	private String COLOR;
	private int move1Spaces;
	private int move2Spaces;
	protected int posX;
	protected int posY;
	protected Piece mergedPiece;

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

	@Override
	public boolean checkMovement(GameBoardImpl gameBoard, int x, int y) {
		System.out.println("soadjfngjksdfnsjkdfngsjkdfgsdjkfgnds");
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

				} else {
					System.out.println(gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).getClass());
				}
			}
			this.posX = x;
			this.posY = y;
			return true;
		}

		return false;
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
