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
		
		addPlayer(new Player("84dd8f38-c380-11e5-9912-ba0be0483c18", "Adrian", "Małolepszy", new Date(7, 11, 1994), Country.POLAND, 182, 60, Position.STRIKER, "4578f5e0-c37f-11e5-9912-ba0be0483c18", 10));
		addPlayer(new Player("981f4e42-c380-11e5-9912-ba0be0483c18", "Andrzej", "Kaczmarski", new Date(13, 10, 1994), Country.GERMANY, 190, 105, Position.DEFENDER));
		addPlayer(new Player("089346b0-c381-11e5-9912-ba0be0483c18", "Cristiano", "Ronaldo", new Date(5, 2, 1985), Country.PORTUGAL, 185, 84, Position.STRIKER, "4578f5e0-c37f-11e5-9912-ba0be0483c18", 7));
		addPlayer(new Player("a976331c-c381-11e5-9912-ba0be0483c18", "Karim", "Benzema", new Date(19, 12, 1987), Country.FRANCE, 187, 79, Position.STRIKER, "4578f5e0-c37f-11e5-9912-ba0be0483c18", 9));
		addPlayer(new Player("7ae87f2e-c385-11e5-9912-ba0be0483c18", "Sergio", "Ramos", new Date(30, 3, 1986), Country.SPAIN, 183, 75, Position.DEFENDER, "4578f5e0-c37f-11e5-9912-ba0be0483c18", 4));
		addPlayer(new Player("0213e594-c389-11e5-9912-ba0be0483c18", "Mesut", "Ozil", new Date(15, 10, 1988), Country.GERMANY, 183, 76, Position.MIDFIELDER, "a63f7142-c37f-11e5-9912-ba0be0483c18", 11));
		addPlayer(new Player("416989b0-c389-11e5-9912-ba0be0483c18", "Theo", "Walcott", new Date(16, 3, 1989), Country.ENGLAND, 176, 68, Position.STRIKER, "a63f7142-c37f-11e5-9912-ba0be0483c18", 14));
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
