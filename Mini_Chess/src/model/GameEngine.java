package model;

import model.piece.Piece;
import model.utilities.PlayerManager;
import view.UserInterfaceManager;

public interface GameEngine {

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

	public abstract int getMaxTurns();

	public abstract Piece selectPiece(int xPos, int yPos);

	public abstract boolean checkMove(int xSource, int ySource, int xTarg, int yTarg);

	public abstract void logoutWhitePlayer();

	public abstract void logoutBlackPlayer();

	public abstract void swapPlayers();

	public abstract int getNumTurns();

}
