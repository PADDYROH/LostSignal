package model.piece;

import model.GameBoardImpl;

public class Rook extends AbstractPiece {
	private String COLOR;

	private int posX;
	private int posY;
	private Piece mergedPiece;
	private String mergedID;

	public Rook(String COLOR, int posX, int posY) {
		super(COLOR, posX, posY);
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
				if (!sameTeam(gameBoard, x, y)) {

					gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).setCOLOR(null);
					gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).setPosX(-1);
					gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).setPosY(-1);

				} else {
					// check that piece on same team isn't of same type
					if (this.equals(gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]))) {
						return false;
					}
					mergedPiece = gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]);
					mergedID = gameBoard.getChessBoard()[x][y];
					gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).setCOLOR(null);
					gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).setPosX(-1);
					gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).setPosY(-1);
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
		boolean validMove = false;
		if (mergedPiece == null) {
			validMove = validMove(gameBoard, x, y);
		} else {
			if (mergedPiece.validMove(gameBoard, x, y) == true || this.validMove(gameBoard, x, y) == true) {
				validMove = true;
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

	@Override
	public boolean pieceMovement(GameBoardImpl gameBoard, int x, int y) {

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
