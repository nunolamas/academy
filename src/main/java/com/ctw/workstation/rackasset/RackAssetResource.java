package com.ctw.workstation.rackasset;

import com.ctw.workstation.bd.repositories.RackAssetRepository;
import com.ctw.workstation.mappers.RackAssetMappers;
import com.ctw.workstation.rackasset.boundary.RackAssetDTOInput;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.UUID;

@Path("/workstation/RackAssets/assets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class RackAssetResource {


    @Inject
    RackAssetRepository RackAssetRepository;

    @Inject
    RackAssetMappers mapper;

    @GET
    @APIResponse(responseCode = "200")
    public Response getRackAssets() {
        return Response.ok(mapper.toRackAssetDTOList(RackAssetRepository.findAll().list())).build();
    }

    @GET
    @Path("/{id}")
    public Response getSingleRackAsset(@PathParam("id") UUID id) {
        return Response.ok(mapper.toRackAssetDTO(RackAssetRepository.findById(id))).build();
    }


    @POST
    public Response saveRackAsset(RackAssetDTOInput RackAsset) {

        try {
            RackAssetRepository.persist(mapper.toRackAssetEntity(RackAsset));
            return Response.status(Response.Status.CREATED).entity(RackAsset).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        }
    }

    @DELETE
    @Path("/remove/{id}")
    public Response deleteRackAsset(@PathParam("id") UUID id) {
        RackAssetRepository.deleteById(id);
        return Response.status(Response.Status.OK).build();
    }

}
