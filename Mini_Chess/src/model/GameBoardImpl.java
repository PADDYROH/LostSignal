package model;

import model.piece.AbstractPiece;

public class GameBoardImpl implements GameBoard {

	private AbstractPiece[][] chessBoard = new AbstractPiece[6][6];

	public GameBoardImpl() {

		initChessBoard();

	}

	public void initChessBoard() {

		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard.length; j++) {
				chessBoard[i][j] = null;
			}
		}
	}

	public AbstractPiece AbstractPiece(int x, int y) {

		return chessBoard[x][y];

	}

}
