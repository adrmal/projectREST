package rest;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Club;
import model.collections.ClubsCollection;

@Path("/clubs")
public class ClubsResource {

    private ClubsCollection clubsCollection = new ClubsCollection();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Club> getClubs() {
        return clubsCollection.getClubs();
    }
    
}