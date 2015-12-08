package rest;

import java.util.Map;

import javax.ws.rs.Consumes;
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

	private PlayersCollection playersCollection = new PlayersCollection();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Player> getPlayers() {
		return playersCollection.getPlayers();
	}
	
	@Path("/{playerId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlayer(@PathParam("playerId") String playerId) throws Exception {
		if(playersCollection.isPlayerExists(playerId)) {
			return Response.status(Response.Status.OK).entity(playersCollection.getPlayer(playerId)).build();
		}
		return Response.status(Response.Status.CONFLICT).entity("użytkownik o podanym ID nie istnieje").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postPlayer(Player player) {
		if(!playersCollection.isPlayerExists(player.getId())) {
			playersCollection.addPlayer(player);
			return Response.status(Response.Status.CREATED).entity(player.getId()).build();
		}
		return Response.status(Response.Status.CONFLICT).entity("użytkownik o podanym ID już istnieje").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response putPlayerFirstName(String playerId, String playerFirstName) {
		if(playersCollection.isPlayerExists(playerId)) {
			// TODO modyfikacja imienia
			return Response.status(Response.Status.CREATED).entity(playerId).build();
		}
		return Response.status(Response.Status.CONFLICT).entity("użytkownik o podanym ID nie istnieje").build();
	}
	
}
