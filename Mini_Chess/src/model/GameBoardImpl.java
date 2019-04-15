package model;

import java.util.HashMap;
import java.util.Map;
import model.piece.AbstractPiece;
import model.piece.Bishop;
import model.piece.Knight;
import model.piece.Piece;
import model.piece.Rook;

public class GameBoardImpl implements GameBoard {
	private static int NUMBER_OF_PIECES = 6;

	private String[][] chessBoard = new String[NUMBER_OF_PIECES][NUMBER_OF_PIECES];
	private Map<String, Piece> pieces;

	public GameBoardImpl() {

		pieces = new HashMap<String, Piece>();
		initChessBoard();
		intialPieces();
	}

	public void initChessBoard() {

		chessBoard[0][0] = new String("r1");
		chessBoard[1][0] = new String("b1");
		chessBoard[2][0] = new String("K1");
		chessBoard[3][0] = new String("K2");
		chessBoard[4][0] = new String("b2");
		chessBoard[5][0] = new String("r2");

		chessBoard[0][5] = new String("r1w");
		chessBoard[1][5] = new String("b1w");
		chessBoard[2][5] = new String("K1w");
		chessBoard[3][5] = new String("K2w");
		chessBoard[4][5] = new String("b2w");
		chessBoard[5][5] = new String("r2w");

	}

	public void intialPieces() {

		pieces.put("r1", new Rook("black", 0, 0));
		pieces.put("b1", new Bishop("black", 1, 0));
		pieces.put("K1", new Knight("black", 2, 0));
		pieces.put("K2", new Knight("black", 3, 0));
		pieces.put("b2", new Bishop("black", 4, 0));
		pieces.put("r2", new Rook("black", 5, 0));
		pieces.put("r1w", new Rook("white", 0, 5));
		pieces.put("b1w", new Bishop("white", 1, 5));
		pieces.put("K1w", new Knight("white", 2, 5));
		pieces.put("K2w", new Knight("white", 3, 5));
		pieces.put("b2w", new Bishop("white", 4, 5));
		pieces.put("r2w", new Rook("white", 5, 5));

	}

	public Piece getPiece(int x, int y) {
		String id = this.chessBoard[x][y];
		return pieces.get(id);
	}

	public int calculateNumberWhitePieces() {

		int whitePieces = 0;
		for (Piece value : pieces.values()) {
			if (value.getColor() == "white") {
				whitePieces++;
			}
		}

		return whitePieces;
	}

	public int calculateNumberBlackPieces() {
		int whitePieces = 0;
		for (Piece value : pieces.values()) {
			if (value.getColor() == "black") {
				whitePieces++;
			}
		}

		return whitePieces;
	}

	public String[][] getChessBoard() {
		return chessBoard;
	}

	public Map<String, Piece> getPieces() {
		return pieces;
	}

	public String getByID(String id) {

		return pieces.get(id).toString();

	}

	public void setPieces(Map<String, Piece> pieces) {
		this.pieces = pieces;
	}

	public boolean movePiece(String id, int x, int y) {

		if (pieces.get(id).checkMovement(this, x, y)) {

			// move the piece
			this.chessBoard[x][y] = chessBoard[pieces.get(id).getPosX()][pieces.get(id).getPosY()];

			// set starting pos to null
			this.chessBoard[pieces.get(id).getPosX()][pieces.get(id).getPosY()] = null;

			// update x and y in pieces map
			pieces.get(id).setPosX(x);
			pieces.get(id).setPosY(y);

			return true;

		}
		return false;

	}
}
