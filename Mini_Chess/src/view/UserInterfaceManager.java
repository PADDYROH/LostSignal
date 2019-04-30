package view;

public interface UserInterfaceManager {
	// print out the board
	public abstract void updateBoard(boolean successfulMove);
	// print out whitePlayer and blackPayer, with ID, name,
	public abstract void updateCurrentPlayers();
	// print out the final player scores and who won
	public abstract void endGame();
}
