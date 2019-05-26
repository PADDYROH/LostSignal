package model.piece;

import model.GameBoardImpl;

public class Bishop extends AbstractPiece {

	private String COLOR;

	private int posX;
	private int posY;
	private Piece mergedPiece;
	private String mergedID;

	public Bishop(String COLOR, int posX, int posY) {
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
				if (!sameTeam(gameBoard, x, y)) {

					gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).setCOLOR(null);
					gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).setPosX(-1);
					gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).setPosY(-1);

				} else {
					// check that piece on same team isn't of same type
					if ((gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y])).getClass()
							.equals(this.getClass())) {
						return false;
					}
					if (gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).getMergedPiece() != null) {
						return false;
					}
					if (this.mergedPiece != null) {
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
			if (gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]) != null) {
				if ((gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y])).getClass().equals(this.getClass())) {
					return false;
				}
			}

			validMove = pieceMovement(gameBoard, x, y);
		} else {
			if (gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]) != null) {
				if ((gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y])).getClass().equals(this.getClass())
						&& (gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y])).getColor() == this.COLOR) {
					return false;
				}
				if (gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]).getColor() == this.getColor()) {

					return false;
				}
			}
			if (mergedPiece.pieceMovement(gameBoard, x, y) == true || this.pieceMovement(gameBoard, x, y) == true) {

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

	public Piece getMergedPiece() {
		return mergedPiece;
	}

}
