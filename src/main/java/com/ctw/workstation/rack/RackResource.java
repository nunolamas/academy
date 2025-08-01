package com.ctw.workstation.rack;

import com.ctw.workstation.bd.entities.RackEntity;
import com.ctw.workstation.bd.entities.StatusEnum;
import com.ctw.workstation.bd.repositories.RackRepository;
import com.ctw.workstation.mappers.RackMappers;
import com.ctw.workstation.rack.boundary.RackDTOInput;
import com.ctw.workstation.rack.boundary.RackDTOOutput;
import com.ctw.workstation.rack.boundary.RackStatusDTOInput;
import com.ctw.workstation.services.RackService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.json.*;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.logging.Logger;

import java.io.InputStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.*;

@Path("/workstation/racks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RackResource {

    //private static final Logger logger = Logger.getLogger(RackResource.class);

    @Inject
    Logger log;

    @Inject
    RackRepository rackRepository;

    @Inject
    RackService rackService;

    @Inject
    RackMappers mapper;

    @Inject
    ObjectMapper objectMapper;


    @GET
    @APIResponse(responseCode = "200")
    public Response getRacks() {
        try {
            return Response.ok(rackService.getAllRacks()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getSingleRack(@PathParam("id") UUID id) {
        try {
            return Response.ok(rackService.getSingleRack(id)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        }
    }

    @POST
    public Response saveRack(RackDTOInput rack) {

        try {
            rackService.saveRack(rack);
            return Response.status(Response.Status.CREATED).entity(rack).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        }
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRackStatus(@PathParam("id") UUID id, RackStatusDTOInput dto) {
        boolean success = rackRepository.updateStatus(id, dto.getStatus());

        if (success) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/remove/{id}")
    public Response deleteRack(@PathParam("id") UUID id) {
        try {
            return rackService.deleteRack(id);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        }

    }

}
