package model.collections;

import java.util.HashMap;
import java.util.Map;

import model.Coach;

public class CoachesCollection {

	private Map<String, Coach> coachesMap;
	
	public CoachesCollection() {
		coachesMap = new HashMap<>();
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
