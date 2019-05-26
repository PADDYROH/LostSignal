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
	private static int POINTS_PER_PIECE = 5;
	private static int MAX_POINTS = 30;
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
			newPoints = 30 - mainBoard.calculateNumberBlackPieces() * 5;
			whitePlayerPoints = newPoints;
		} else if (player.getID().equals(blackPlayer.getID())) {
			newPoints = 30 - mainBoard.calculateNumberWhitePieces() * 5;
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
		// change to checkMove()
		if ((pieceColor.equals("black") && currentPlayer.getID().equals(blackPlayer.getID()))
				|| (pieceColor.equals("white") && currentPlayer.getID().equals(whitePlayer.getID()))) {
			// try to move piece
			if (!mainBoard.movePiece(pieceID, xCo, yCo)) {
				for (UserInterfaceManager uIM : userInterfaceManagers) {
					uIM.updateBoard(false);
				}
				return false;
			} else {
				numTurns++;
				calculatePlayerPoints(currentPlayer);
				if (currentPlayer.getID().equals(whitePlayer.getID())) {
					if (mainBoard.calculateNumberBlackPieces() == 0) {
						endGame();
						return true;
					}
					currentPlayer = blackPlayer;
				} else if (currentPlayer.getID().equals(blackPlayer.getID())) {
					if (mainBoard.calculateNumberWhitePieces() == 0) {
						endGame();
						return true;
					}
					currentPlayer = whitePlayer;
				}

				// update player points *
				// change currentPlayer *
				// check if game over *

				if (numTurns >= maxTurns) {
					endGame();
				}
				for (UserInterfaceManager uIM : userInterfaceManagers) {
					uIM.updateBoard(true);
				}
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public void endGame() {
		//calculatePlayerPoints(currentPlayer);
		for (UserInterfaceManager uIM : userInterfaceManagers) {
			uIM.updateBoard(true);
			uIM.endGame();
		}
		whitePlayer.setPoints(whitePlayer.getPoints() + whitePlayerPoints);
		blackPlayer.setPoints(blackPlayer.getPoints() + blackPlayerPoints);
		playerManager.savePlayers();
		currentPlayer = null;
		whitePlayer = null;
		blackPlayer = null;
		numTurns = 0;
		maxTurns = 0;
		mainBoard = new GameBoardImpl();
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
					if (!blackPlayer.getID().equals(id)) {
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
					if (!whitePlayer.getID().equals(id)) {
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
		currentPlayer = whitePlayer;
		for (UserInterfaceManager uIM : userInterfaceManagers) {
			uIM.updateCurrentPlayers();
		}
		if(whitePlayer != null && blackPlayer != null) {
			for (UserInterfaceManager uIM : userInterfaceManagers) {
				uIM.updateBoard(true);
			}
		}
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
	
	@Override
	public int getMaxTurns() {
		return maxTurns;
	}
	
	@Override
	public Piece selectPiece(int xPos, int yPos, boolean ignoreColour) {
		Piece tempPiece = mainBoard.getPiece(xPos, yPos);
		boolean isSelectable = false;
		if(tempPiece != null) {
			if(tempPiece.getColor().equals("white") && currentPlayer == whitePlayer) {
				isSelectable = true;
			} else if (tempPiece.getColor().equals("black") && currentPlayer == blackPlayer) {
				isSelectable = true;
			}
		}
		if(ignoreColour) {
			isSelectable = true;
		}
		
		return isSelectable ? tempPiece : null;
	}
	
	@Override
	public boolean checkMove(int xSource, int ySource, int xTarg, int yTarg) {
		Piece tempPiece = mainBoard.getPiece(xSource, ySource);
		boolean playerMatches = false;
		if(tempPiece.getColor().equals("white") && currentPlayer == whitePlayer) {
			playerMatches = true;
		} else if (tempPiece.getColor().equals("black") && currentPlayer == blackPlayer) {
			playerMatches = true;
		}
		
		return playerMatches && tempPiece.validMove(mainBoard, xTarg, yTarg);
	}
}
