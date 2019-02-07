package com.example.restejbjpa.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restejbjpa.domain.ComputerGame;
import com.example.restejbjpa.service.ComputerGameManager;

@Path("computergame")
@Stateless
public class ComputerGameRestService {

    @PersistenceContext
    EntityManager em;

    @Inject
    ComputerGameManager gameManager;

    @GET
    @Path("/{gameId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ComputerGame getPerson(@PathParam("gameId") Long id){
        return em.find(ComputerGame.class, id);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public List<ComputerGame> getAllComputerGames(){
        return em.createNamedQuery("computergame.getAll").getResultList();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addComputerGame(ComputerGame game){
        em.persist(game);
        return Response.status(201).entity("ComputerGame").build();
    }

    @PUT  //dziala
    @Path("/{gameId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateComputerGame(@PathParam("gameId") long id, ComputerGame game) {
        gameManager.updateComputerGame(id, game);
        return Response.status(Response.Status.OK).build();
    }
    @GET //dziala
    @Path("/developer/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ComputerGame> getByDeveloper(@PathParam("name") String name){
        return gameManager.getComputerGamesByDeveloperName(name);
    }
    @GET //dziala
    @Path("/genre/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ComputerGame> getByGenre(@PathParam("name") String name){
        return gameManager.getComputerGamesByGenreName(name);
    }

    @GET //dziala
    @Path("/multiplayer/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ComputerGame> getWithMultiplayer(@PathParam("name") boolean name){
        return gameManager.getComputerGamesWithMultiplayer(name);
    }
    @GET
    @Path("/newerThan/{yor}") //dziala
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNewer(@PathParam("yor") String relDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(relDate);
            return Response.ok(gameManager.getNewerThan(date), MediaType.APPLICATION_JSON).build();
        } catch (ParseException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Format yyyy-MM-dd").build();
        }
    }
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "REST Persons Service is running now!";
    }

    @DELETE
    public Response clearComputerGames(){
        em.createNamedQuery("computergame.deleteAll").executeUpdate();
        return Response.status(200).build();
    }
    @DELETE //dziala
    @Path("/{gameId}")
    public Response deleteDescription(@PathParam("gameId") long id) {
        gameManager.deleteById(id);
        return Response.status(Response.Status.OK).build();
    }

}
