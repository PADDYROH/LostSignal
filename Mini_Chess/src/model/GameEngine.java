package model;

import java.util.Map;

import model.piece.Piece;
import model.utilities.PlayerManager;
import view.UserInterfaceManager;

public interface GameEngine {

	// public abstract void addPlayer(Player p);

	// public abstract Player getPlayer(String id);

	// public abstract Map<String, Player> getAllPlayers();

	// public abstract boolean removePlayer(Player p);

	public abstract Player getCurrentPlayer();

	public abstract void addUIManager(UserInterfaceManager manager);

	public abstract void removeUIManager(UserInterfaceManager manager);

	public abstract int calculatePlayerPoints(Player player);

	public abstract GameBoard getGameBoard();

	public abstract boolean movePiece(String pieceID, int xCo, int yCo);

	public abstract void setMaxTurns(int turns);

	public abstract PlayerManager getPlayerManager();

	public abstract void login(String id, String password);

	public abstract Player getWhitePlayer();

	public abstract Player getBlackPlayer();

	public abstract int getWhitePlayerPoints();

	public abstract int getBlackPlayerPoints();
	
	public abstract void endGame();

}
