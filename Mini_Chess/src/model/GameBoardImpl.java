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
	private String[][] chessBoard = new String[6][6];
	private Map<String, Piece> pieces;

	public GameBoardImpl() {

		pieces = new HashMap<String, Piece>();
		initChessBoard();
		intialPieces();
	}

	public void initChessBoard() {

		chessBoard[0][0] = new String("r1");
		chessBoard[0][1] = new String("b1");
		chessBoard[0][2] = new String("K1");
		chessBoard[0][3] = new String("K2");
		chessBoard[0][4] = new String("b2");
		chessBoard[0][5] = new String("r2");

		chessBoard[5][0] = new String("r1w");
		chessBoard[5][1] = new String("b1w");
		chessBoard[5][2] = new String("K1w");
		chessBoard[5][3] = new String("K2w");
		chessBoard[5][4] = new String("b2w");
		chessBoard[5][5] = new String("r2w");

	}

	public void intialPieces() {

		pieces.put("r1", new Rook("black", 0, 0));
		pieces.put("b1", new Rook("black", 0, 1));
		pieces.put("K1", new Rook("black", 0, 2));
		pieces.put("K2", new Rook("black", 0, 3));
		pieces.put("b2", new Rook("black", 0, 4));
		pieces.put("r2", new Rook("black", 0, 5));
		pieces.put("r1w", new Rook("white", 5, 0));
		pieces.put("b1w", new Rook("white", 5, 1));
		pieces.put("K1w", new Rook("white", 5, 2));
		pieces.put("K2w", new Rook("white", 5, 3));
		pieces.put("b2w", new Rook("white", 5, 4));
		pieces.put("r2w", new Rook("white", 5, 5));

	}

	public Piece getPiece(int x, int y) {
		String id = this.chessBoard[x][y];
		return pieces.get(id);
	}

	public String[][] getChessBoard() {
		return chessBoard;
	}

	public Map<String, Piece> getPieces() {
		return pieces;
	}

	public void setPieces(Map<String, Piece> pieces) {
		this.pieces = pieces;
	}

	public boolean movePiece(String id, int x, int y) {

		if (pieces.get(id).checkMovement(this, 1, 0)) {
			return true;
		}
		return false;

	}
}
