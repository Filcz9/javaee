package com.example.restejbjpa.rest;

import com.example.restejbjpa.domain.Developer;
import com.example.restejbjpa.service.DeveloperManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("developer")
@Stateless
public class DeveloperRestService {

    @Inject
    private DeveloperManager developerManager;

    @GET  //dziala
    @Path("/{developerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer getManufacturer(@PathParam("developerId") long id) {
        return developerManager.getDeveloper(id);
    }

    @GET  //dziala
    @Produces(MediaType.APPLICATION_JSON)
    public List<Developer> getDevelopers() {
        return developerManager.getAllDevelopers();
    }

    @POST  //dziala
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDeveloper(Developer producer) {
        developerManager.addDeveloper(producer);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT  //dziala
    @Path("/{developerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDeveloper(@PathParam("developerId") long id, Developer producer) {
        developerManager.updateDeveloper(id, producer);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE  //dziala
    public Response clearDevelopers() {
        developerManager.deleteAll();
        return Response.status(Response.Status.OK).build();
    }

    @DELETE //dziala
    @Path("/{developerId}")
    public Response deleteDeveloper(@PathParam("developerId") long id) {
        developerManager.deleteById(id);
        return Response.status(Response.Status.OK).build();
    }
}