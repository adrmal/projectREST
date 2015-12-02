package repositories;

import java.util.HashMap;
import java.util.Map;

import model.Club;

public class ClubsRepository {

	private Map<String, Club> clubsMap;
	
	public ClubsRepository() {
		clubsMap = new HashMap<>();
	}
	
	public Map<String, Club> getClubs() {
		return clubsMap;
	}
	
	public Club getClub(String clubId) {
		return clubsMap.get(clubId);
	}
	
	public void addClub(Club club) {
		clubsMap.put(club.getId(), club);
	}
	
	public boolean isClubExists(String clubId) {
		if(clubsMap.containsKey(clubId)) {
			return true;
		}
		return false;
	}
	
}
