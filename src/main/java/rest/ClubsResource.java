package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Club;
import model.collections.ClubsCollection;

@Path("/clubs")
public class ClubsResource {

    private static ClubsCollection clubsCollection = new ClubsCollection();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClubs() {
        return Response.status(Response.Status.OK).entity(clubsCollection.getClubs()).build();
    }
    
    @Path("/{clubId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClub(@PathParam("clubId") String clubId) {
        if(clubsCollection.isClubExists(clubId)) {
            return Response.status(Response.Status.OK).entity(clubsCollection.getClub(clubId)).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("klub o podanym ID nie istnieje").build();
    }
    
    @Path("/{clubId}/players")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClubPlayers(@PathParam("clubId") String clubId) {
        if(clubsCollection.isClubExists(clubId)) {
            return Response.status(Response.Status.OK).entity(PlayersResource.getPlayersCollection().getPlayersByClub(clubId)).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("klub o podanym ID nie istnieje").build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postClub(Club club) {
        if(!clubsCollection.isClubExists(club.getId())) {
            clubsCollection.addClub(club);
            return Response.status(Response.Status.CREATED).entity(club).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("klub o podanym ID już istnieje").build();
    }
    
    @Path("/{clubId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putClub(@PathParam("clubId") String clubId, Club club) {
        if(clubsCollection.isClubExists(clubId)) {
            clubsCollection.modifyClub(clubId, club);
            return Response.status(Response.Status.CREATED).entity(club).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("klub o podanym ID nie istnieje").build();
    }
    
}
