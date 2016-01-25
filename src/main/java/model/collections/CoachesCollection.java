package model.collections;

import java.util.HashMap;
import java.util.Map;

import model.Coach;
import usable.Country;
import usable.Date;

public class CoachesCollection {

	private Map<String, Coach> coachesMap;
	
	public CoachesCollection() {
		coachesMap = new HashMap<>();
		
		addCoach(new Coach("33962556-c37e-11e5-9912-ba0be0483c18", "Jose", "Mourinho", new Date(26, 1, 1963), Country.PORTUGAL));
		addCoach(new Coach("445846b2-c37e-11e5-9912-ba0be0483c18", "Louis", "van Gaal", new Date(8, 8, 1951), Country.NETHERLANDS));
		addCoach(new Coach("4b3d718c-c37e-11e5-9912-ba0be0483c18", "Carlo", "Ancelotti", new Date(10, 6, 1959), Country.ITALY));
        addCoach(new Coach("5036c328-c37e-11e5-9912-ba0be0483c18", "Alex", "Ferguson", new Date(31, 12, 1941), Country.SCOTLAND));
        addCoach(new Coach("5485d32e-c37e-11e5-9912-ba0be0483c18", "Rafael", "Benitez", new Date(16, 4, 1960), Country.SPAIN));
        addCoach(new Coach("58c84cbe-c37e-11e5-9912-ba0be0483c18", "Adam", "Nawałka", new Date(23, 10, 1957), Country.POLAND));
        addCoach(new Coach("6221e4a8-c380-11e5-9912-ba0be0483c18", "Arsene", "Wenger", new Date(22, 10, 1949), Country.FRANCE));
	}
	
	public Map<String, Coach> getCoaches() {
		return coachesMap;
	}
	
	public Coach getCoach(String coachId) {
		return coachesMap.get(coachId);
	}
	
	public void addCoach(Coach coach) {
		coachesMap.put(coach.getId(), coach);
	}
	
	public void modifyCoach(String coachId, Coach coach) {
		coachesMap.put(coachId, coach);
	}
	
	public void removeCoach(String coachId) {
		coachesMap.remove(coachId);
	}
	
	public boolean isCoachExists(String coachId) {
		if(coachesMap.containsKey(coachId)) {
			return true;
		}
		return false;
	}
	
}
