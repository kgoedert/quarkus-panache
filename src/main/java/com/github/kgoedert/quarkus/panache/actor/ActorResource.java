package com.github.kgoedert.quarkus.panache.actor;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/actors")
@Produces(MediaType.APPLICATION_JSON)
public class ActorResource {
    @Inject
    ActorRepository actorRepo;

    @GET
    public List<Actor> getAll() {
        return actorRepo.listAll();
    }

    @POST
    @Transactional
    public Response add(Actor actor) {
            actorRepo.persist(actor);
            return Response.status(Status.CREATED).entity("Actor created successfully").build();
        
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Actor actor) {
            Actor act = actorRepo.findById(id);
            if(act == null){
                throw new WebApplicationException(Status.NOT_FOUND);
            }
            act.update(actor);
            return Response.status(Status.OK).entity(actor).build();
        
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Actor actor = actorRepo.findById(id);
        actorRepo.delete(actor);
        return Response.status(Status.OK).entity(actor).build();
    }
}