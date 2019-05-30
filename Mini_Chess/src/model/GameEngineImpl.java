package model;

import java.util.*;

import model.piece.Piece;
import model.utilities.PlayerManager;

import view.UserInterfaceManager;

public class GameEngineImpl implements GameEngine {

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
			newPoints = MAX_POINTS - mainBoard.calculateNumberBlackPieces() * POINTS_PER_PIECE;
			whitePlayerPoints = newPoints;
		} else if (player.getID().equals(blackPlayer.getID())) {
			newPoints = MAX_POINTS - mainBoard.calculateNumberWhitePieces() * POINTS_PER_PIECE;
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
		Piece tempPiece = mainBoard.getPieces().get(pieceID);
		// check if player owns that piece
		if (checkMove(tempPiece.getPosX(), tempPiece.getPosY(), xCo, yCo)) {
			// try to move piece and update views
			if (!mainBoard.movePiece(pieceID, xCo, yCo)) {
				for (UserInterfaceManager uIM : userInterfaceManagers) {
					uIM.updateBoard(false);
				}
				return false;
			} else {
				// if move successful, check and update state
				numTurns++;
				calculatePlayerPoints(currentPlayer);
				// end game if one player has 0 pieces and update views
				// swap players otherwise
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
				// if maxTurns is reached, end game
				if (numTurns >= maxTurns) {
					endGame();
				} else {
					for (UserInterfaceManager uIM : userInterfaceManagers) {
						uIM.updateBoard(true);
					}
				}
				return true;
			}
		} else {
			// return false if move did not occur
			return false;
		}
	}

	@Override
	public void endGame() {
		// update views
		for (UserInterfaceManager uIM : userInterfaceManagers) {
			uIM.updateBoard(true);
			uIM.endGame();
		}
		// update player pPoints
		whitePlayer.setPoints(whitePlayer.getPoints() + whitePlayerPoints);
		blackPlayer.setPoints(blackPlayer.getPoints() + blackPlayerPoints);
		// save players to file
		playerManager.savePlayers();
		// reset game state
		currentPlayer = null;
		whitePlayer = null;
		blackPlayer = null;
		// update player views
		for (UserInterfaceManager uIM : userInterfaceManagers) {
			uIM.updateCurrentPlayers();
		}
		numTurns = 0;
		maxTurns = 0;
		// reset board
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
				// check if player already logged in
				if (blackPlayer != null) {
					if (!blackPlayer.getID().equals(id)) {
						// login if passwords match
						if (password.hashCode() == playerManager.getPlayer(id).getPasswordHash()) {
							whitePlayer = playerManager.getPlayer(id);
						}
					}
				} else {
					// login if passwords match
					if (password.hashCode() == playerManager.getPlayer(id).getPasswordHash()) {
						whitePlayer = playerManager.getPlayer(id);
					}
				}
				// repeat above for black player
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
		// white player starts first
		currentPlayer = whitePlayer;
		// update player views
		for (UserInterfaceManager uIM : userInterfaceManagers) {
			uIM.updateCurrentPlayers();
		}
		// update board views, true means no invalid move was made
		if (whitePlayer != null && blackPlayer != null) {
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

	// method returns a piece or null, at xPos or yPos
	@Override
	public Piece selectPiece(int xPos, int yPos) {
		Piece tempPiece = mainBoard.getPiece(xPos, yPos);
		// isSelectable is true if player color matches the piece color
		boolean isSelectable = false;
		if (tempPiece != null) {
			if (tempPiece.getColor().equals("white") && currentPlayer == whitePlayer) {
				isSelectable = true;
			} else if (tempPiece.getColor().equals("black") && currentPlayer == blackPlayer) {
				isSelectable = true;
			}
		}

		return isSelectable ? tempPiece : null;
	}

	// check move is valid for a piece and player matches piece color
	@Override
	public boolean checkMove(int xSource, int ySource, int xTarg, int yTarg) {
		Piece tempPiece = mainBoard.getPiece(xSource, ySource);
		boolean playerMatches = false;
		if (tempPiece.getColor().equals("white") && currentPlayer == whitePlayer) {
			playerMatches = true;
		} else if (tempPiece.getColor().equals("black") && currentPlayer == blackPlayer) {
			playerMatches = true;
		}

		return playerMatches && tempPiece.validMove(mainBoard, xTarg, yTarg);
	}

	@Override
	public void logoutWhitePlayer() {
		whitePlayer = blackPlayer;
		blackPlayer = null;
		for (UserInterfaceManager uIM : userInterfaceManagers) {
			uIM.updateCurrentPlayers();
		}

		for (UserInterfaceManager uIM : userInterfaceManagers) {
			uIM.updateBoard(true);

		}

	}

	@Override
	public void logoutBlackPlayer() {
		blackPlayer = null;
		for (UserInterfaceManager uIM : userInterfaceManagers) {
			uIM.updateCurrentPlayers();
		}

		for (UserInterfaceManager uIM : userInterfaceManagers) {
			uIM.updateBoard(true);

		}

	}

	@Override
	public void swapPlayers() {
		Player temp = whitePlayer;
		whitePlayer = blackPlayer;
		blackPlayer = temp;
		currentPlayer = whitePlayer;
		for (UserInterfaceManager uIM : userInterfaceManagers) {
			uIM.updateCurrentPlayers();
		}

		for (UserInterfaceManager uIM : userInterfaceManagers) {
			uIM.updateBoard(true);

		}
	}

	@Override
	public int getNumTurns() {
		return numTurns;
	}
}
