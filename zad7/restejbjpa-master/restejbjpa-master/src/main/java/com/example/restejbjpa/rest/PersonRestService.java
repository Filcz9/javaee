package com.example.restejbjpa.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restejbjpa.domain.ComputerGame;

@Path("computergame")
@Stateless
public class ComputerGameRestService {	
	
	@PersistenceContext
	EntityManager em;
	
	@GET
	@Path("/{computergameId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ComputerGame getComputerGame(@PathParam("computergameId") Long id){
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
	public Response addComputerGame(ComputerGame computergame){
		em.persist(computergame);
		return Response.status(201).entity("ComputerGame").build(); 
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "REST ComputerGames Service is running now!";
	}
	
	@DELETE
	public Response clearComputerGames(){
		em.createNamedQuery("computergame.deleteAll").executeUpdate();
		return Response.status(200).build();
	}

}
