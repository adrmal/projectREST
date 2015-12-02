package rest.application;

import org.glassfish.jersey.server.ResourceConfig;
import rest.PlayersResource;

public class RestApplication extends ResourceConfig {

	public RestApplication() {
        register(PlayersResource.class);
    }
	
}
