package model;

import java.util.*;
import java.io.*;
import view.UserInterfaceManager;

public class GameEngineImpl implements GameEngine {
	
	private static int MAX_PLAYERS = 2;
	private Map<String, Player> players;
	private List<UserInterfaceManager> userInterfaceManagers;
	private GameBoard mainBoard;
	int maxTurns;
	private Player currentPlayer;
	
	
	
	public GameEngineImpl() {
		players = new HashMap<String, Player>();
		userInterfaceManagers = new LinkedList<>();
		mainBoard = new GameBoardImpl();
	}
	
	@Override
	public void addPlayer(Player p) {
		if (players.size() < MAX_PLAYERS){
			players.put(p.getID(), p);
		} 
	}

	@Override
	public Player getPlayer(String id) {
		return players.get(id);
	}

	@Override
	public Map<String, Player> getAllPlayers() {
		Map<String, Player> newMap = new HashMap<String, Player>();
		for(String k : players.keySet()) {
			newMap.put(k, players.get(k));
		}
		return newMap;
	}

	@Override
	public boolean removePlayer(Player p) {
		if(players.remove(p.getID()) == null) {
			return false;
		}
		return true;
		
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
	public boolean movePiece() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player getCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setMaxTurns(int turns) {
		maxTurns = turns;
	}
	
}
