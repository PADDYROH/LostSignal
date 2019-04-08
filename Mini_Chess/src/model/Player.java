package model;

public interface Player {

	public abstract void login();

	
	public abstract void changeName();
	
	public abstract int getPoints();
	
	public abstract void setPoints();
	
	public abstract String getID();
}
