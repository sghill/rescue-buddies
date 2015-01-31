package net.sghill.rescuebuddies.resources;

import net.sghill.rescuebuddies.jdbi.BuddiesDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status;

@Path("/buddies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BuddiesResource {
    private final BuddiesDAO dao;

    public BuddiesResource(BuddiesDAO dao) {
        this.dao = dao;
    }

    @GET
    public Response show() {
        return Response.status(Status.OK).build();
    }

}
