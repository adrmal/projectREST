package model.collections;

import java.util.HashMap;
import java.util.Map;

import model.Player;
import usable.Country;
import usable.Date;
import usable.Position;

public class PlayersCollection {

	private Map<String, Player> playersMap;
	
	public PlayersCollection() {
		playersMap = new HashMap<>();
		
		addPlayer(new Player("123", "Adrian", "Małolepszy", new Date(7, 11, 1994), Country.POLAND, 182, 60, Position.STRIKER));
		addPlayer(new Player("456", "Andrzej", "Kaczmarski", new Date(13, 10, 1994), Country.GERMANY, 190, 105, Position.DEFENDER));
	}
	
	public Map<String, Player> getPlayers() {
		return playersMap;
	}
	
	public Player getPlayer(String playerId) {
		return playersMap.get(playerId);
	}
	
	public void addPlayer(Player player) {
		playersMap.put(player.getId(), player);
	}
	
	public boolean isPlayerExists(String playerId) {
		if(playersMap.containsKey(playerId)) {
			return true;
		}
		return false;
	}
	
}
