package main;

import model.BasePlayer;
import model.GameEngineImpl;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("Hello, world!");

		BasePlayer p = new BasePlayer("30", "chessboi", 100);
		GameEngineImpl gameEngine = new GameEngineImpl();

		gameEngine.addPlayer(p);

		System.out.println(gameEngine.getAllPlayers().containsValue(p));

	}

}
