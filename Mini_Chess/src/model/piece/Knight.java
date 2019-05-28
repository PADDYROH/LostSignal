package model.piece;

import model.GameBoardImpl;

public class Knight extends AbstractPiece {

	private int posX;
	private int posY;
	private Piece mergedPiece;
	private String mergedID;
	private String COLOR;

	public Knight(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);
		mergedPiece = null;
		this.posX = posX;
		this.posY = posY;
	}

	@Override
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

	@Override
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

	@Override
	public boolean pieceMovement(GameBoardImpl gameBoard, int x, int y) {

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

	@Override
	public Piece getMergedPiece() {
		return mergedPiece;
	}

	@Override
	public String getMergedID() {
		// TODO Auto-generated method stub
		return this.mergedID;
	}

	@Override
	public void setMergedPiece(Piece p) {

		this.mergedPiece = p;

	}

	@Override
	public void setPosY(int posY) {
		this.posY = posY;
		super.setPosY(posY);
	}

	@Override
	public void setPosX(int posX) {
		this.posX = posX;
		super.setPosX(posX);
	}

	@Override
	public boolean split(GameBoardImpl gameBoard) {

		gameBoard.getPieces().get(mergedID).setCOLOR(getColor());
		this.mergedPiece = null;
		return true;
	}

}
