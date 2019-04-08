package model;

public class BasePlayer implements Player {

	private String playerID;
	private String playerName;
	private int playerPoints;
	private String playerPassword;

	public BasePlayer(String playerID, String playerName, int playerPoints) {

		this.playerID = playerID;
		this.playerPoints = playerPoints;
		this.playerName = playerName;

	}

	@Override
	public void login() {
		// TODO Auto-generated method stub

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

}
