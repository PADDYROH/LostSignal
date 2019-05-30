package model.piece;

import model.GameBoard;
import model.GameBoardImpl;

public abstract class Piece {

	// define the movement lengths of a pieces
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
		// splitting pieces must set the inner piece color
		gameBoard.getPieces().get(mergedID).setCOLOR(getColor());
		// must be set to null so a piece can merge again
		this.mergedPiece = null;
		return true;
	}

	public boolean checkMovement(GameBoard gameBoard, int x, int y) {
		// keeps x and y with in bounds of the game board
		if (!inBoardLimits(x, y)) {
			return false;
		}
		if (validMove(gameBoard, x, y)) {

			if (gameBoard.getChessBoard()[x][y] != null) {
				Piece piece = gameBoard.getPieces().get(gameBoard.getChessBoard()[x][y]);

				if (!sameTeam(gameBoard, x, y)) {
					// set color to null to indicate that it has been removed from the game this is
					// needed for end game checks and points
					piece.setCOLOR(null);
					// set to -1 this way it will not be in the game board
					piece.setPosX(-1);
					piece.setPosY(-1);

				} else {
					// check that piece on same team isn't of same type this would be a pointless
					// merge
					if (piece.getClass().equals(this.getClass()) && piece.getColor().equals(this.getColor())) {
						return false;
					}
					// check if the piece has already been merged
					if (piece.getMergedPiece() != null) {
						return false;
					}
					if (this.mergedPiece != null) {
						return false;
					} else {
						// merge a piece
						// NOTE: the merged pieces color must be null this is to keep continuity with
						// the number of pieces in the game
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
				// check that a piece isn't on the same team
				if (piece.getColor() == this.getColor()) {
					return false;
				}
			}
			// check movement of a merged piece
			// NOTE: both pieces, pieceMovement method is called here
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
		// used to debug
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
		// NOTE: piece will Override for individual movement logic
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
