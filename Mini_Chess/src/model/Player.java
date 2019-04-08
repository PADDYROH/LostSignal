package model;

public interface Player {

	public abstract void login();

	public abstract void setName(String name);

	public abstract int getPoints();

	public abstract void setPoints(int points);

	public abstract String getID();
	
	public abstract String getName();

	public abstract int getPasswordHash();

}
