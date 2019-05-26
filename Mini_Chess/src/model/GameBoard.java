package model;

import java.util.Map;

import model.piece.Piece;

public interface GameBoard {

	public Piece getPiece(int x, int y);

	public String[][] getChessBoard();

	public Map<String, Piece> getPieces();

	public void setPieces(Map<String, Piece> pieces);

	public boolean movePiece(String id, int x, int y);

	public int calculateNumberBlackPieces();

	public int calculateNumberWhitePieces();

}
