package rest.application;

import org.glassfish.jersey.server.ResourceConfig;

import rest.ClubsResource;
import rest.CoachesResource;
import rest.PlayersResource;

public class RestApplication extends ResourceConfig {

	public RestApplication() {
	    register(ClubsResource.class);
	    register(CoachesResource.class);
        register(PlayersResource.class);
    }
	
}
