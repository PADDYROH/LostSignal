package model;

import java.util.Map;

import view.UserInterfaceManager;

public interface GameEngine {

	public void addPlayer(Player p);

	public Player getPlayer(String id);

	public Map<String, Player> getAllPlayers();

	public boolean removePlayer(Player p);

	public Player getCurrentPlayer();

	public void addUIManager(UserInterfaceManager manager);

	public void removeUIManager(UserInterfaceManager manager);

	public int calculatePlayerPoints();

	public GameBoard getGameBoard();

	public boolean movePiece();

	public void setMaxTurns(int turns);

}
