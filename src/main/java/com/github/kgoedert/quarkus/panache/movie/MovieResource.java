package com.github.kgoedert.quarkus.panache.movie;

import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/movies")
public class MovieResource {

    @Transactional
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return "get all movies";
    }

    @POST

    public String add(Movie movie){
        movie.persist();
        return "adding a new movie";
    }

    @PATCH
    public String update(){
        return "updaet teh movie";
    }

    @DELETE
    public String delete(){
        return "deleted the movie";
    }
}