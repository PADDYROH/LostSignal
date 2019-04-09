package model;

import java.util.*;

import model.piece.Piece;
import model.utilities.PlayerManager;

import java.io.*;
import view.UserInterfaceManager;

public class GameEngineImpl implements GameEngine {

	// private static int MAX_PLAYERS = 2;
	Player player1;
	Player player2;
	PlayerManager playerManager;
	private List<UserInterfaceManager> userInterfaceManagers;
	private GameBoard mainBoard;
	int maxTurns;
	private Player currentPlayer;

	public GameEngineImpl() {
		playerManager = new PlayerManager("players.txt");
		userInterfaceManagers = new LinkedList<>();
		mainBoard = new GameBoardImpl();
	}

	// @Override
	// public void addPlayer(Player p) {
	// players.put(p.getID(), p);
	// }

	// @Override
	// public Player getPlayer(String id) {
	// return players.get(id);
	// }

	// @Override
	// public Map<String, Player> getAllPlayers() {
	// Map<String, Player> newMap = new HashMap<String, Player>();
	// for(String k : players.keySet()) {
	// newMap.put(k, players.get(k));
	// }
	// return newMap;
	// }

	// @Override
	// public boolean removePlayer(Player p) {
	// if(players.remove(p.getID()) == null) {
	// return false;
	// }
	// return true;
	//
	// }

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
		if (player1 != null) {
			if (player2.getID() != id) {
				if (password.hashCode() == player1.getPasswordHash()) {
					player1 = playerManager.getPlayer(id);
				}

			}
		} else if (player2 != null) {
			if (player1.getID() != id) {
				if (password.hashCode() == player2.getPasswordHash()) {
					player2 = playerManager.getPlayer(id);
				}
			}
		}
	}
}
