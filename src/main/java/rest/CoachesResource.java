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

import model.Coach;
import model.collections.CoachesCollection;

@Path("/coaches")
public class CoachesResource {

    private static CoachesCollection coachesCollection = new CoachesCollection();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoaches() {
        return Response.status(Response.Status.OK).entity(coachesCollection.getCoaches()).build();
    }
    
    @Path("/{coachId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoach(@PathParam("coachId") String coachId) {
        if(coachesCollection.isCoachExists(coachId)) {
            return Response.status(Response.Status.OK).entity(coachesCollection.getCoach(coachId)).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("trener o podanym ID nie istnieje").build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postCoach(Coach coach) {
        if(!coachesCollection.isCoachExists(coach.getId())) {
            coachesCollection.addCoach(coach);
            return Response.status(Response.Status.CREATED).entity(coach).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("trener o podanym ID już istnieje").build();
    }
    
    @Path("/{coachId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putCoach(@PathParam("coachId") String coachId, Coach coach) {
        if(coachesCollection.isCoachExists(coachId)) {
            coachesCollection.modifyCoach(coachId, coach);
            return Response.status(Response.Status.CREATED).entity(coach).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("trener o podanym ID nie istnieje").build();
    }
    
    @Path("/{coachId}")
    @DELETE
    public Response deleteCoach(@PathParam("coachId") String coachId) {
        if(coachesCollection.isCoachExists(coachId)) {
            coachesCollection.removeCoach(coachId);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("trener o podanym ID nie istnieje").build();
    }
    
}
