package net.sghill.rescuebuddies.resources;

import net.sghill.rescuebuddies.api.FosterParent;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.UUID;

@Path("/foster-parents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FosterParentResource {

    @PUT
    @Path("/{id}")
    public Response create(@PathParam("id") UUID id, FosterParent fosterParent, @Context UriInfo uriInfo) {
        return Response.created(uriInfo.getAbsolutePathBuilder().build(id)).build();
    }
}
