package model;

import java.util.*;

import model.piece.Piece;
import model.utilities.PlayerManager;

import java.io.*;
import view.UserInterfaceManager;

public class GameEngineImpl implements GameEngine {

	// private static int MAX_PLAYERS = 2;
	private static int BOARD_ROWS = 6;
	private static int BOARD_COLS = 6;
	private Player whitePlayer;
	private Player blackPlayer;
	private int whitePlayerPoints;
	private int blackPlayerPoints;
	private PlayerManager playerManager;
	private List<UserInterfaceManager> userInterfaceManagers;
	private GameBoardImpl mainBoard;
	private int maxTurns;
	private int numTurns;
	private Player currentPlayer;

	public GameEngineImpl() {
		playerManager = new PlayerManager("players.txt");
		userInterfaceManagers = new LinkedList<>();
		mainBoard = new GameBoardImpl();
		whitePlayer = null;
		blackPlayer = null;
		whitePlayerPoints = 0;
		blackPlayerPoints = 0;
		numTurns = 0;
	}

	@Override
	public void addUIManager(UserInterfaceManager manager) {

		userInterfaceManagers.add(manager);
	}

	@Override
	public void removeUIManager(UserInterfaceManager manager) {

		userInterfaceManagers.remove(manager);
	}

	@Override
	public int calculatePlayerPoints(Player player) {
		int newPoints = 0;
		if (player.getID().equals(whitePlayer.getID())) {
			for (int y = 0; y < BOARD_ROWS; y++) {
				for (int x = 0; x < BOARD_COLS; x++) {
					if (mainBoard.getPiece(x, y).getColor().equals("black")) {
						newPoints += 5;
					}
				}
			}
			whitePlayerPoints = newPoints;
		} else if (player.getID().equals(blackPlayer.getID())) {
			for (int y = 0; y < BOARD_ROWS; y++) {
				for (int x = 0; x < BOARD_COLS; x++) {
					if (mainBoard.getPiece(x, y).getColor().equals("white")) {
						newPoints += 5;
					}
				}
			}
			blackPlayerPoints = newPoints;
		}
		return newPoints;
	}

	@Override
	public GameBoard getGameBoard() {
		return mainBoard;
	}

	@Override
	public boolean movePiece(String pieceID, int xCo, int yCo) {
		// check piece belongs to current player
		String pieceColor = mainBoard.getPieces().get(pieceID).getColor();
		if ((pieceColor.equals("Black") && currentPlayer == blackPlayer)
				|| (pieceColor.equals("White") && currentPlayer == whitePlayer)) {
			// try to move piece
			if (!mainBoard.movePiece(pieceID, xCo, yCo)) {
				return false;
			} else {
				numTurns++;
				calculatePlayerPoints(currentPlayer);
				if (currentPlayer == whitePlayer) {
					if (mainBoard.getNumberBlackPieces() == 0) {
						endGame();
						return true;
					}
					currentPlayer = blackPlayer;
				} else if (currentPlayer == blackPlayer) {
					if (mainBoard.getNumberWhitePieces() == 0) {
						endGame();
						return true;
					}
					currentPlayer = whitePlayer;
				}

				// update player points *
				// change currentPlayer *
				// check if game over
				numTurns++;
				if (numTurns >= maxTurns) {
					endGame();
				}
				// call ui manager methods
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public void endGame() {
		// call ui manager methods
		// reset all game state
	}

	@Override
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	@Override
	public void setMaxTurns(int turns) {
		maxTurns = turns;
	}

	@Override
	public PlayerManager getPlayerManager() {
		return playerManager;
	}

	@Override
	public void login(String id, String password) {
		if (playerManager.getPlayer(id) != null) {
			if (whitePlayer == null) {
				if (blackPlayer != null) {
					if (blackPlayer.getID() != id) {
						if (password.hashCode() == playerManager.getPlayer(id).getPasswordHash()) {
							whitePlayer = playerManager.getPlayer(id);
						}
					}
				} else {
					if (password.hashCode() == playerManager.getPlayer(id).getPasswordHash()) {
						whitePlayer = playerManager.getPlayer(id);
					}
				}
			} else if (blackPlayer == null) {
				if (whitePlayer != null) {
					if (whitePlayer.getID() != id) {
						if (password.hashCode() == playerManager.getPlayer(id).getPasswordHash()) {
							blackPlayer = playerManager.getPlayer(id);
						}
					}
				} else {
					if (password.hashCode() == playerManager.getPlayer(id).getPasswordHash()) {
						blackPlayer = playerManager.getPlayer(id);
					}
				}
			}
		}
		// call ui manager method
	}

	@Override
	public Player getWhitePlayer() {
		return whitePlayer;
	}

	@Override
	public Player getBlackPlayer() {
		return blackPlayer;
	}

	@Override
	public int getWhitePlayerPoints() {
		return whitePlayerPoints;
	}

	@Override
	public int getBlackPlayerPoints() {
		return blackPlayerPoints;
	}
}
