package rest.application;

import org.glassfish.jersey.server.ResourceConfig;

import io.swagger.jaxrs.config.BeanConfig;
import rest.ClubsResource;
import rest.CoachesResource;
import rest.PlayersResource;

public class RestApplication extends ResourceConfig {

	public RestApplication() {
	    register(ClubsResource.class);
	    register(CoachesResource.class);
        register(PlayersResource.class);
        
        packages("io.swagger.jaxrs.listing");
        
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("");
        beanConfig.setResourcePackage("rest");
        beanConfig.setScan(true);
    }
	
}
