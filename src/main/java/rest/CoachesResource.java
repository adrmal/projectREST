package rest;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Coach;
import model.collections.CoachesCollection;

@Path("/coaches")
public class CoachesResource {

    private static CoachesCollection coachesCollection = new CoachesCollection();
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Coach> getCoaches() {
		return coachesCollection.getCoaches();
	}
    
}
