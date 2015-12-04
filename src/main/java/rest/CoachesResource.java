package rest;

import javax.ws.rs.Path;

import model.collections.CoachesCollection;

@Path("/coaches")
public class CoachesResource {

    private CoachesCollection coachesCollection = new CoachesCollection();
    
}
