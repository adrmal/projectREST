package rest;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import model.Player;
import model.collections.PlayersCollection;

@Path("/players")
@Api(value="/players")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayersResource {

	private static PlayersCollection playersCollection = new PlayersCollection();
	
	public static PlayersCollection getPlayersCollection() {
	    return playersCollection;
	}
	
	@GET
	@ApiOperation(value = "shows all list of players")
	@ApiResponses(value = @ApiResponse(code = 200, message = "found whole list of players"))
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlayers() {
		return Response.status(Response.Status.OK).entity(playersCollection.getPlayers()).build();
	}
	
	@Path("/{playerId}")
	@GET
	@ApiOperation(value = "shows player with given ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "player with given ID exists"),
			@ApiResponse(code = 404, message = "player with given ID doesn't exist")
	})
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlayer(@ApiParam(value = "ID of player", required = true) @PathParam("playerId") @NotBlank String playerId) {
		if(playersCollection.isPlayerExists(playerId)) {
			return Response.status(Response.Status.OK).entity(playersCollection.getPlayer(playerId)).build();
		}
		return Response.status(Response.Status.NOT_FOUND).entity("zawodnik o podanym ID nie istnieje").build();
	}
	
	@POST
	@ApiOperation(value = "adds player to list")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "player added to list"),
			@ApiResponse(code = 409, message = "player with given ID already exists, nothing has been done")
	})
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postPlayer(@ApiParam(value = "player") @Valid Player player) {
		if(!playersCollection.isPlayerExists(player.getId())) {
			playersCollection.addPlayer(player);
			return Response.status(Response.Status.CREATED).entity(player).build();
		}
		return Response.status(Response.Status.CONFLICT).entity("zawodnik o podanym ID już istnieje").build();
	}
	
	@Path("/{playerId}")
	@PUT
	@ApiOperation(value = "changes player with given ID")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "player changed"),
			@ApiResponse(code = 404, message = "player with given ID doesn't exist")
	})
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response putPlayer(@ApiParam(value = "ID of player", required = true) @PathParam("playerId") @NotBlank String playerId, @ApiParam(value = "player") @Valid Player player) {
		if(playersCollection.isPlayerExists(playerId)) {
			playersCollection.modifyPlayer(playerId, player);
			return Response.status(Response.Status.CREATED).entity(player).build();
		}
		return Response.status(Response.Status.NOT_FOUND).entity("zawodnik o podanym ID nie istnieje").build();
	}
	
	@Path("/{playerId}")
	@DELETE
	@ApiOperation(value = "deletes player with given ID from list")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "player deleted"),
			@ApiResponse(code = 404, message = "player with given ID doesn't exist")
	})
	public Response deletePlayer(@ApiParam(value = "ID of player", required = true) @PathParam("playerId") @NotBlank String playerId) {
		if(playersCollection.isPlayerExists(playerId)) {
			playersCollection.removePlayer(playerId);
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		return Response.status(Response.Status.NOT_FOUND).entity("zawodnik o podanym ID nie istnieje").build();
	}
	
}
