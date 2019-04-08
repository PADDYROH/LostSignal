package model.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import model.BasePlayer;
import model.Player;

public class PlayerManager {
	String registryFile = "players.txt";
	
	
	public void savePlayers(Map<String, Player> players) {
		try {
			FileWriter fw = new FileWriter(registryFile, false);
			for(Player p : players.values()) {
				fw.write(p.getID() + "," + p.getName() + "," + p.getPoints() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Map<String, Player> loadPlayers() {
		Map<String, Player> playerMap = new HashMap<String, Player>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(registryFile));
			String line;
			while((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				String tempID = st.nextToken(",");
				String tempName = st.nextToken(",");
				int tempPoints = Integer.parseInt(st.nextToken(","));
				playerMap.put(tempID, new BasePlayer(tempID, tempName, tempPoints));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return playerMap;
	}
	
//	public boolean verify(Player p, password) {
//		return false;
//	}
	
}
