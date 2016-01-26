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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import model.Coach;
import model.collections.CoachesCollection;

@Path("/coaches")
@Api(value="/coaches")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoachesResource {

    private static CoachesCollection coachesCollection = new CoachesCollection();
    
    @GET
    @ApiOperation(value = "shows all list of coaches")
	@ApiResponses(value = @ApiResponse(code = 200, message = "found whole list of coaches"))
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoaches() {
        return Response.status(Response.Status.OK).entity(coachesCollection.getCoaches()).build();
    }
    
    @Path("/{coachId}")
    @GET
    @ApiOperation(value = "shows coach with given ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "coach with given ID exists"),
			@ApiResponse(code = 404, message = "coach with given ID doesn't exist")
	})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoach(@ApiParam(value = "ID of coach", required = true) @PathParam("coachId") @NotBlank String coachId) {
        if(coachesCollection.isCoachExists(coachId)) {
            return Response.status(Response.Status.OK).entity(coachesCollection.getCoach(coachId)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("trener o podanym ID nie istnieje").build();
    }
    
    @POST
    @ApiOperation(value = "adds coach to list")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "coach added to list"),
			@ApiResponse(code = 409, message = "coach with given ID already exists, nothing has been done")
	})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postCoach(@ApiParam(value = "coach") @Valid Coach coach) {
        if(!coachesCollection.isCoachExists(coach.getId())) {
            coachesCollection.addCoach(coach);
            return Response.status(Response.Status.CREATED).entity(coach).build();
        }
        return Response.status(Response.Status.CONFLICT).entity("trener o podanym ID już istnieje").build();
    }
    
    @Path("/{coachId}")
    @PUT
    @ApiOperation(value = "changes coach with given ID")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "coach changed"),
			@ApiResponse(code = 404, message = "coach with given ID doesn't exist")
	})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putCoach(@ApiParam(value = "ID of coach", required = true) @PathParam("coachId") @NotBlank String coachId, @Valid Coach coach) {
        if(coachesCollection.isCoachExists(coachId)) {
            coachesCollection.modifyCoach(coachId, coach);
            return Response.status(Response.Status.CREATED).entity(coach).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("trener o podanym ID nie istnieje").build();
    }
    
    @Path("/{coachId}")
    @DELETE
    @ApiOperation(value = "deletes coach with given ID from list")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "coach deleted"),
			@ApiResponse(code = 404, message = "coach with given ID doesn't exist")
	})
    public Response deleteCoach(@ApiParam(value = "ID of coach", required = true) @PathParam("coachId") @NotBlank String coachId) {
        if(coachesCollection.isCoachExists(coachId)) {
            coachesCollection.removeCoach(coachId);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("trener o podanym ID nie istnieje").build();
    }
    
}
