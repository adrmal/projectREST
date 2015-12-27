package rest;

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

import model.Player;
import model.collections.PlayersCollection;

@Path("/players")
public class PlayersResource {

	private static PlayersCollection playersCollection = new PlayersCollection();
	
	public static PlayersCollection getPlayersCollection() {
	    return playersCollection;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlayers() {
		return Response.status(Response.Status.OK).entity(playersCollection.getPlayers()).build();
	}
	
	@Path("/{playerId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlayer(@PathParam("playerId") String playerId) {
		if(playersCollection.isPlayerExists(playerId)) {
			return Response.status(Response.Status.OK).entity(playersCollection.getPlayer(playerId)).build();
		}
		return Response.status(Response.Status.CONFLICT).entity("zawodnik o podanym ID nie istnieje").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postPlayer(Player player) {
		if(!playersCollection.isPlayerExists(player.getId())) {
			playersCollection.addPlayer(player);
			return Response.status(Response.Status.CREATED).entity(player).build();
		}
		return Response.status(Response.Status.CONFLICT).entity("zawodnik o podanym ID już istnieje").build();
	}
	
	@Path("/{playerId}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response putPlayer(@PathParam("playerId") String playerId, Player player) {
		if(playersCollection.isPlayerExists(playerId)) {
			playersCollection.modifyPlayer(playerId, player);
			return Response.status(Response.Status.CREATED).entity(player).build();
		}
		return Response.status(Response.Status.CONFLICT).entity("zawodnik o podanym ID nie istnieje").build();
	}
	
	@Path("/{playerId}")
	@DELETE
	public Response deletePlayer(@PathParam("playerId") String playerId) {
		if(playersCollection.isPlayerExists(playerId)) {
			playersCollection.removePlayer(playerId);
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		return Response.status(Response.Status.CONFLICT).entity("zawodnik o podanym ID nie istnieje").build();
	}
	
}
