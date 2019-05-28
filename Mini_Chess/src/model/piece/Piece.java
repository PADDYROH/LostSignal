package model.piece;

import model.GameBoardImpl;

public abstract class Piece {

	private String COLOR;

	protected int posX;
	protected int posY;
	private Piece mergedPiece;
	private String mergedID;

	public Piece(String COLOR, int posX, int posY) {

		this.posX = posX;
		this.posY = posY;
		this.COLOR = COLOR;

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

	public boolean split(GameBoardImpl gameBoard) {

		gameBoard.getPieces().get(mergedID).setCOLOR(getColor());
		this.mergedPiece = null;
		return true;
	}

	public boolean checkMovement(GameBoardImpl gameBoard, int x, int y) {
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

			this.posX = x;
			this.posY = y;
			return true;
		}

		return false;
	}

	public boolean validMove(GameBoardImpl gameBoard, int x, int y) {

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

	public void splitPiece(GameBoardImpl gameBoard, Piece piece, int x, int y) {
		// possibly can be checked inside the gui but probs here aswell to be safe

		if (mergedPiece != null) {
			if (piece.equals(mergedPiece)) {
				gameBoard.getPieces().get(mergedID).setCOLOR(this.getColor());
				gameBoard.getPieces().get(mergedID).setPosX(x);
				gameBoard.getPieces().get(mergedID).setPosY(y);
			} else {

				gameBoard.getPieces().get(mergedID).setCOLOR(this.getColor());
				gameBoard.getPieces().get(mergedID).setPosX(this.getPosX());
				gameBoard.getPieces().get(mergedID).setPosY(this.getPosY());

				this.setPosX(x);
				this.setPosY(y);

			}
		}
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

	public int getPosY() {
		return posY;
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

	public boolean pieceMovement(GameBoardImpl gameBoard, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
