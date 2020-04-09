package com.github.kgoedert.quarkus.panache.movie;

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

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {
    @Inject
    MovieRepository movieRepo;

    @GET
    public List<Movie> getAll() {
        return movieRepo.listAll();
    }

    @POST
    @Transactional
    public Response add(Movie movie) {
        if (this.isValid(movie, null)) {
            movieRepo.persist(movie);
            return Response.status(Status.CREATED).entity("Movie created successfully").build();
        } else {
            return Response.status(Status.BAD_REQUEST).entity("Movie already exists").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Movie movie) {
        if (this.isValid(movie, id)) {
            Movie m = movieRepo.findById(id);
            if(m == null){
                throw new WebApplicationException(Status.NOT_FOUND);
            }
            m.update(movie);
            return Response.status(Status.OK).entity(movie).build();
        } else {
            return Response.status(Status.BAD_REQUEST).entity("Movie already exists").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Movie movie = movieRepo.findById(id);
        movieRepo.delete(movie);
        return Response.status(Status.OK).entity(movie).build();
    }

    private boolean isValid(Movie movie, Long id) {
        Movie currentMovie = movieRepo.find("title", movie.getTitle()).firstResult();
        if (currentMovie != null && !currentMovie.getId().equals(id)) {
            return false;
        }
        return true;
    }
}