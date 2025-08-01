package com.ctw.workstation.booking;

import com.ctw.workstation.bd.repositories.BookingRepository;
import com.ctw.workstation.booking.boundary.BookingDTOInput;
import com.ctw.workstation.mappers.BookingMappers;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Path("/workstation/bookings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingResource {

    @Inject
    BookingRepository BookingRepository;

    @Inject
    BookingMappers mapper;

    @GET
    @APIResponse(responseCode = "200")
    public Response getBookings() {
        return Response.ok(mapper.toBookingDTOList(BookingRepository.findAll().list())).build();
    }

    @GET
    @Path("/{id}")
    public Response getSingleBooking(@PathParam("id") UUID id) {
        return Response.ok(mapper.toBookingDTO(BookingRepository.findById(id))).build();
    }


    @POST
    public Response saveBooking(BookingDTOInput Booking) {

        try {
            BookingRepository.persist(mapper.toBookingEntity(Booking));
            return Response.status(Response.Status.CREATED).entity(Booking).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        }
    }

    @DELETE
    @Path("/remove/{id}")
    public Response deleteBooking(@PathParam("id") UUID id) {
        BookingRepository.deleteById(id);
        return Response.status(Response.Status.OK).build();
    }



    @DELETE
    @Path("/remove/rack/{rackId}")
    public Response deleteSingleRacksBooking(@PathParam("rackId") UUID id) {
        BookingRepository.deleteAllByRackId(id);
        return Response.status(Response.Status.OK).build();
    }
}
