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
import repositories.PlayersRepository;

@Path("/players")
public class PlayersResource {

	private PlayersRepository playersRepository = new PlayersRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Player> getPlayers() {
		return playersRepository.getPlayers();
	}
	
	@Path("/{playerId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Player getPlayer(@PathParam("playerId") String playerId) throws Exception {
		if(playersRepository.isPlayerExists(playerId)) {
			return playersRepository.getPlayer(playerId);
		}
		throw new Exception("użytkownik o podanym ID nie istnieje");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postPlayer(Player player) {
		if(playersRepository.isPlayerExists(player.getId())) {
			playersRepository.addPlayer(player);
		}
	}
	
}
