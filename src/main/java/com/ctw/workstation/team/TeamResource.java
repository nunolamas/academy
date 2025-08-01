package com.ctw.workstation.team;

import com.ctw.workstation.bd.repositories.TeamRepository;
import com.ctw.workstation.mappers.TeamMappers;
import com.ctw.workstation.team.boundary.TeamDTOInput;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.UUID;

@Path("/workstation/teams")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamResource {

    @Inject
    TeamRepository TeamRepository;

    @Inject
    TeamMappers mapper;

    @GET
    @APIResponse(responseCode = "200")
    public Response getTeams() {
        return Response.ok(mapper.toTeamDTOList(TeamRepository.findAll().list())).build();
    }

    @GET
    @Path("/{id}")
    public Response getSingleTeam(@PathParam("id") UUID id) {
        return Response.ok(mapper.toTeamDTO(TeamRepository.findById(id))).build();
    }

    @POST
    public Response saveTeam(TeamDTOInput Team) {

        try {
            TeamRepository.persist(mapper.toTeamEntity(Team));
            return Response.status(Response.Status.CREATED).entity(Team).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        }
    }

    @DELETE
    @Path("/remove/{id}")
    public Response deleteTeam(@PathParam("id") UUID id) {
        TeamRepository.deleteById(id);
        return Response.status(Response.Status.OK).build();
    }

}
