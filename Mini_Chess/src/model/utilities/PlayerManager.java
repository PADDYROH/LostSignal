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
	String registryFile;
	private Map<String, Player> players;

	public PlayerManager(String registryFile) {
		this.registryFile = registryFile;
		players = new HashMap<String, Player>();
		loadPlayers();
	}

	// save players to file
	public void savePlayers() {
		try {
			FileWriter fw = new FileWriter(registryFile, false);
			for (Player p : players.values()) {
				fw.write(p.getID() + "," + p.getPasswordHash() + "," + p.getName() + "," + p.getPoints() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// load players from file into HashMap
	public void loadPlayers() {
		players = new HashMap<String, Player>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(registryFile));
			String line;
			while ((line = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				String tempID = st.nextToken(",");
				int tempPass = Integer.parseInt(st.nextToken(","));
				String tempName = st.nextToken(",");
				int tempPoints = Integer.parseInt(st.nextToken(","));
				players.put(tempID, new BasePlayer(tempID, tempPass, tempName, tempPoints));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// get Player from HashMap
	public Player getPlayer(String id) {
		return players.get(id);
	}

	// add Player, throw exception if ID in system already
	public void addPlayer(Player p) throws IllegalArgumentException {
		if (players.get(p.getID()) == null) {
			players.put(p.getID(), p);
			savePlayers();
		} else {
			throw new IllegalArgumentException("player ID already exists!");
		}
	}

	public Map<String, Player> getAllPlayers() {
		Map<String, Player> newMap = new HashMap<String, Player>();
		for (String k : players.keySet()) {
			newMap.put(k, players.get(k));
		}
		return newMap;
	}

	public boolean removePlayer(String id) {
		if (players.remove(id) != null) {
			return false;
		}
		return true;

	}

}
