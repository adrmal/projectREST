package model.collections;

import java.util.HashMap;
import java.util.Map;

import model.Club;

public class ClubsCollection {

	private Map<String, Club> clubsMap;
	
	public ClubsCollection() {
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
	
	public void modifyClub(String clubId, Club club) {
		clubsMap.put(clubId, club);
	}
	
	public void removeClub(String clubId) {
		clubsMap.remove(clubId);
	}
	
	public boolean isClubExists(String clubId) {
		if(clubsMap.containsKey(clubId)) {
			return true;
		}
		return false;
	}
	
}
