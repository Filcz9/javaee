package com.example.restejbjpa.rest;

import com.example.restejbjpa.domain.Genre;
import com.example.restejbjpa.service.GenreManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("genre")
@Stateless
public class GenreRestService {

    @Inject
    private GenreManager genreManager;

    @GET  //dziala
    @Path("/{genreId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Genre getGenre(@PathParam("genreId") Long id) {
        return genreManager.getGenre(id);
    }

    @GET  //dziala
    @Produces(MediaType.APPLICATION_JSON)
    public List<Genre> getGenres() {
        return genreManager.getAllGenres();
    }

    @GET  //dziala
    @Path("/name/{sName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Genre getGenre(@PathParam("sName") String name) {
        return genreManager.getByName(name);
    }


    @POST  //dziala
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGenre(Genre resolution) {
        genreManager.addGenre(resolution);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT  //dziala
    @Path("/{genreId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Genre updateGenre(@PathParam("genreId") long id, Genre resolution) {
        return genreManager.updateGenre(id, resolution);
    }

    @DELETE  //dziala
    public Response clearGenres() {
        genreManager.deleteAll();
        return Response.status(Response.Status.OK).build();
    }

    @DELETE //dziala
    @Path("/{genreId}")
    public Response deleteGenre(@PathParam("genreId") long id) {
        genreManager.deleteById(id);
        return Response.status(Response.Status.OK).build();
    }
}