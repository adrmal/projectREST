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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import model.Club;
import model.collections.ClubsCollection;

@Path("/clubs")
@Api(value="/clubs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClubsResource {

    private static ClubsCollection clubsCollection = new ClubsCollection();
    
    @GET
    @ApiOperation(value = "shows all list of clubs")
	@ApiResponses(value = @ApiResponse(code = 200, message = "found whole list of clubs"))
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClubs() {
        return Response.status(Response.Status.OK).entity(clubsCollection.getClubs()).build();
    }
    
    @Path("/{clubId}")
    @GET
    @ApiOperation(value = "shows club with given ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "club with given ID exists"),
			@ApiResponse(code = 409, message = "club with given ID doesn't exist")
	})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClub(@ApiParam(value = "ID of club", required = true) @PathParam("clubId") String clubId) {
        if(clubsCollection.isClubExists(clubId)) {
            return Response.status(Response.Status.OK).entity(clubsCollection.getClub(clubId)).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("klub o podanym ID nie istnieje").build();
    }
    
    @Path("/{clubId}/players")
    @GET
    @ApiOperation(value = "shows players which are in club with given ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "club with given ID exists"),
			@ApiResponse(code = 409, message = "club with given ID doesn't exist")
	})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClubPlayers(@ApiParam(value = "ID of club", required = true) @PathParam("clubId") String clubId) {
        if(clubsCollection.isClubExists(clubId)) {
            return Response.status(Response.Status.OK).entity(PlayersResource.getPlayersCollection().getPlayersByClub(clubId)).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("klub o podanym ID nie istnieje").build();
    }
    
    @POST
    @ApiOperation(value = "adds club to list")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "club added to list"),
			@ApiResponse(code = 409, message = "club with given ID already exists, nothing has been done")
	})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postClub(@ApiParam(value = "club") Club club) {
        if(!clubsCollection.isClubExists(club.getId())) {
            clubsCollection.addClub(club);
            return Response.status(Response.Status.CREATED).entity(club).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("klub o podanym ID już istnieje").build();
    }
    
    @Path("/{clubId}")
    @PUT
    @ApiOperation(value = "changes club with given ID")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "club changed"),
			@ApiResponse(code = 409, message = "club with given ID doesn't exist")
	})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putClub(@ApiParam(value = "ID of club", required = true) @PathParam("clubId") String clubId, Club club) {
        if(clubsCollection.isClubExists(clubId)) {
            clubsCollection.modifyClub(clubId, club);
            return Response.status(Response.Status.CREATED).entity(club).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("klub o podanym ID nie istnieje").build();
    }
    
}
