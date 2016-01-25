package model.collections;

import java.util.HashMap;
import java.util.Map;

import model.Club;

public class ClubsCollection {

	private Map<String, Club> clubsMap;
	
	public ClubsCollection() {
		clubsMap = new HashMap<>();
		
		addClub(new Club("4578f5e0-c37f-11e5-9912-ba0be0483c18", "Real", "Madryt", 1902, "5485d32e-c37e-11e5-9912-ba0be0483c18"));
		addClub(new Club("a63f7142-c37f-11e5-9912-ba0be0483c18", "Arsenal", "Londyn", 1886, "6221e4a8-c380-11e5-9912-ba0be0483c18"));
		addClub(new Club("acc97b70-c37f-11e5-9912-ba0be0483c18", "Manchester United", "Manchester", 1878, "445846b2-c37e-11e5-9912-ba0be0483c18"));
		addClub(new Club("b1b3e5f8-c37f-11e5-9912-ba0be0483c18", "Bayern", "Monachium", 1900));
		addClub(new Club("b748c966-c37f-11e5-9912-ba0be0483c18", "Lech", "Poznań", 1922));
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
