package model;

public class BasePlayer implements Player {

	private String playerID;
	private String playerName;
	private int playerPoints;
	private int playerPasswordHash;

	public BasePlayer(String playerID, int playerPasswordHash, String playerName, int playerPoints) {

		this.playerID = playerID;
		this.playerPasswordHash = playerPasswordHash;
		this.playerPoints = playerPoints;
		this.playerName = playerName;
	}

	@Override
	public void setName(String name) {

		this.playerName = name;
	}

	@Override
	public int getPoints() {

		return this.playerPoints;
	}

	@Override
	public void setPoints(int points) {

		this.playerPoints = points;

	}

	@Override
	public String getID() {

		return this.playerID;
	}

	@Override
	public String getName() {
		return playerName;
	}

	@Override
	public int getPasswordHash() {
		return playerPasswordHash;
	}

	@Override
	public String toString() {
		String retVal = "";
		retVal = String.format("ID: %s\nName: %s\nAll-Time Points:%s\n", playerID, playerName, playerPoints);
		return retVal;
	}

}
