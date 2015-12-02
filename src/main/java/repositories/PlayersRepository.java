package repositories;

import java.util.HashMap;
import java.util.Map;

import model.Player;
import usable.Country;
import usable.Date;
import usable.Position;

public class PlayersRepository {

	private Map<String, Player> playersMap;
	
	public PlayersRepository() {
		playersMap = new HashMap<>();
		
		addPlayer(new Player("123", "Adrian", "Małolepszy", new Date(7, 11, 1994), Country.POLAND, 182, 60, Position.STRIKER));
		
		System.out.println();
		System.out.println();
		System.out.println(playersMap);
		System.out.println();
		System.out.println();
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
