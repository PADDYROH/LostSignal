package model;

import java.util.Map;

import model.piece.Piece;
import view.UserInterfaceManager;

public interface GameEngine {

	public abstract void addPlayer(Player p);

	public abstract Player getPlayer(String id);

	public abstract Map<String, Player> getAllPlayers();

	public abstract boolean removePlayer(Player p);

	public abstract Player getCurrentPlayer();

	public abstract void addUIManager(UserInterfaceManager manager);

	public abstract void removeUIManager(UserInterfaceManager manager);

	public abstract int calculatePlayerPoints();

	public abstract GameBoard getGameBoard();

	public abstract boolean movePiece(Piece piece, int xCo, int yCo);

	public abstract void setMaxTurns(int turns);

}
