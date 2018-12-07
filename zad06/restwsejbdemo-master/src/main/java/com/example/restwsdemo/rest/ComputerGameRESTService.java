package com.example.restwsdemo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restwsdemo.domain.ComputerGame;
import com.example.restwsdemo.service.ComputerGameManager;

@Path("computergame")
@Stateless
public class ComputerGameRESTService {

	@Inject
	private ComputerGameManager gm;

	@GET
	@Path("/{computergameId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ComputerGame getComputerGame(@PathParam("computergameId") Integer id) {
		ComputerGame p = gm.getComputerGame(id);
		return p;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ComputerGame> getComputerGames() {
		return gm.getAllComputerGames();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addComputerGame(ComputerGame computergame) {
		gm.addComputerGame(computergame);

		return Response.status(201).entity("ComputerGame").build();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "REST API /computergame is running today!";
	}

	@DELETE
	public Response clearComputerGames() {
		gm.deleteAllComputerGames();
		return Response.status(200).build();
	}

}
