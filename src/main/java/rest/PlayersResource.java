package rest;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	public Player getPlayer(@PathParam("playerId") String playerId) throws Exception {
		if(playersCollection.isPlayerExists(playerId)) {
			return playersCollection.getPlayer(playerId);
		}
		throw new Exception("użytkownik o podanym ID nie istnieje");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postPlayer(Player player) {
		if(playersCollection.isPlayerExists(player.getId())) {
			playersCollection.addPlayer(player);
		}
	}
	
}
