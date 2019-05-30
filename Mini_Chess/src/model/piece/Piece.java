package model.piece;

import model.GameBoard;
import model.GameBoardImpl;

public abstract class Piece {

	// define the movement length of a pice
	protected static final int MOVE_BY_ONE = 1;
	protected static final int MOVE_BY_TWO = 2;
	// define the board limits
	private static final int BOARD_LIMIT = 5;

	private String COLOR;
	protected int posX;
	protected int posY;
	private Piece mergedPiece;
	private String mergedID;

	public Piece(String COLOR, int posX, int posY) {
		this.mergedPiece = null;
		this.posX = posX;
		this.posY = posY;
		this.COLOR = COLOR;

	}

	public boolean split(GameBoardImpl gameBoard) {

		gameBoard.getPieces().get(mergedID).setCOLOR(getColor());
		this.mergedPiece = null;
		return true;
	}

	public boolean checkMovement(GameBoard gameBoard, int x, int y) {
		// keeps x and y with in bounds
		if (!inBoardLimits(x, y)) {
			return false;
		}
		// checks if move is valid
		if (validMove(gameBoard, x, y)) {

			if (gameBoard.getChessBoard()[x][y] != null) {
				Piece piece = gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]);

				if (!sameTeam(gameBoard, x, y)) {

					piece.setCOLOR(null);
					piece.setPosX(-1);
					piece.setPosY(-1);

				} else {
					// check that piece on same team isn't of same type
					if (piece.getClass().equals(this.getClass()) && piece.getColor().equals(this.getColor())) {
						return false;
					}

					if (piece.getMergedPiece() != null) {
						return false;
					}
					if (this.mergedPiece != null) {
						return false;
					} else {
						mergedID = gameBoard.getChessBoard()[x][y];
						mergedPiece = gameBoard.getPieces().get(mergedID);
						mergedPiece.setCOLOR(null);
					}

				}
			}
			return true;
		}

		return false;
	}

	public boolean validMove(GameBoard gameBoard, int x, int y) {

		Piece piece = gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]);

		boolean validMove = false;
		if (mergedPiece == null) {
			if (piece != null) {
				if (piece.getClass().equals(this.getClass()) && piece.getColor().equals(this.getColor())) {
					return false;
				}
			}

			validMove = pieceMovement(gameBoard, x, y);
		} else {
			if (piece != null) {
				if (piece.getColor() == this.getColor()) {
					return false;
				}
			}
			if (gameBoard.getPieces().get(mergedID).pieceMovement(gameBoard, x, y) == true
					|| this.pieceMovement(gameBoard, x, y) == true) {

				validMove = true;
			} else {
				validMove = false;
			}
		}
		return validMove;
	}

	public String getColor() {
		return this.COLOR;
	}

	@Override
	public String toString() {

		return (String.format(" Color=%s, posX=%s, posY=%s ", COLOR, posX, posY));

	}

	public boolean sameTeam(GameBoard gameBoard, int x, int y) {

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

	public boolean pieceMovement(GameBoard gameBoard, int x, int y) {
		// NOTE: piece must overide for movement logic
		return false;
	}

	public boolean inBoardLimits(int x, int y) {
		if (x > BOARD_LIMIT || BOARD_LIMIT < 0 || y > BOARD_LIMIT || y < 0) {
			return false;
		}

		return true;

	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Piece getMergedPiece() {
		return mergedPiece;
	}

	public String getMergedID() {
		// TODO Auto-generated method stub
		return this.mergedID;
	}

	public void setMergedPiece(Piece p) {

		this.mergedPiece = p;

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

	public int getPosY() {
		return posY;
	}

}
