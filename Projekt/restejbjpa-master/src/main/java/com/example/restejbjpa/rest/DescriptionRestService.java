package com.example.restejbjpa.rest;

import com.example.restejbjpa.domain.Description;
import com.example.restejbjpa.service.DescriptionManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("description")
@Stateless
public class DescriptionRestService {

    @Inject
    private DescriptionManager descriptionManager;

    @GET  //dziala
    @Path("/{descriptionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Description getManufacturer(@PathParam("descriptionId") long id) {
        return descriptionManager.getDescription(id);
    }

    @GET  //dziala
    @Produces(MediaType.APPLICATION_JSON)
    public List<Description> getDescriptions() {
        return descriptionManager.getAllDescriptions();
    }

    @POST  //dziala
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDeveloper(Description producer) {
        descriptionManager.addDescription(producer);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT  //dziala
    @Path("/{descriptionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDescription(@PathParam("descriptionId") long id, Description producer) {
        descriptionManager.updateDescription(id, producer);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE  //dziala
    public Response clearDescriptions() {
        descriptionManager.deleteAll();
        return Response.status(Response.Status.OK).build();
    }

    @DELETE //dziala
    @Path("/{descriptionId}")
    public Response deleteDescription(@PathParam("descriptionId") long id) {
        descriptionManager.deleteById(id);
        return Response.status(Response.Status.OK).build();
    }
}