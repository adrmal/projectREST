package model.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Player;
import usable.Country;
import usable.Date;
import usable.Position;

public class PlayersCollection {

	private Map<String, Player> playersMap;
	
	public PlayersCollection() {
		playersMap = new HashMap<>();
		
		addPlayer(new Player("123", "Adrian", "Małolepszy", new Date(7, 11, 1994), Country.POLAND, 182, 60, Position.STRIKER, "123", 10));
		addPlayer(new Player("456", "Andrzej", "Kaczmarski", new Date(13, 10, 1994), Country.GERMANY, 190, 105, Position.DEFENDER));
	}
	
	public Map<String, Player> getPlayers() {
		return playersMap;
	}
	
	public List<Player> getPlayersByClub(String club) {
	    List<Player> players = new ArrayList<>();
	    for(Map.Entry<String, Player> entry : playersMap.entrySet()) {
	        if(entry.getValue().getClub() != null) {
	            if(entry.getValue().getClub().equals(club)) {
	                players.add(entry.getValue());
	            }
	        }
	    }
        return players;
    }
	
	public Player getPlayer(String playerId) {
		return playersMap.get(playerId);
	}
	
	public void addPlayer(Player player) {
		playersMap.put(player.getId(), player);
	}
	
	public void modifyPlayer(String playerId, Player player) {
		playersMap.put(playerId, player);
	}
	
	public void removePlayer(String playerId) {
		playersMap.remove(playerId);
	}
	
	public boolean isPlayerExists(String playerId) {
		if(playersMap.containsKey(playerId)) {
			return true;
		}
		return false;
	}
	
}
