package model;

import java.util.*;

import model.piece.Piece;
import model.utilities.PlayerManager;

import java.io.*;
import view.UserInterfaceManager;

public class GameEngineImpl implements GameEngine {

	// private static int MAX_PLAYERS = 2;
	private Player player1;
	private Player player2;
	private PlayerManager playerManager;
	private List<UserInterfaceManager> userInterfaceManagers;
	private GameBoard mainBoard;
	int maxTurns;
	private Player currentPlayer;

	public GameEngineImpl() {
		playerManager = new PlayerManager("players.txt");
		userInterfaceManagers = new LinkedList<>();
		mainBoard = new GameBoardImpl();
		player1 = null;
		player2 = null;
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
	public int calculatePlayerPoints() {
		// TODO Auto-generated method stub
		// Loop through pieces of opposite player?
		return 0;
	}

	@Override
	public GameBoard getGameBoard() {
		return mainBoard;
	}

	@Override
	public boolean movePiece(Piece piece, int xCo, int yCo) {
		// TODO Auto-generated method stub
		return false;
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
			if (player1 == null) {
				if (player2 != null) {
					if (player2.getID() != id) {
						if (password.hashCode() == playerManager.getPlayer(id).getPasswordHash()) {
							player1 = playerManager.getPlayer(id);
						}
					}
				} else {
					if (password.hashCode() == playerManager.getPlayer(id).getPasswordHash()) {
						player1 = playerManager.getPlayer(id);
					}
				}
			} else if (player2 == null) {
				if (player1 != null) {
					if (player1.getID() != id) {
						if (password.hashCode() == playerManager.getPlayer(id).getPasswordHash()) {
							player2 = playerManager.getPlayer(id);
						}
					}
				} else {
					if (password.hashCode() == playerManager.getPlayer(id).getPasswordHash()) {
						player2 = playerManager.getPlayer(id);
					}
				}
			}
		}

	}

	@Override
	public Player getPlayer1() {
		return player1;
	}

	@Override
	public Player getPlayer2() {
		return player2;
	}
}
