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
	private AbstractPiece[][] chessBoard = new AbstractPiece[6][6];
	private Map<String, AbstractPiece> pieces;

	public GameBoardImpl() {

		pieces = new HashMap<String, AbstractPiece>();
		initChessBoard();
		intialPieces();
	}

	public void addPiece(AbstractPiece piece, GameBoardImpl gameBoard) {
		pieces.put(piece.getPieceId(), piece);
	}

	public void initChessBoard() {

		chessBoard[0][0] = new Rook("r1", "black", 0, 0);
		chessBoard[0][1] = new Bishop("b1", "black", 0, 1);
		chessBoard[0][2] = new Knight("K1", "black", 0, 2);
		chessBoard[0][3] = new Knight("K2", "black", 0, 3);
		chessBoard[0][4] = new Bishop("b2", "black", 0, 4);
		chessBoard[0][5] = new Rook("r2", "black", 0, 5);

		chessBoard[5][0] = new Rook("r1w", "black", 0, 0);
		chessBoard[5][1] = new Bishop("b1w", "black", 0, 1);
		chessBoard[5][2] = new Knight("K1w", "black", 0, 2);
		chessBoard[5][3] = new Knight("K2w", "black", 0, 3);
		chessBoard[5][4] = new Bishop("b2w", "black", 0, 4);
		chessBoard[5][5] = new Rook("r2w", "black", 0, 5);

	}

	public AbstractPiece getPiece(int x, int y) {

		return chessBoard[x][y];

	}

	public void intialPieces() {
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard.length; j++) {
				if (chessBoard[i][j] != null) {
					pieces.put(chessBoard[i][j].getPieceId(), chessBoard[i][j]);
				}
			}
		}
	}

	public AbstractPiece[][] getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(AbstractPiece[][] chessBoard) {
		this.chessBoard = chessBoard;
	}

	public Map<String, AbstractPiece> getPieces() {
		return pieces;
	}

	public void setPieces(Map<String, AbstractPiece> pieces) {
		this.pieces = pieces;
	}
}
