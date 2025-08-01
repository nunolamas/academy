package com.ctw.workstation.teammember;


import com.ctw.workstation.bd.repositories.TeamMemberRepository;
import com.ctw.workstation.mappers.TeamMemberMappers;
import com.ctw.workstation.teammember.boundary.TeamMemberDTOInput;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.UUID;

@Path("/workstation/TeamMembers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeamMemberResource {

    @Inject
    TeamMemberRepository TeamMemberRepository;

    @Inject
    TeamMemberMappers mapper;

    @GET
    @APIResponse(responseCode = "200")
    public Response getTeamMembers() {
        return Response.ok(mapper.toTeamMemberDTOList(TeamMemberRepository.findAll().list())).build();
    }

    @GET
    @Path("/{id}")
    public Response getSingleTeamMember(@PathParam("id") UUID id) {
        return Response.ok(mapper.toTeamMemberDTO(TeamMemberRepository.findById(id))).build();
    }

    @POST
    public Response saveTeamMember(TeamMemberDTOInput TeamMember) {

        try {
            TeamMemberRepository.persist(mapper.toTeamMemberEntity(TeamMember));
            return Response.status(Response.Status.CREATED).entity(TeamMember).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        }
    }

    @DELETE
    @Path("/remove/{id}")
    public Response deleteTeamMember(@PathParam("id") UUID id) {
        TeamMemberRepository.deleteById(id);
        return Response.status(Response.Status.OK).build();
    }

}