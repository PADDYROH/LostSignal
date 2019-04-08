package model;


import java.util.*;
import java.io.*;

import view.UserInterfaceManager;

public class GameEngineImpl implements GameEngine {

	private Map<String, Player> players;
	private List<UserInterfaceManager> userInterfaceManagers;
	
	public GameEngineImpl() {
		players = new HashMap<String, Player>();
		userInterfaceManagers = new LinkedList<>();
	}
	
	@Override
	public void addPlayer() {
		// TODO Auto-generated method stub
		
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
		if(players.remove(p.getName()) == null) {
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
		return 0;
	}

	@Override
	public GameBoard getGameBoard() {
		// TODO Auto-generated method stub
		return null;
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

}
